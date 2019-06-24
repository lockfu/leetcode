package chap03;

import domain.TreeNodeOff;

public class HasSubTree {
	public static boolean hasSubtree(TreeNodeOff p1, TreeNodeOff p2){
		boolean res = false;
		if(p1 != null && p2 != null){
			if(p1.val == p2.val)
				res = t1HasT2(p1, p2);
			if(!res)
				res = hasSubtree(p1.left, p2);
			if(!res)
				res = hasSubtree(p1.right, p2);
		}
		return res;
	}
	
	public static boolean t1HasT2(TreeNodeOff p1, TreeNodeOff p2){
		if(p2 == null)
			return true;
		if(p1 == null)
			return false;
		if(p1.val != p2.val) 
			return false;
		return t1HasT2(p1.left, p2.left) && t1HasT2(p1.right, p2.right);
	}
}
