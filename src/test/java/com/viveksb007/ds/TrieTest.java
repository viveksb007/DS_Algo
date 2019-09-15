package com.viveksb007.ds;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TrieTest {

    @Test
    public void shouldAddWordsInTrie() {
        Trie trie = new Trie();
        trie.addWord("helloworld");
        trie.addWord("hello");
        trie.addWord("hel");
        trie.addWord("hallo");
        trie.addWord("yoman");
        assertEquals(4, trie.printWordsWithPrefix("h"));
        assertEquals(3, trie.printWordsWithPrefix("he"));
    }

}
