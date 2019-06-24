package chap02;

import domain.TreeNodeParent;


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
