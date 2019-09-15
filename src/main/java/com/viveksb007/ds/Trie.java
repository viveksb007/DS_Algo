package com.viveksb007.ds;

public class Trie {

    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public boolean addWord(String word) {
        if (word == null) return false;
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
        }
        temp.setEndOfWord(true);
        return true;
    }

    public int printWordsWithPrefix(String prefix) {
        TrieNode temp = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (temp.children[index] == null) {
                return 0;
            }
            temp = temp.children[index];
        }
        return printWordsWithPrefixUtil(temp, prefix);
    }

    private int printWordsWithPrefixUtil(TrieNode temp, String prefix) {
        int count = 0;
        if (temp.isEndOfWord()) {
            System.out.println(prefix);
            count++;
        }
        for (int i = 0; i < 26; i++) {
            TrieNode child = temp.children[i];
            if (child != null)
                count += printWordsWithPrefixUtil(child, prefix + (char) (i + 'a'));
        }
        return count;
    }

    static class TrieNode {

        private TrieNode[] children;
        private boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }

        public TrieNode[] getChildren() {
            return children;
        }
    }

}
