package top100;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache{
	
//	private int capacity;
//    
//    public LRUCache(int capacity) {
//        super(capacity, 0.75F, true);
//        this.capacity = capacity;
//    }
//    
//    public int get(int key) {
//        return super.getOrDefault(key, -1);
//    }
//    
//    public void put(int key, int value) {
//        super.put(key, value);
//    }
//    
//    @Override
//    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//        return size() > capacity;
//    }
	
	
	
	LinkedHashMap<Integer, Integer> map;
	int capacity;
	public LRUCache(int capacity){
		this.capacity = capacity;
		map = new LinkedHashMap<>(capacity+1);
	}
	public int get(int key){
		Integer val = map.get(key);
		if(val == null)
			return -1;
		else{
			map.remove(key);
			map.put(key, val.intValue());
			return val.intValue();
		}
	}
	public void put(int key, int value){
		map.remove(key);
		map.put(key, value);
		if(map.size() > capacity)
			map.remove(map.entrySet().iterator().next().getKey());
	}
}
