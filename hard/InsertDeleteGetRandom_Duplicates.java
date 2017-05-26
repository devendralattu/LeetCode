// 381. Insert Delete GetRandom O(1) - Duplicates allowed
// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/#/description

public class RandomizedCollection {

  List<Integer> list;
	Map<Integer, Set<Integer>> map;
	Map<Integer, Integer> posMap;

	/** Initialize your data structure here. */
	public RandomizedCollection() {
		list = new ArrayList<Integer>();
		map = new HashMap<Integer, Set<Integer>>();
		posMap = new HashMap<Integer, Integer>();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		boolean containsElement = true;
		Set<Integer> mapSetList = new HashSet<Integer>();

		if (map.containsKey(val)) {
			containsElement = false;
			mapSetList = map.get(val);
		}
		mapSetList.add(list.size());
		map.put(val, mapSetList);

		posMap.put(list.size(), val);
		list.add(val);

		return containsElement;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {
		boolean containsElement = false;
		Set<Integer> mapSetList = new HashSet<Integer>();

		if (map.containsKey(val)) {
			containsElement = true;

			mapSetList = map.get(val);
			List<Integer> setList = new ArrayList<>(mapSetList);
			int index = setList.get(0);

			mapSetList.remove(index);

			// remove the key from Map if Set size is 0
			if (mapSetList.size() == 0) {
				map.remove(val);
			}

			// check if the index is at the end of the list
			if (index + 1 == list.size()) {
				// last element from list is removed
				list.remove(index);
				posMap.remove(index);
			} else {
				// add last element from list to the index
				list.set(index, list.get(list.size() - 1));
				posMap.put(index, posMap.get(list.size() - 1));

				// set map index
				int mapIdxVal = list.get(list.size() - 1);
				mapSetList = map.get(mapIdxVal);
				mapSetList.remove(list.size() - 1);

				// remove from posMap and list
				posMap.remove(list.size() - 1);
				list.remove(list.size() - 1);

				// add the new index to Set and thus Map
				mapSetList.add(index);
			}
		}

		return containsElement;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		int rand = (int) (Math.random() * list.size());
		return list.get(rand);
	}
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
