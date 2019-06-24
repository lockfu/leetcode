package chap03;

import domain.ListNode;

public class FindKthToTail {
	public static ListNode findKth(ListNode head, int k){
		if(null == head || k <= 0) return null;
		ListNode p2 = head;
		for(int i = 1; i<k; i++){
			if(p2 == null)
				return null;
			p2 = p2.next;
		}
		ListNode res = head;
		while(p2.next != null){
			res = res.next;
			p2 = p2.next;
		}
		return res;
	}
}
