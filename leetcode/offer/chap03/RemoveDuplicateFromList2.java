package chap03;

import domain.ListNode;

public class RemoveDuplicateFromList2 {
	public static ListNode remove(ListNode head){
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		while(cur != null){
			while(cur.next != null && cur.val == cur.next.val)
				cur = cur.next;
			if(pre.next == cur)
				pre = pre.next;
			else
				pre.next = cur.next;
			cur = cur.next;
		}
		return dummy.next;
	}
	
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode res = node;
        ListNode cur = head;
        while(cur != null){
            if(cur.next == null || cur.val != cur.next.val){
                node.next = cur;
                node = cur;
                cur = cur.next;
            }else{
                 while(cur != null && cur.next != null && cur.val == cur.next.val) cur = cur.next;
                cur = cur.next;
                if(cur == null)
                    node.next = cur;
            }
        }
        return res.next;
    }
}
