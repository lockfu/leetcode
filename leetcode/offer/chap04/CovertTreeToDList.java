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
		cur.left = lastNodeInList;  // ��ǰ�ڵ����ָ��ָ���ϴνڵ�
		
		if(lastNodeInList != null)
			lastNodeInList.right = cur;  // �ϴνڵ����ָ��ָ��ǰ�ڵ�
		
		lastNodeInList = cur;   // ���ϴνڵ㸳ֵΪ�Ƚڵ�
		
		if(cur.right != null)
			lastNodeInList = covertNode(cur.right, lastNodeInList);
		
		return lastNodeInList;
	}
}
