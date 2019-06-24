package treeandGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

import domain.TreeNodeOff;

public class LowestCommandAncestor {
	public TreeNodeOff lowestCommonAncestor(TreeNodeOff root, TreeNodeOff p, TreeNodeOff q) {
        if(root.val == p.val || root.val == q.val)
            return root;
        int leftcount = nodeCount(root.left, p, q);
        int rightcount = nodeCount(root.right, p, q);
        if(leftcount == 1 && rightcount == 1){
            return root;
        }else if(leftcount == 2){
            return lowestCommonAncestor(root.left, p, q);
        }else if(rightcount == 2){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return null;
        }
    }
    
     public int nodeCount(TreeNodeOff node, TreeNodeOff p, TreeNodeOff q) {
         int res = 0;
         if(node == null)
             return res;
         LinkedList<TreeNodeOff> qe = new LinkedList<>();
         qe.add(node);
         while(!qe.isEmpty()){
             TreeNodeOff cur = qe.poll();
             if(cur.val == p.val || cur.val == q.val)
                 res++;
             if(cur.left != null)
                 qe.add(cur.left);
             if(cur.right != null)
                 qe.add(cur.right);
         }
         return res;
    }
     
     
     public TreeNodeOff ans;
     // 2
     public int helper(TreeNodeOff root, TreeNodeOff p, TreeNodeOff q){
    	 if(root == null) return 0;
    	 int res = 0;
    	 if(root == p || root == q) res += 1;
    	 res += helper(root.left, p, q);
    	 if(res >= 2){
    		 if(ans == null)
    			 this.ans = root;
    		 return res;
    	 }
    	 res += helper(root.right, p, q);
    	 if(res >= 2){
    		 if(ans == null)
    			 this.ans = root;
    		 return res;
    	 }
    	 return res;
     }
     
 	public TreeNodeOff lowestCommonAncestor1(TreeNodeOff root, TreeNodeOff p, TreeNodeOff q) {
        if(root == null)
        	return null;
 		if(root == p || root == q)
            return root;
 		TreeNodeOff left = lowestCommonAncestor1(root.left, p, q);
 		TreeNodeOff right = lowestCommonAncestor1(root.right, p, q);
        if(left != null && right != null){
            return root;
        }else if(left != null){
            return left;
        }else if(right != null){
        	return right;
        }else{
            return null;
        }
    }
     
     
     
     
     
}
