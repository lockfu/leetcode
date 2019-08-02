package chap04;

import java.util.LinkedList;
import java.util.Queue;

import domain.TreeNodeOff;

public class LevelBinTree2 {
	public static void printTree(TreeNodeOff root){
		if(null == root) return;
		Queue<TreeNodeOff> q = new LinkedList<>();
		q.add(root);
		int toBePrint = 1;
		int nextprint = 0;
		while(!q.isEmpty()){
			TreeNodeOff cur = q.poll();
			--toBePrint;
			System.out.print(cur.val + " ");
			if(cur.left != null){
				q.add(cur.left);
				nextprint++;
			}
			if(cur.right != null){
				q.add(cur.right);
				nextprint++;
			}
			if(toBePrint == 0){
				System.out.println();
				toBePrint = nextprint;
				nextprint = 0;
			}
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
