package chap04;

import java.util.LinkedList;
import java.util.Queue;

import domain.TreeNodeOff;

public class LevelBinTree {
	public static void printTree(TreeNodeOff root){
		if(null == root) return;
		Queue<TreeNodeOff> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			TreeNodeOff cur = q.poll();
			System.out.print(cur.val + " ");
			if(cur.left != null)
				q.add(cur.left);
			if(cur.right != null)
				q.add(cur.right);
		}
	}
	
	public static void main(String[] args) {
		TreeNodeOff root = new TreeNodeOff(8);
		TreeNodeOff l1 = new TreeNodeOff(6);
		TreeNodeOff r1 = new TreeNodeOff(10);
		l1.left = new TreeNodeOff(5);
		l1.right = new TreeNodeOff(7);
		r1.left = new TreeNodeOff(9);
		r1.right = new TreeNodeOff(11);
		root.left = l1;
		root.right = r1;
		
		printTree(root);
		
	}
}
