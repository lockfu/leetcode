package treeandGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSmaller {
	class Node{
		int val, sum, dup = 1;
		Node left, right;
		Node(int x){val = x;}
	}
	public List<Integer> countSmaller(int[] nums){
		List<Integer> res = new ArrayList<>();
		if(nums == null || nums.length == 0)
			return res;
		Node root = null;
		Integer[] ans = new Integer[nums.length];
		for(int i = 0; i<nums.length; i++){
			root = insert(nums[i], root, ans, i, 0);
		}
		return Arrays.asList(ans);
	}
	private Node insert(int num, Node node, Integer[] ans, int i, int presum){
		if(node == null){
			node = new Node(num);
			ans[i] = presum;
		}else if(node.val == num){
			node.dup++;
			ans[i] = presum + node.sum;
		}else if(node.val > num){
			node.sum++;
			node.left = insert(num, node.left, ans, i, presum);
		}else{
			node.right = insert(num, node.right, ans, i, presum + node.sum + node.dup);
		}
		return node;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		map.containsKey(1);
	}
}
