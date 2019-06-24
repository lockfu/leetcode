package linkedlist;

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode pre = d, f = head, s = head;
        int count = 1;
        boolean flag = false;
        while(true){
            while(count != k) {
                s = s.next;
                if(s == null){
                    flag = true;
                    break;
                }
                count++;
            }
            if(flag) break;
            else count = 1;
            ListNode sn = s.next;
            ListNode tmp = new ListNode(f.val);
            ListNode tmpt = tmp;
            f = f.next;
            while(f != s){
                ListNode cur = new ListNode(f.val);
                cur.next = tmp;
                tmp = cur;
                f = f.next;
            }
            ListNode cur = new ListNode(f.val);
            cur.next = tmp;
            pre.next = cur;
            tmpt.next = sn;
            pre = tmpt;
            f = sn;
            s = sn;
            if(s == null)
                break;
        }
        return d.next;
    }
}
