package chap03;

import domain.ListNode;

public class EntryNodeOfLoop {
	
	public static ListNode encryNode(ListNode head){
		ListNode metNode = mettingNode(head);
		if(metNode == null) return null;
		int cnt = 1;
		ListNode tmp = metNode;
		while(tmp.next != metNode){
			tmp = tmp.next;
			cnt++;
		}
		ListNode p1 = head, p2 = head;
		for(int i = 1; i<= cnt; i++){
			p2 = p2.next;
		}
		while(p1 != p2){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	public static ListNode mettingNode(ListNode head){
		if(head == null || head.next == null) return null;
		ListNode slow = head, fast = head.next;
		while(slow != null && fast != null){
			if(fast == slow)
				return fast;
			slow = slow.next;
			fast = fast.next;
			if(fast != null)
				fast = fast.next;
		}
		return null;
	}
}
