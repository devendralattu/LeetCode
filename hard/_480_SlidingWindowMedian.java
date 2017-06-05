/*
    For example,
    Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

    Window position                Median
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       1
     1 [3  -1  -3] 5  3  6  7       -1
     1  3 [-1  -3  5] 3  6  7       -1
     1  3  -1 [-3  5  3] 6  7       3
     1  3  -1  -3 [5  3  6] 7       5
     1  3  -1  -3  5 [3  6  7]      6

    Therefore, return the median sliding window as [1,-1,-1,3,5,6].
*/


package hard;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindowMedian {

	public static void main(String[] args) {
		SlidingWindowMedian swd = new SlidingWindowMedian();
		int k = 3;
		int[] nums;
		nums = new int[] { -1, 2, 5, -3, 4, 9, 8, -1, 3 };

		double[] result = swd.medianSlidingWindow(nums, k);
		for (double d : result) {
			System.out.print(d + ", ");
		}
	}

	public double[] medianSlidingWindow(int[] nums, int k) {
		double[] result = new double[nums.length - k + 1];
		int resultIdx = 0;

		Map<Integer, Integer> minHeap = new TreeMap<>();
		Map<Integer, Integer> maxHeap = new TreeMap<>(Collections.reverseOrder());

		int minHeapCapacity = k / 2;
		AtomicInteger maxHeapSize = new AtomicInteger(0);
		AtomicInteger minHeapSize = new AtomicInteger(0);

		// Add k elements to maxHeap
		for (int i = 0; i < k; i++) {
			addToHeap(nums[i], maxHeap, maxHeapSize);
		}

		// move `minHeapCapacity` elements from maxHeap to minHeap
		for (int i = 0; i < minHeapCapacity; i++) {
			moveBetweenHeaps(maxHeap, minHeap, maxHeapSize, minHeapSize);
		}

		result[resultIdx++] = getMedian(maxHeap, minHeap, maxHeapSize, minHeapSize);

		for (int i = 0; i < nums.length - k; i++) {
			int addElem = nums[i + k];
			int topMaxElem = maxHeap.keySet().iterator().next();

			// add new elements to respective heap
			if (addElem <= topMaxElem) {
				addToHeap(addElem, maxHeap, maxHeapSize);
			} else {
				addToHeap(addElem, minHeap, minHeapSize);
			}

			int removeElem = nums[i];
			// remove old element from respective heap
			if (removeElem <= topMaxElem) {
				removeFromHeap(removeElem, maxHeap, maxHeapSize);
			} else {
				removeFromHeap(removeElem, minHeap, minHeapSize);
			}

			// rebalance the heap
			rebalanceHeap(maxHeap, minHeap, maxHeapSize, minHeapSize, minHeapCapacity);

			result[resultIdx++] = getMedian(maxHeap, minHeap, maxHeapSize, minHeapSize);
		}
		return result;
	}

	private void rebalanceHeap(Map<Integer, Integer> maxHeap, Map<Integer, Integer> minHeap, AtomicInteger maxHeapSize,
			AtomicInteger minHeapSize, int minHeapCapacity) {

		if (minHeapSize.get() > minHeapCapacity) {
			moveBetweenHeaps(minHeap, maxHeap, minHeapSize, maxHeapSize);
		} else if (minHeapSize.get() < minHeapCapacity) {
			moveBetweenHeaps(maxHeap, minHeap, maxHeapSize, minHeapSize);
		}
	}

	private double getMedian(Map<Integer, Integer> maxHeap, Map<Integer, Integer> minHeap, AtomicInteger maxHeapSize,
			AtomicInteger minHeapSize) {

		double topElemMaxHeap = maxHeap.keySet().iterator().next();
		if (maxHeapSize.get() > minHeapSize.get()) {
			return topElemMaxHeap;
		}

		// (a + b) / 2
		double topElemMinHeap = minHeap.keySet().iterator().next();
		return topElemMaxHeap + (topElemMinHeap - topElemMaxHeap) / 2.0;
	}

	private void moveBetweenHeaps(Map<Integer, Integer> maxHeap, Map<Integer, Integer> minHeap,
			AtomicInteger maxHeapSize, AtomicInteger minHeapSize) {
		int elem = maxHeap.keySet().iterator().next();
		addToHeap(elem, minHeap, minHeapSize);
		removeFromHeap(elem, maxHeap, maxHeapSize);
	}

	private void removeFromHeap(int elem, Map<Integer, Integer> heap, AtomicInteger maxHeapSize) {
		heap.put(elem, heap.get(elem) - 1);
		if (heap.get(elem) == 0) {
			heap.remove(elem);
		}
		maxHeapSize.decrementAndGet();
	}

	private void addToHeap(int val, Map<Integer, Integer> heap, AtomicInteger maxHeapSize) {
		heap.put(val, heap.getOrDefault(val, 0) + 1);
		maxHeapSize.addAndGet(1);
	}
}
