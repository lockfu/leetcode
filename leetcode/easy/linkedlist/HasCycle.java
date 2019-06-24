package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
	public boolean hasCycle(ListNode head){
		Set<ListNode> node = new HashSet<>();
		while(head != null){
			if(node.contains(head))
				return true;
			else 
				node.add(head);
			head = head.next;
		}
		return false;
	}
	
	public boolean hasCycle1(ListNode head){
		if(head == null || head.next == null)
			return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while(slow != fast){
			if(fast == null || fast.next == null)
				return false;
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
	
}
