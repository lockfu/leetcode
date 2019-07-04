package chap06;

import domain.TreeNodeOff;

public class TreeDepth {
	public static int treeDepth(TreeNodeOff node){
		if(node == null) return 0;
		int left = treeDepth(node.left);
		int right = treeDepth(node.right);
		return left > right ? (left + 1) : (right + 1);
	}
	
	public static void main(String[] args) {
		TreeNodeOff head = new TreeNodeOff(1);
		TreeNodeOff l1 = new TreeNodeOff(2);
		TreeNodeOff r1 = new TreeNodeOff(3);
		l1.left = new TreeNodeOff(4);
		l1.right = new TreeNodeOff(5);
		r1.left = new TreeNodeOff(6);
		head.left = l1;
		head.right = r1;
		
		System.out.println("------------ postorder -----------");
		TreeNodeOff cur = head;
		int res = treeDepth(cur);
		System.out.println(res);
	}
}
