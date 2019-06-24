package linkedlist;

public class OddEvenList {
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null)
			return head;
		ListNode cur = head.next;
		ListNode cp = head;
		ListNode pre = head;
		int count = 2;
		int cc = 0;
		while(cur != null && cp != null){
			if((count % 2) != 0){
				cp.next = cur.next;
				cur.next = pre.next;
				pre.next = cur;
				pre = pre.next;
				cur = cp;
				cp = pre;
				for(int i = 0; i<cc; i++){
					cp = cp.next;
				}
				cc++;
			}
			if(cp == null || cur == null)
				break;
			cp = cp.next;
			cur = cur.next;
			count++;
		}
		return head;
	}
	public ListNode oddEvenList1(ListNode head) {
		if(head == null || head.next == null || head.next.next == null)
			return head;
		ListNode odd = head, even = head.next, evenHead = even;
		while(even != null && even.next != null){
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}
}
