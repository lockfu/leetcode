package treeoperator;

import java.util.Stack;

import domain.TreeNodeOff;

public class PreOrder {
	
	public static void printPreOrder(TreeNodeOff head){
		if(head == null) return; 
		System.out.print(head.val + " ");
		printPreOrder(head.left);
		printPreOrder(head.right);
	}
	
	public static void printPreOrderRec(TreeNodeOff head){
		Stack<TreeNodeOff> st = new Stack<>();
		TreeNodeOff cur = head;
		while(cur != null || !st.isEmpty()){
			if(cur != null){
				System.out.print(cur.val + " ");
				st.push(cur);
				cur = cur.left;
			}else{
				cur = st.pop();
				cur = cur.right;
			}
		}
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
		
		System.out.println("------------ preorder -----------");
		TreeNodeOff cur = head;
		printPreOrder(cur);
		System.out.println();
		System.out.println(" rec ");
		cur = head;
		printPreOrderRec(cur);
		System.out.println();
	}
}
