package linkedlist;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode restmp = head;
		int cur = 0;
		int bus = 0;
		while(l1 != null || l2 != null){
			if(l1 == null){
				cur = l2.val + bus;
				l2 = l2.next;
			}else if (l2 == null){
				cur = l1.val + bus;
				l1 = l1.next;
			}else{
				cur = l1.val + l2.val + bus; 
				l1 = l1.next;
				l2 = l2.next;
			}
			bus = cur / 10;
			restmp.next = new ListNode(cur%10);
			restmp = restmp.next;
		}
		if(bus == 1){
			restmp.next = new ListNode(bus);
			restmp = restmp.next;
		}
		return head.next;
	}
	
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode head = new ListNode(0);
		ListNode tmp = head;
		boolean bus = false;
		while(l1 != null || l2 != null){
			int v1 = (l1 == null) ? 0 : l1.val;
			int v2 = (l2 == null) ? 0 : l2.val;
			int cur = bus ? v1 + v1 + 1 : v1 + v2;
			if(cur >= 10){
				bus = true;
			}else
				bus = false;
			cur = cur % 10;
			tmp.next = new ListNode(cur);
			tmp = tmp.next;
			l1 = (l1 == null) ? null : l1.next;
			l2 = (l2 == null) ? null :l2.next;
		}
		if(bus)
			tmp.next = new ListNode(1);
		return head.next;
	}
	
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode head = new ListNode(0);
		ListNode tmp = head;
		int bus = 0;
		while(l1 != null && l2 != null){
			int cur = bus + l1.val + l2.val;
			bus = cur / 10;
			tmp.next = new ListNode(cur % 10);
			tmp = tmp.next;
			l1 =  l1.next;
			l2 =   l2.next;
		}
		if(l1 == null){
			l1 = l2;
		}
		while(l1 != null){
			int cur = bus + l1.val; 
			bus = cur / 10;
			tmp.next = new ListNode(cur % 10);
			tmp = tmp.next;
			l1 =  l1.next;
		}
		if(bus == 1)
			tmp.next = new ListNode(bus);
		return head.next;
	}
	
	public static void main(String[] args) {
		System.out.println(11%10);
	}
}
