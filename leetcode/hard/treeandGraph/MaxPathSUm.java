package treeandGraph;

import domain.TreeNodeOff;

public class MaxPathSUm {
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNodeOff root){
		helper(root);
		return max;
	}
	public int helper(TreeNodeOff node){
		if(node == null) return 0;
		int left = helper(node.left);
		int right = helper(node.right);
		max = Math.max(max, node.val);
		max = Math.max(max, node.val + left + right);
		max = Math.max(max, node.val + Math.max(left, right));
		return Math.max(node.val, node.val + Math.max(left, right));
	}
	
	public int helper1(TreeNodeOff node, int res){
		if(node == null) return 0;
		int left = Math.max(helper1(node.left, res),0);
		int right = Math.max(helper1(node.right, res),0);
		res = Math.max(res, node.val + left + right);
		return Math.max(left, right) + node.val;
	}
}
