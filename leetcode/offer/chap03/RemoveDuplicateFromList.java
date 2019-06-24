package chap03;

import domain.ListNode;

public class RemoveDuplicateFromList {
	public ListNode deleteNode(ListNode head){
		ListNode cur = head;
		while(cur != null && cur.next != null){
			if(cur.val == cur.next.val){
				cur.next = cur.next.next;
			}else{
				cur = cur.next;
			}
		}
		return head;
	}
}
