package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKLists {

	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0)
			return null;
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i<lists.length; i++){
			ListNode cur = lists[i];
			while(cur != null){
				list.add(cur.val);
				cur = cur.next;
			}
		}
		int[] tmp = new int[list.size()];
		for(int i = 0; i<tmp.length; i++){
			tmp[i] = list.get(i);
		}
		Arrays.sort(tmp);
		ListNode res = new ListNode(tmp[0]);
		ListNode ltmp = res;
		for(int i = 1; i<tmp.length; i++){
			ListNode newNode = new ListNode(tmp[i]);
			ltmp.next = newNode;
			ltmp = newNode;
		}
		return res;
	}
	
	
	
	
	public ListNode merge(ListNode l1, ListNode l2){
		if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l2.val > l1.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }else {
            l2.next =  merge(l1, l2.next);
            return l2;
        }
	}
	
	
	
	public ListNode merge2Lists(ListNode A, ListNode B){
		ListNode res = new ListNode(-1);
		ListNode tmp = res;
		while(A != null && B != null){
			if(A.val <= B.val){
				tmp.next = A;
				A = A.next;
			}else{
				tmp.next = B;
				B = B.next;
			}
			tmp = tmp.next;
		}
		if(A != null) tmp.next = A;
		if(B != null) tmp.next = B;
		return res.next;
	}
	
	public ListNode mergeK(ListNode[] lists, int s, int e){
		if(s > e) return  null;
		if(s == e) return lists[s];
		int m = s + (e-s)/2;
		return merge2Lists(mergeK(lists, s, m), mergeK(lists, m, e));
	}
	
	public ListNode mergeKLists1(ListNode[] lists){
		return mergeK(lists, 0, lists.length - 1);
	}
	
}
