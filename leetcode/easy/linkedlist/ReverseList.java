package linkedlist;

public class ReverseList {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prenode = null;
		while (head != null) {
			ListNode newNode = new ListNode(head.val);
			newNode.next = prenode;
			prenode = newNode;
			head = head.next;
		}
		return prenode;
	}
}
