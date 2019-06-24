package treeoperator;

import domain.TreeNodeOff;

public class SameTree {
	public boolean isSameTree(TreeNodeOff p, TreeNodeOff q) {
		if(p == null) return q == null;
		if(q == null) return p == null;
		if(p.val != q.val) return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
