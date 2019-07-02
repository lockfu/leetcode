package chap05;

import domain.ListNode;

public class FindFirstCommonNode {
	public static ListNode findFirstNode(ListNode l1, ListNode l2){
		int len1 = getNodeLen(l1);
		int len2 = getNodeLen(l2);
		ListNode longnode = len1 > len2 ? l1 : l2;
		ListNode shortnode = len1 > len2 ? l2 : l1;
		int lendif = Math.abs(len1 - len2);
		for(int i = 1; i<= lendif; i++){
			longnode = longnode.next;
		}
		while(longnode != null && shortnode != null && longnode.val != shortnode.val){
			longnode = longnode.next;
			shortnode = shortnode.next;
		}
		return longnode;
	}
	
	public static int getNodeLen(ListNode node){
		int res = 0;
		ListNode tmp = node;
		while(tmp != null){
			res++;
			tmp  = tmp.next;
		}
		return res;
	}
}
