package treeoperator;

import domain.TreeNodeOff;

/**
 * ����ǰ���������������ؽ���
 * ����ǰ�����ȷ�����Ľڵ㣬�����������ȷ������������Ȼ��ݹ�������
 * @author DELL
 *
 */
public class BuildTree {
	public static TreeNodeOff conTree(int[] preorder, int[] inorder){
		if(null == preorder || null == inorder || preorder.length != inorder.length ) return null;
		return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
	}
	
	public static TreeNodeOff buildTree(int[] A, int[] B, int pst, int ped, int ist, int ied){
		int rootval = A[pst];
		TreeNodeOff root = new TreeNodeOff(rootval);
		if(pst == ped){
			if(ist == ied && A[pst] == B[ist])
				return root;
			else
				throw new IllegalArgumentException("IllegalArgument!!!");
		}
		int rootInorder = ist;
		while(rootInorder <= ied && B[rootInorder] != rootval){
			rootInorder++;
		}
		if(rootInorder == ied && B[rootInorder] != rootval)
			throw new IllegalArgumentException("IllegalArgument!!!");
		int leftLen = rootInorder - ist;
		if(leftLen > 0)
			root.left = buildTree(A, B, pst+1, pst+leftLen, ist, rootInorder-1);
		else if(leftLen < ped - pst)
			root.right = buildTree(A, B, pst+leftLen+1, ped, rootInorder+1, ied);
		return root;
	}
	
}
