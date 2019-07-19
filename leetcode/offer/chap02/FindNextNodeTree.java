package chap02;

import domain.TreeNodeParent;

/**
 * �ҵ����������������һ���ڵ�
 * 1. ���ҽڵ㣬��һ���ڵ�����������е������ӽڵ�
 * 2. û���ҽڵ㣬 �����������ĸ��ڵ����ڵ㣬 �Ǹ��ڵ������һ��
 * 3. û���ҽڵ㣬 �����Ǹ��ڵ���ҽڵ㣬�����Ÿ�ָ��һֱ���ϱ�����ֱ���ҵ�һ�����丸�ڵ��ӽڵ�Ľڵ㡣
 * @author DELL
 *
 */

public class FindNextNodeTree {
	public TreeNodeParent getNext(TreeNodeParent pnode){
		if(pnode == null) return null;
		TreeNodeParent pnext = null;
		if(pnode.right != null){
			TreeNodeParent cur = pnode.right;
			while(cur.left != null){
				cur = cur.left;
			}
			pnext = cur;
		}else if(pnode.parent != null){
			TreeNodeParent cur = pnode;
			TreeNodeParent par = pnode.parent;
			while(par != null && par.right == cur){
				cur = par;
				par = par.parent;
			}
			pnext = par;
		}
		return pnext;
	}
}
