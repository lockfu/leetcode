package chap03;

import domain.ListNode;

public class DeleteNode {
	public static void deleteNode(ListNode head, ListNode node){
		if(head == null || node == null) return;
		if(head == node)
			head = head.next;
		else if(node.next != null){
			node.val = node.next.val;
			node.next = node.next.next;
		}else{
			node = null;
		}
	}
	
	public static void printNode(ListNode head){
		ListNode tmp = head;
		while(tmp != null){
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
//		ListNode root = new ListNode(1, null);
//		ListNode r1 = new ListNode(2, null);
//		root.next = r1; 
//		ListNode r2 = new ListNode(3, null);
//		r1.next = r2;
//		ListNode r3 = new ListNode(4, null);
//		r2.next = r3;
//		ListNode r4 = new ListNode(5, null);
//		r3.next = r4;
//		printNode(root);
//		deleteNode(root, r4);
//		printNode(root);
	}
}
