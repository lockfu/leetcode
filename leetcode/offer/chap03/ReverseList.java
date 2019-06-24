package chap03;

import domain.ListNode;

public class ReverseList {
	public static ListNode reverse(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode pre = null;
		ListNode cur = head;
		while(cur != null){
			ListNode newNode = new ListNode(cur.val);
			newNode.next = pre;
			pre = newNode;
			cur = cur.next;
		}
		return pre;
	}
	
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode r1 = new ListNode(2);
		ListNode r2 = new ListNode(3);
		ListNode r3 = new ListNode(4);
		ListNode r4 = new ListNode(5);
		root.next = r1;
		r1.next = r2;
		r2.next = r3;
		r3.next = r4;
		ListNode res = reverse(root);
		while(res != null){
			System.out.print(res.val + " -> ");
			res = res.next;
		}
	}
}
