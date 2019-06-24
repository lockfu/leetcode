package chap04;

import java.util.Stack;
import domain.TreeNodeOff;

public class LevelBinTree3Z {
	public static void printTree(TreeNodeOff root){
		if(null == root) return;
		int level = 1;
		int toBePrint = 1;
		int nextPrint = 0;
		Stack<TreeNodeOff> st = new Stack<>();
		Stack<TreeNodeOff> stan = new Stack<>();
		st.add(root);
		while(!st.isEmpty()){
			TreeNodeOff cur = st.pop();
			--toBePrint;
			System.out.print(cur.val + " ");
			if(level % 2 != 0){  // 当前是奇数层 ， 先存左子节点 
				if(cur.left != null){
					st.push(cur.left);
					nextPrint++;
				}
				if(cur.right!=null){
					st.push(cur.right);
					nextPrint++;
				}
			}else {     //  当前是偶数层 ， 先存右子节点 
				if(cur.right != null){
					stan.push(cur.right);
					nextPrint++;
				}
				if(cur.left != null){
					stan.push(cur.left);
					nextPrint++;
				}
			}
			if(toBePrint == 0){
				System.out.println();
				toBePrint = nextPrint;
				nextPrint = 0;
				if(level % 2 == 0){
					st = stan;
					stan = new Stack<>();
				}
				level++;
			}
		}
	}
	
	public static void printTree2(TreeNodeOff root){
		if(null == root) return;
		Stack<TreeNodeOff>[] sts = new Stack[2];
		sts[0] = new Stack<>();
		sts[1] = new Stack<>();
		sts[0].add(root);
		int cur = 0;
		int next = 1;
		while(!sts[0].isEmpty() || !sts[1].isEmpty()){
			TreeNodeOff tmp = sts[cur].pop();
			System.out.print(tmp.val + " ");
			if(cur == 0){
				if(tmp.left != null)
					sts[next].push(tmp.left);
				if(tmp.right != null)
					sts[next].push(tmp.right);
			}else{
				if(tmp.right != null)
					sts[next].push(tmp.right);
				if(tmp.left != null)
					sts[next].push(tmp.left);
			}
			
			if(sts[cur].isEmpty()){
				System.out.println();
				cur = 1 - cur;
				next = 1 - next;
			}
		}
		
	}
	
	public static void main(String[] args) {
		TreeNodeOff root = new TreeNodeOff(8);
		TreeNodeOff l1 = new TreeNodeOff(6);
		TreeNodeOff r1 = new TreeNodeOff(10);
		l1.left = new TreeNodeOff(5);
		l1.right = new TreeNodeOff(7);
		r1.left = new TreeNodeOff(9);
		r1.right = new TreeNodeOff(11);
		root.left = l1;
		root.right = r1;
		
		printTree2(root);
		
	}
}
