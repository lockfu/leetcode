package treeoperator;

import java.util.LinkedList;

import domain.TreeNodeOff;

public class PostOrder {
	public static void printPostOrder(TreeNodeOff node){
        if(node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.val + " ");
    }
	
	public static void printPostOrderRec(TreeNodeOff head){
		LinkedList<TreeNodeOff> st = new LinkedList<>();
		if(head != null)
			st.push(head);
		while(!st.isEmpty()){
			TreeNodeOff node = st.peek();
			if(node.left == null && node.right == null)
				System.out.print(st.poll().val + " ");
			else{
				if(node.right != null){
					st.push(node.right);
					node.right = null;
				}
				if(node.left != null){
					st.push(node.left);
					node.left = null;
				}
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
		
		System.out.println("------------ postorder -----------");
		TreeNodeOff cur = head;
		printPostOrder(cur);
		System.out.println();
		System.out.println(" rec ");
		cur = head;
		printPostOrderRec(cur);
		System.out.println();
	}
}
