package chap04;

import domain.TreeNodeOff;

public class CovertTreeToDList {
	public TreeNodeOff covertT2DL(TreeNodeOff root){
		TreeNodeOff lastNodeInList = covertNode(root, null);
		TreeNodeOff headOfList = lastNodeInList;
		while(headOfList != null && headOfList.left != null)
			headOfList = headOfList.left;
		return headOfList;
	}
	
	public TreeNodeOff covertNode(TreeNodeOff node, TreeNodeOff lastNodeInList){
		if(node == null) return null;
		TreeNodeOff cur = node;
		if(cur.left != null)
			lastNodeInList = covertNode(node.left, lastNodeInList);
		cur.left = lastNodeInList;  // 当前节点的左指针指向上次节点
		
		if(lastNodeInList != null)
			lastNodeInList.right = cur;  // 上次节点的右指针指向当前节点
		
		lastNodeInList = cur;   // 将上次节点赋值为先节点
		
		if(cur.right != null)
			lastNodeInList = covertNode(cur.right, lastNodeInList);
		
		return lastNodeInList;
	}
}
