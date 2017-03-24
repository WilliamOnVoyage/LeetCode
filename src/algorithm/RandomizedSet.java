package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

	/** Initialize your data structure here. */
	private HashMap<Integer, Integer> loc_map;
	private ArrayList<Integer> array;
	private Random rd;

	public RandomizedSet() {
		array = new ArrayList<>();
		loc_map = new HashMap<>();
		rd = new Random();
		rd.setSeed(1);
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if (!loc_map.containsKey(val)) {
			array.add(val);
			loc_map.put(val, array.indexOf(val));
			return true;
		} else {
			return false;
		}
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		boolean contain = loc_map.containsKey(val);
		if (!contain)
			return false;
		int loc = loc_map.get(val);
		if (loc < array.size() - 1) { // not the last one than swap the last one with this val
			int lastone = array.get(array.size() - 1);
			array.set(loc, lastone);
			loc_map.put(lastone, loc);
		}
		loc_map.remove(val);
		array.remove(array.size() - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		if (array.size() < 1)
			return 0;
		return array.get(rd.nextInt(array.size()));
	}
}
