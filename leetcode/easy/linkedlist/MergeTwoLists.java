package linkedlist;

public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode res = new ListNode(0);
		ListNode rr = res;
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				rr.next = l2;
				break;
			} else if (l2 == null) {
				rr.next = l1;
				break;
			}
			ListNode tmp = new ListNode(0);
			if (l1.val > l2.val) {
				tmp.val = l2.val;
				l2 = l2.next;
			} else {
				tmp.val = l1.val;
				l1 = l1.next;
			}
			rr.next = tmp;
			rr = rr.next;
		}
		return res.next;
	}
}
