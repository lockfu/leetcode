package linkedlist;

public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int len = 0;
		ListNode tmp = head;
		while (tmp != null) {
			len++;
			tmp = tmp.next;
		}
		if (len == n)
			return head.next;
		tmp = head;
		int count = 0;
		while ((len - count) > (n + 1)) {
			count++;
			tmp = tmp.next;
		}
		tmp.next = tmp.next.next;
		return head;
	}
	
	public ListNode removeNthFromEnd1(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int len = 0;
		ListNode first = head;
		while(first != null){
			len++;
			first = first.next;
		}
		len -= n;
		first = dummy;
		while(len > 0){
			len--;
			first = first.next;
		}
		first.next = first.next.next;
		return dummy.next;
	}
	
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		for(int i = 1; i<= n+1; i++){
			first = first.next;
		}
		while(first != null){
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
	}
}
