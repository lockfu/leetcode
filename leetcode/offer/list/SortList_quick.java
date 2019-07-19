package list;

import domain.ListNode;

public class SortList_quick {
	 public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
         qsortList(head, null);
         return head;
	 }
	 
	 private void qsortList(ListNode head, ListNode tail){
		 if(head != tail && head.next != tail){
			 ListNode mid = partitionList(head, tail);
			 qsortList(head, mid);
			 qsortList(mid.next, tail);
		 }
	 }
	 
	 private ListNode partitionList(ListNode low, ListNode high){
		 int key = low.val;
		 ListNode loc = low;
		 for(ListNode i = low.next; i != high; i = i.next){
			 if(i.val < key){
				 loc = loc.next;
				 int tmp = i.val;
				 i.val = loc.val;
				 loc.val = tmp;
			 }
		 }
		 int tmp = loc.val;
		 loc.val = low.val;
		 low.val = tmp;
		 return loc;
	 }
}
