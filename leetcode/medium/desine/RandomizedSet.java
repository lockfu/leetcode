package desine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
//	HashSet<Integer> set = new HashSet<>();
//	/** Initialize your data structure here. */
//	public RandomizedSet() {
//	}
//
//	/**
//	 * Inserts a value to the set. Returns true if the set did not already
//	 * contain the specified element.
//	 */
//	public boolean insert(int val) {
//		return set.add(val);
//	}
//
//	/**
//	 * Removes a value from the set. Returns true if the set contained the
//	 * specified element.
//	 */
//	public boolean remove(int val) {
//		return set.remove(val);
//	}
//
//	/** Get a random element from the set. */
//	public int getRandom() {
//		Random r = new Random();
//		int rr = r.nextInt(set.size());
//		return (int)set.toArray()[rr];
//	}
	
	
	
	List<Integer> list;
	Map<Integer, Integer> set ;
	Random rand = new Random();
	/** Initialize your data structure here. */
	public RandomizedSet() {
		 list = new ArrayList<>();
		 set = new HashMap<>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if(set.containsKey(val)) return false;
		set.put(val, list.size());
		list.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if(!set.containsKey(val)) return false;
		int last = list.get(list.size()-1);
		int loc = set.get(val);
		list.set(loc,last);
		set.put(last,loc);
		list.remove(list.size()-1);
		set.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.get(rand.nextInt(list.size()));
	}
}
