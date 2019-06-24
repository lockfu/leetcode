package treeoperator;

import java.util.LinkedList;
import java.util.Queue;

import domain.TreeNodeOff;

public class SymmetricTree {
	public static boolean isSymmtric(TreeNodeOff root){
		return isMirror(root, root);
	}
	public static boolean isMirror(TreeNodeOff p1, TreeNodeOff p2){
		if(p1 == null && p2 == null) return true;
		if(p1 == null || p2 == null) return false;
		if(p1.val != p2.val) return false;
		return isMirror(p1.left, p2.right) && isMirror(p1.right, p2.left);
	}
	
	public boolean isSymmetric(TreeNodeOff root) {
	    Queue<TreeNodeOff> q = new LinkedList<>();
	    q.add(root);
	    q.add(root);
	    while (!q.isEmpty()) {
	    	TreeNodeOff t1 = q.poll();
	    	TreeNodeOff t2 = q.poll();
	        if (t1 == null && t2 == null) continue;
	        if (t1 == null || t2 == null) return false;
	        if (t1.val != t2.val) return false;
	        q.add(t1.left);
	        q.add(t2.right);
	        q.add(t1.right);
	        q.add(t2.left);
	    }
	    return true;
	}
}
