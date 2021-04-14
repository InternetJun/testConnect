class Trie{
	private Trie[] child;
	boolean isEnd;

	public Trie(){
		child = new Trie[26];
		isEnd = false;
	}
	
	public void insert(String word) {
		Trie node = this;
		for(int i = 0; i < word.length; i++) {
			char c = word.charAt(i);
			int ind = c-'a';
			if(node.child[ind] == null) {
				node.child[ind] = new Trie;
			}
			node = node.child[ind];
		}
		node.isEnd = true;
	}
	
	public boolean startWith(String prefix) {
		return searchPrefix(prefix) != null;
	}
	
	public boolean search(String word) {
		Trie node = searchPrefix(word);
		return node != null && node.isEnd;
	} 
	
	public Trie searchPrefix(String prefix) {
		Trie node = this;
		for(int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			int ind = ch - 'a';
			if(node.child[ind] == null) {
				return null;
			}
			node = node.child[ind];
		}
		return node;
	}
}
