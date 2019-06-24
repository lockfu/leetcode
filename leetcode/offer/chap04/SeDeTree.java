package chap04;

import java.util.ArrayList;
import java.util.List;

import domain.TreeNodeOff;

public class SeDeTree {
	public static List<Integer> seriable(TreeNodeOff head){
		List<Integer> res = new ArrayList<>();
		if(head == null) return res;
		TreeNodeOff node = head;
		seriable(node, res);
		return res;
	}
	public static void seriable(TreeNodeOff node, List<Integer> res){
		if(node == null){
			res.add(-1);
			return ;
		}
		res.add(node.val);
		seriable(node.left, res);
		seriable(node.right, res);
	}
	
	public static void deseriable(TreeNodeOff root, List<Integer> res){
		if(res.isEmpty()) return ;
		if(res.indexOf(0) != -1){
			root = new TreeNodeOff(res.indexOf(0));
			deseriable(root.left, res.subList(1, res.size()));
			deseriable(root.right, res.subList(1, res.size()));
		}
	}
	
	public static void main(String[] args) {
		
	}
	
	
}
