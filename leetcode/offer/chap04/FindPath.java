package chap04;

import java.util.ArrayList;
import java.util.List;

import domain.TreeNodeOff;

public class FindPath {
	public static void findPath(TreeNodeOff root, int target){
		if(null == root) return;
		List<Integer> path = new ArrayList<>();
		int curSum = 0;
		findPath(root, path, curSum, target);
	}
	public static void findPath(TreeNodeOff node, List<Integer> path, int curSum, int target){
		curSum += node.val;
		path.add(node.val);
		boolean isLeaf = node.left == null && node.right == null;
		if(curSum == target && isLeaf){
			System.out.println("Find A Path: ");
			for(int item : path){
				System.out.print(item+" ");
			}
			System.out.println();
		}
		if(node.left != null)
			findPath(node.left, path, curSum, target);
		if(node.right != null)
			findPath(node.right, path, curSum, target);
		path.remove(path.size()-1);
	}
	
	public static void main(String[] args) {
		TreeNodeOff root = new TreeNodeOff(10);
		TreeNodeOff l1 = new TreeNodeOff(5);
		TreeNodeOff r1 = new TreeNodeOff(12);
		l1.left = new TreeNodeOff(4);
		l1.right = new TreeNodeOff(7);
		root.left = l1;
		root.right = r1;
		
		findPath(root,22);
	}
}
