package treeoperator;

import java.util.Stack;

import domain.TreeNodeOff;

public class InorderTraversal {
	public static void main(String[] args) {
		TreeNodeOff head = new TreeNodeOff(1);
		TreeNodeOff l1 = new TreeNodeOff(2);
		TreeNodeOff r1 = new TreeNodeOff(3);
		l1.left = new TreeNodeOff(4);
		l1.right = new TreeNodeOff(5);
		r1.left = new TreeNodeOff(6);
		head.left = l1;
		head.right = r1;
		
		System.out.println("------------ inorder -----------");
		TreeNodeOff cur = head;
		printInOrder(cur);
		System.out.println();
		System.out.println(" rec ");
		cur = head;
		printInOrderRec(cur);
		System.out.println();
	}
	
	
	// ÖÐÐò±éÀú
	public static void printInOrder(TreeNodeOff head){
		if(head == null) return;
		printInOrder(head.left);
		System.out.print(head.val + " ");
		printInOrder(head.right);
	}
	
	public static void printInOrderRec(TreeNodeOff head){
		Stack<TreeNodeOff> st = new Stack<>();
		TreeNodeOff cur = head;
		while(cur != null || !st.isEmpty()){
			while(cur != null){
				st.push(cur);
				cur = cur.left;
			}
			cur = st.pop();
			System.out.print(cur.val+ " ");
			cur = cur.right;
		}
	}
}
