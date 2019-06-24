package linkedlist;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode tmp = d;
        ListNode f = head;
        ListNode s = head.next;
        while(s!=null){
            d.next = s;
            f.next = s.next;
            s.next = f;
            d = f;
            f = f.next;
            if(f == null)
                break;
            else
                s = f.next;
        }
        return tmp.next;
    }
}
