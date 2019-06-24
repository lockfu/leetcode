package chap04;

import domain.ComplexListNode;

public class ComplexListClone {
	public static ComplexListNode clone(ComplexListNode head) {
		if(head == null) return null;
		cloneNodes(head);
		copySlides(head);
		return reconnectNodes2(head);
	}

	public static void cloneNodes(ComplexListNode head) {
		ComplexListNode node = head;
		while(node != null){
			ComplexListNode clone = new ComplexListNode(node.val);
			clone.next = node.next;
			node.next = clone;
			node = clone.next;
		}
//		return head;
	}
	
	
	public static void copySlides(ComplexListNode head){
		ComplexListNode node = head;
		while(node != null){
			ComplexListNode clone = node.next;
			if(node.slibe != null){
				clone.slibe = node.slibe.next;
			}
			node = clone.next;
		}
	}
	
	public static ComplexListNode reconnectNodes(ComplexListNode head){
		ComplexListNode node = head;
		ComplexListNode clonehead = new ComplexListNode(0);
		ComplexListNode tmpclone = clonehead;
		while(node != null){
			ComplexListNode clone = node.next;
			node.next = clone.next;
			tmpclone.next = clone;
			node = clone.next;
		}
		return clonehead.next;
	}
	
	public static ComplexListNode reconnectNodes2(ComplexListNode head){
		ComplexListNode node = head;
		ComplexListNode clonehead = null;
		ComplexListNode clonenode = null;
		if(node != null){
			clonehead = clonenode = node.next;
			node.next = clonenode.next;
			node = node.next;
		}
		while(node != null){
			clonenode.next = node.next;
			clonenode = clonenode.next;
			node.next = clonenode.next;
			node = node.next;
		}
		return clonehead;
	}

}
