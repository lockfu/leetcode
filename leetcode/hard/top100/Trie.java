package top100;

public class Trie {
	public TrieNode root;
	public Trie(){
		root = new TrieNode();
	}
	public void insert(String word){
		TrieNode node = root;
		for(int i = 0; i<word.length(); i++){
			char curChar = word.charAt(i);
			if(!node.containsKey(curChar)){
				node.put(curChar, new TrieNode());
			}
			node = node.get(curChar);
		}
		node.setEnd();
	}
	private TrieNode searchPrefix(String word){
		TrieNode node = root;
		for(int i = 0; i<word.length(); i++){
			char cur = word.charAt(i);
			if(node.containsKey(cur)){
				node = node.get(cur);
			}else
				return null;
		}
		return node;
	}
	public boolean search(String word){
		TrieNode node = searchPrefix(word);
		return node != null && node.isEnd();
	}
	public boolean startsWith(String prefix){
		TrieNode node = searchPrefix(prefix);
		return node != null ;
	}
	
}


