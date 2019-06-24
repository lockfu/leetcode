package linkedlist;

public class GetIntersectionNode {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)
			return null;
		int lenA = 0, lenB = 0;
		ListNode tmpA = headA, tmpB = headB;
		while(tmpA != null){
			lenA++;
			tmpA = tmpA.next;
		}
		while(tmpB != null){
			lenB++;
			tmpB = tmpB.next;
		}
		tmpA = headA;
		tmpB = headB;
		if (lenA > lenB){
			for (int i = 0; i < (lenA - lenB); i++)
				tmpA = tmpA.next;
		}else if (lenA < lenB){
			for (int i = 0; i < (lenB - lenA); i++)
				tmpB = tmpB.next;
		}
		
		ListNode res = tmpA;
		while(tmpA != null && tmpB != null){
			if(tmpA.val != tmpB.val)
				res = tmpA.next;
			tmpA = tmpA.next;
			tmpB = tmpB.next;
		}
		return res;
	}
}
