package top100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import domain.TreeNodeOff;

public class WordSearch2 {
	public List<String> findWords(char[][] board, String[] words) {
		if(null == board || null == words) return new ArrayList<>();
//		List<String> res = new ArrayList<>();
		Set<String> set = new HashSet<>();
		int m = board.length, n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for(String word : words){
			for(int i = 0; i<m; i++){
				for(int j = 0; j<n; j++){
					if(helper(board,word, 0, i, j, visited )){
						set.add(word);
					}
				}
			}
		}
		return new ArrayList<>(set);
	}
	private boolean helper(char[][] board, String word, int idx, int i, int j, boolean[][] visited){
		if(idx == word.length()) return true;
		int m = board.length, n = board[0].length;
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(idx) )
			return false;
		visited[i][j] = true;
		boolean res = helper(board,word, idx+1, i+1, j, visited)
						|| helper(board,word, idx+1, i-1, j, visited)
						|| helper(board,word, idx+1, i, j+1, visited)
						|| helper(board,word, idx+1, i, j-1, visited);
		visited[i][j] = false;
		return res;
	}
	
	
	
	// ----------------------------------------------------------------
	
	
	
	public List<String> findWords_trie(char[][] board, String[] words) {
		if(null == board || null == words) return new ArrayList<>();
		List<String> result = new ArrayList<>();
		int m = board.length, n = board[0].length;
		Trie1 tree = new Trie1();
		for(String word : words){
			tree.insert(word);
		}
		TrieNode1 node = tree.root;
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				char c = board[i][j];
				int idx = (int)(c - 'a');
				if(node.children[idx] != null){
					board[i][j] = '#';
					dfs(result, board, i, j, node.children[idx], tree);
					board[i][j] = c;
				}
			}
		}
		return result;
	}
	
	void dfs(List<String> result, char[][] board, int i, int j, TrieNode1 node, Trie1 tree){
		if(node.word != null){
			result.add(node.word);
			tree.removeWord(node);
		}
		
		if(i > 0 && board[i-1][j] != '#'){
			char c = board[i-1][j];
			int idx = (int)(c-'a');
			if(node.children[idx] != null){
				board[i-1][j] = '#';
				dfs(result, board, i-1, j, node.children[idx], tree);
				board[i-1][j] = c;
			}
		}
		
		if(j > 0 && board[i][j-1] != '#'){
			char c = board[i][j-1];
			int idx = (int)(c-'a');
			if(node.children[idx] != null){
				board[i][j-1] = '#';
				dfs(result, board, i, j-1, node.children[idx], tree);
				board[i][j-1] = c;
			}
		}
		
		if(i+1 < board.length && board[i+1][j] != '#'){
			char c = board[i+1][j];
			int idx = (int)(c-'a');
			if(node.children[idx] != null){
				board[i+1][j] = '#';
				dfs(result, board, i+1, j, node.children[idx], tree);
				board[i+1][j] = c;
			}
		}
		
		if(j+1 < board[0].length && board[i][j+1] != '#'){
			char c = board[i][j+1];
			int idx = (int)(c-'a');
			if(node.children[idx] != null){
				board[i][j+1] = '#';
				dfs(result, board, i, j+1, node.children[idx], tree);
				board[i][j+1] = c;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		char[][] board = {
		         {'o','a','a','n'},
		         {'e','t','a','e'},
		         {'i','h','k','r'},
		         {'i','f','l','v'}
		};
		String[] words = {"oath","pea","eat","rain"};
		List<String> res = new WordSearch2().findWords(board, words);
		System.out.println(res);
	}
}

class Trie1{
	TrieNode1 root;
	public Trie1(){root = new TrieNode1(null);}
	
	public void insert(String word){
		TrieNode1 cur = root;
		for(char c : word.toCharArray()){
			int idx = (int)(c-'a');
			if(cur.children[idx] == null){
				cur.children[idx] = new TrieNode1(cur);
			}
			cur = cur.children[idx];
		}
		cur.word = word;
	}
	public void removeWord(TrieNode1 node){
		node.word = null;
		boolean removeNode = true;
		while(removeNode && node != root){
			for(int i = 0; i<26; i++){
				if(node.children[i] != null){
					removeNode = false;
				}
			}
			if(removeNode){
				TrieNode1 parent = node.parent;
				for(int i = 0; i<26; i++){
					if(parent.children[i] == node){
						parent.children[i] = null;
					}
				}
				node = parent;
			}
		}
	}
}

class TrieNode1{
	TrieNode1[] children;
	String word = null;
	TrieNode1 parent;
	public TrieNode1(TrieNode1 parent) {
		this.children = new TrieNode1[26];
		this.parent = parent;
	}
}
