package com.viveksb007.algo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {

    public static void main(String[] args) {
        HuffmanCoding huffmanCoding = new HuffmanCoding();
        char[] arr = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charFreq = new int[]{5, 9, 12, 13, 16, 45};
        String str = createString(arr, charFreq);
        Map<Character, String> charMap = new HashMap<>();
        System.out.println("Original String -> " + str);
        String encoded = huffmanCoding.encode(str, charMap);
        System.out.println("Encoded stream -> " + encoded);
        String decoded = huffmanCoding.decode(encoded, charMap);
        System.out.println("Decoded String -> " + decoded);
    }

    private static String createString(char[] arr, int[] charFreq) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < charFreq[i]; j++) {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    private String decode(String encoded, Map<Character, String> charMap) {
        Map<String, Character> revMap = new HashMap<>();
        for (Map.Entry<Character, String> entry : charMap.entrySet()) {
            revMap.put(entry.getValue(), entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (char c : encoded.toCharArray()) {
            temp.append(c);
            if (revMap.containsKey(temp.toString())) {
                sb.append(revMap.get(temp.toString()));
                temp.setLength(0);
            }
        }
        return sb.toString();
    }

    private String encode(String str, Map<Character, String> charMap) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        Node[] nodes = new Node[256];
        for (char c : str.toCharArray()) {
            if (nodes[c] == null)
                nodes[c] = new Node(0, c);
            nodes[c].val++;
        }
        for (Node node : nodes) if (node != null) pq.add(node);
        while (pq.size() != 1) {
            Node n1 = pq.remove();
            Node n2 = pq.remove();
            Node node = new Node(n1.val + n2.val, null);
            node.left = n1;
            node.right = n2;
            pq.add(node);
        }
        Node root = pq.remove();
        traverse(root, charMap, "");
        System.out.println(charMap);
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(charMap.get(c));
        }
        return sb.toString();
    }

    private void traverse(Node root, Map<Character, String> charMap, String s) {
        if (root == null) return;
        if (root.c != null) {
            charMap.put(root.c, s);
            return;
        }
        traverse(root.left, charMap, s + "0");
        traverse(root.right, charMap, s + "1");
    }

    static class Node {
        int val;
        Character c;
        Node left;
        Node right;

        Node(int val, Character c) {
            this.val = val;
            this.c = c;
        }
    }

}
