package chap02;

import domain.TreeNodeParent;

/**
 * 找到中序遍历的树的下一个节点
 * 1. 有右节点，下一个节点就是右子树中的最左子节点
 * 2. 没有右节点， 但是它是它的父节点的左节点， 那父节点就是下一个
 * 3. 没有右节点， 并且是父节点的右节点，则沿着父指针一直向上遍历，直到找到一个是其父节点子节点的节点。
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
