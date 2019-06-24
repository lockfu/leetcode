package linkedlist;

public class IsPalindrome {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode prenode = null;
		ListNode tmp = head;
		while (tmp != null) {
			ListNode newNode = new ListNode(tmp.val);
			newNode.next = prenode;
			prenode = newNode;
			tmp = tmp.next;
		}
		while (prenode != null && head != null) {
			if (prenode.val != head.val)
				return false;
			prenode = prenode.next;
			head = head.next;
		}
		return true;
	}
}
