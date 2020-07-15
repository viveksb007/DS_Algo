package com.viveksb007.lc;

import java.util.HashMap;
import java.util.Map;

public class LFUCache implements Cache {

    private final int capacity;
    private final Map<Integer, Node> nodeMap;
    private final Map<Integer, DLL> freqMap;
    private int minFrequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    @Override
    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        freqMap.get(node.frequency).remove(node);
        if (freqMap.get(minFrequency).isEmpty()) {
            minFrequency++;
        }
        node.frequency++;
        freqMap.putIfAbsent(node.frequency, new DLL());
        freqMap.get(node.frequency).add(node);
        return node.value;
    }

    @Override
    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            get(key);
            nodeMap.get(key).value = value;
        } else {
            if (nodeMap.size() >= capacity) {
                Node evictedNode = freqMap.get(minFrequency).removeTail();
                nodeMap.remove(evictedNode.key);
            }
            Node node = new Node(key, value, 1);
            freqMap.putIfAbsent(node.frequency, new DLL());
            freqMap.get(node.frequency).add(node);
            nodeMap.put(key, node);
            minFrequency = 1;
        }
    }

    @Override
    public int size() {
        return nodeMap.size();
    }

    static class Node {
        int key;
        int value;
        int frequency;
        Node next;
        Node prev;

        Node(int key, int value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }

    }

    static class DLL {

        Node head;
        Node tail;
        int size;

        DLL() {
            head = new Node(0, 0, 0);
            tail = new Node(0, 0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        Node remove(Node node) {
            size--;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }

        Node add(Node node) {
            size++;
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;
            return node;
        }

        public Node removeTail() {
            size--;
            Node toDelete = tail.prev;
            toDelete.prev.next = toDelete.next;
            toDelete.next.prev = toDelete.prev;
            return toDelete;
        }

        boolean isEmpty() {
            return size == 0;
        }

    }

}
