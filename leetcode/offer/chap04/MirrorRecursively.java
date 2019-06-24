package chap04;


import domain.TreeNodeOff;

public class MirrorRecursively {
	/**
	 * Êä³öÊ÷µÄ¾µÏñÊ÷
	 * @param head
	 */
	public static void mirrorRec(TreeNodeOff head){
		if(head == null) return ;
		if(head.left == null && head.right == null) return;
		TreeNodeOff tmp = head.left;
		head.left = head.right;
		head.right = tmp;
		if(head.left != null)
			mirrorRec(head.left);
		if(head.right != null)
			mirrorRec(head.right);
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
		
		
		
	}
	
}
