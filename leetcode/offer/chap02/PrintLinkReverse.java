package chap02;

import java.util.Stack;

import domain.ListNode;

/**
 * 反转打印链表
 * 栈  递归
 * @author DELL
 *
 */
public class PrintLinkReverse {
	
	public static void printReverse(ListNode head){
		if(head == null) return;
		if(head.next!=null)
			printReverse(head.next);
		System.out.println(head.val);
	}
	
	public static void printReverse_st(ListNode head){
		if(head == null) return;
		Stack<Integer> st = new Stack<>();
		while(head!=null){
			int val = head.val;
//			System.out.println(head.val);
			st.push(val);
			head = head.next;
		}
		while(!st.isEmpty())
			System.out.println(st.pop());
	}
	
	public static void main(String[] args) {
//		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
//		while(head!=null){
//			System.out.println(head.val);
//			head = head.next;
//		}
//		printReverse_st(head);
	}
}
