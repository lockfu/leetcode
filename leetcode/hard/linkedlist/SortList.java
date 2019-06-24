package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortList {
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
	
	 public ListNode sortList1(ListNode head) {
	        List<Integer> list = new ArrayList<>();
	        ListNode tmp = head;
	        while(tmp != null){
	            list.add(tmp.val);
	            tmp = tmp.next;
	        }
	        if(list.size() == 0)
	            return null;
	        int[] arr = new int[list.size()];
	        for(int i = 0; i<list.size(); i++){
	            arr[i] = list.get(i);
	        }
	        Arrays.sort(arr);
	        ListNode res = new ListNode(-1);
	        tmp = res;
	        for(int i : arr){
	            ListNode newNode = new ListNode(i);
	            tmp.next = newNode;
	            tmp = tmp.next;
	        }
	        return res.next;
	    }
}
