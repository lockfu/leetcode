package chap06;

import java.util.Stack;

import domain.TreeNodeOff;

public class GetKthNodeOfBTree {
	public static TreeNodeOff getKthNode(TreeNodeOff node, int k){
		if(null == node || k == 0) return null;
		Stack<TreeNodeOff> st = new Stack<>();
		TreeNodeOff cur = node;
		while(cur != null || !st.isEmpty()){
			while(cur != null){
				st.push(cur);
				cur = cur.left;
			}
			cur = st.pop();
			k--;
			if(k == 0)
				return cur;
			cur = cur.right;
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		TreeNodeOff head = new TreeNodeOff(1);
		TreeNodeOff l1 = new TreeNodeOff(2);
		TreeNodeOff r1 = new TreeNodeOff(3);
		l1.left = new TreeNodeOff(4);
		l1.right = new TreeNodeOff(5);
		r1.left = new TreeNodeOff(6);
		head.left = l1;
		head.right = r1;
		
		System.out.println("------------ inorder -----------");
		TreeNodeOff cur = head;
		TreeNodeOff res = getKthNode(cur, 3);
		System.out.println(res.val);
	}
}
