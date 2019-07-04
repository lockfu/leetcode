package chap06;

import domain.TreeNodeOff;

public class IsBalanceTree {
	public static boolean isBalanceTree(TreeNodeOff node){
		if(node == null) return true;
		int left = treeDepth(node.left);
		int right = treeDepth(node.right);
		int diff = Math.abs(left - right);
		if(diff > 1) return false;
		return isBalanceTree(node.left) && isBalanceTree(node.right);
	}
	
	public static int treeDepth(TreeNodeOff node){
		if(node == null) return 0;
		int left = treeDepth(node.left);
		int right = treeDepth(node.right);
		return left > right ? (left + 1) : (right + 1);
	}
	
	
	public static boolean isBalanceTree_2(TreeNodeOff node, int depth){
		if(node == null) {
			depth = 0;
			return true;
		}
		int left = 0, right = 0;
		if(isBalanceTree_2(node.left, left) && isBalanceTree_2(node.right, right)){
			int diff = left - right;
			if(diff <=1 && diff >=-1){
				depth = 1 + (left > right ? left : right);
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
