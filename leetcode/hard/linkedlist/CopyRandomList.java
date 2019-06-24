package linkedlist;

import java.util.HashMap;

public class CopyRandomList {
	HashMap<RandomListNode, RandomListNode> visitedHash = new HashMap<>();
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head ==  null) return null;
		if(this.visitedHash.containsKey(head))
			return this.visitedHash.get(head);
		RandomListNode node = new RandomListNode(head.label);
		this.visitedHash.put(head, node);
		node.next = this.copyRandomList(head.next);
		node.random = this.copyRandomList(head.random);
		return node;
	}
	
	public RandomListNode copyRandomList1(RandomListNode head) {
		if(head ==  null) return null;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode cur = dummy;
		RandomListNode node = head;
		while(node != null){
			cur.next = cloneNode(node);
			node = node.next;
			cur = cur.next;
		}
		
		return dummy.next;
	}
	private RandomListNode cloneNode(RandomListNode node){
		RandomListNode tmp = new RandomListNode(node.label);
		tmp.random = node.random == null ? null : new RandomListNode(node.random.label);
		return tmp;
	}
}
