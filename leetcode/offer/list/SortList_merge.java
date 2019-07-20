package list;

import domain.ListNode;

public class SortList_merge {

	   public ListNode sortList(ListNode head) {
	        if (head == null || head.next == null) {
	             return head;
	         }
	 		ListNode fast = head;
	 		ListNode slow = head;
	 		while(fast.next != null && fast.next.next != null){
	 			fast = fast.next.next;
	 			slow = slow.next;
	 		}
	 		// break listnode to two listnode
	 		ListNode secHalfHead = slow.next;
	 		slow.next = null;
			
	 		ListNode firnode = sortList(head);
	 		ListNode secnode = sortList(secHalfHead);
			
	 		ListNode dummy = new ListNode(0);
	 		ListNode m = dummy;
	 		ListNode p = firnode;
	 		ListNode q = secnode;
		
	 		while(p != null && q != null){
	 			if(p.val > q.val){
	 				m.next = q;
	 				q = q.next;
	 			}else{
	 				m.next = p;
	 				p = p.next;
	 			}
	 			m = m.next;
	 		}
	 		if(p != null)
	 			m.next = p;
	 		if(q != null)
	 			m.next = q;
	 		return dummy.next;
	   }
	   
	   public ListNode sortList_merge(ListNode head) {
		   if(head == null || head.next == null) return head;
		   ListNode fast = head, slow = head;
		   while(fast.next != null && fast.next.next != null){
			   fast = fast.next.next;
			   slow = slow.next;
		   }
		   fast = slow;
		   slow = slow.next;
		   fast.next = null;
		   fast = sortList_merge(head);
		   slow = sortList_merge(slow);
		   return merge(fast, slow);
	   }
	   
	   private ListNode merge(ListNode le, ListNode ri){
		   ListNode l1 = le, l2 = ri;
		   if(l1 == null) return l2;
		   if(l2 == null) return l1;
		   ListNode res = new ListNode(0);
		   ListNode tmp = res;
		   while(l1!= null && l2 != null){
			   if(l1.val < l2.val){
				   tmp.next = new ListNode(l1.val);
				   l1 = l1.next;
			   }else{
				   tmp.next = new ListNode(l2.val);
				   l2 = l2.next;
			   }
			   tmp = tmp.next;
		   }
		   if(l1 != null)
			   tmp.next = l1;
		   else
			   tmp.next = l2;
		   return res.next;
	   }
	   
	   public static void main(String[] args) {
	}
}
