package searchandsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
	
	public static List<Integer> topKFrequent1(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
        if(null == nums || nums.length <= 0)
            return res;
        Map<Integer, Integer> map = new HashMap<>();
        for(int item : nums){
            if(map.containsKey(item)){
                map.put(item, map.get(item)+1);
            }else{
                map.put(item, 1);
            }
        }
        for(int i = 0; i<k; i++){
        	int max = Integer.MIN_VALUE;
        	int kth = 0;
        	for(Map.Entry<Integer, Integer> item : map.entrySet()){
        		int key = item.getKey();
        		if(res.contains(key))
        			continue;
        		int value = item.getValue();
        		if(value > max){
        			max = value;
        			kth = key;
        		}
        	}
        	res.add(kth);
        }
        return res;
	}
	
	public static List<Integer> topKFrequent2(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
        if(null == nums || nums.length <= 0)
            return res;
        Map<Integer, Integer> map = new HashMap<>();
        for(int item : nums){
            if(map.containsKey(item)){
                map.put(item, map.get(item)+1);
            }else{
                map.put(item, 1);
            }
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int key : map.keySet()){
        	int frequency = map.get(key);
        	if(bucket[frequency] == null)
        		bucket[frequency] = new ArrayList<>();
        	bucket[frequency].add(key);	
        }
        for(int i = bucket.length - 1; i >= 0 && res.size() < k; i++){
        	if(bucket[i] != null)
        		res.addAll(bucket[i]);
        }
        return res;
	}
	
	public static void main(String[] args) {
		int[] nums= {1,1,2,3,4,4,4,2,5,7,7,7,7};
		List<Integer> res = topKFrequent1(nums,2);
		System.out.println(res);
	}
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(null == nums || nums.length <= 0)
            return res;
        Map<Integer, Integer> map = new HashMap<>();
        for(int item : nums){
            if(map.containsKey(item)){
                map.put(item, map.get(item)+1);
            }else{
                map.put(item, 1);
            }
        }
        List<Node> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> item : map.entrySet()){
        	int key =  item.getKey();
        	int value = item.getValue();
        	list.add(new Node(key, value));
        }
        LinkedList<Node> llist = new LinkedList<>();
        llist.add(list.get(0));
        for(int j = 1; j<list.size(); j++){
        	Node node = list.get(j);
    		for(int i = 0; i<llist.size(); i++){
        		if(node.num > llist.get(i).num){
        			llist.add(i, node);
        		}else{
        			if(i == llist.size() - 1){
        				llist.addLast(node);
        			}
        		}
        	}
        }
        for(int i = 0; i<k; i++){
        	if(i > llist.size())
        		break;
        	res.add(llist.get(i).key);
        }
        return res;
    }
	class Node{
		int key;
		int num;
		Node(int key, int num){
			this.key = key;
			this.num = num;
		}
	}
}
