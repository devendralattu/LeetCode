/* https://leetcode.com/problems/merge-intervals */

package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class MergeIntervals {

	public static void main(String[] args) {

		Interval[] intervalArray = new Interval[4];
		intervalArray[0] = new Interval(8, 10);
		intervalArray[1] = new Interval(1, 3);
		intervalArray[2] = new Interval(15, 18);
		intervalArray[3] = new Interval(2, 6);

		List<Interval> list = new ArrayList<>();
		list.addAll(Arrays.asList(intervalArray));

		System.out.println("Initial intervals list:");
		printIntervals(list);

		sortIntervals(list);
		System.out.println("Sorted intervals list:");
		printIntervals(list);

		list = merge(list);
		System.out.println("Merged intervals list:");
		printIntervals(list);
	}

	private static void printIntervals(List<Interval> list) {
		for (Interval interval : list) {
			System.out.println(interval.start + " to " + interval.end);
		}
		System.out.println();
	}

	private static void sortIntervals(List<Interval> list) {
		Comparator<Interval> sortByStart = new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}

		};
		Collections.sort(list, sortByStart);
	}

	private static List<Interval> merge(List<Interval> list) {

		List<Interval> result = new ArrayList<>();

		int start = list.get(0).start;
		int end = list.get(0).end;

		for (Interval interval : list) {
			if (interval.start <= end) {
				end = Math.max(end, interval.end);
			} else {
				Interval temp = new Interval(start, end);
				result.add(temp);
				start = interval.start;
				end = interval.end;
			}
		}

		Interval temp = new Interval(start, end);
		result.add(temp);

		return result;
	}

}

/** Output
Initial intervals list:
8 to 10
1 to 3
15 to 18
2 to 6

Sorted intervals list:
1 to 3
2 to 6
8 to 10
15 to 18

Merged intervals list:
1 to 6
8 to 10
15 to 18
**/
