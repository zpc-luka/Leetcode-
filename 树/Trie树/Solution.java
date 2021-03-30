class Trie {
    
    class TrieNode {
        private boolean isEnd;
        private TrieNode[] next;

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }
    
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] charArray = word.toCharArray();
        TrieNode node = root;

        for(char c: charArray) {
            if(node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        TrieNode node = root;

        for(char c: charArray) {
            node = node.next[c - 'a'];
            if(node == null) 
                return false;
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        TrieNode node = root;

        for(char c: charArray) {
            node = node.next[c - 'a'];
            if(node == null)
                return false;
        }

        return true;
    }
}
