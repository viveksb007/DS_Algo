package com.viveksb007.lc;

import java.util.HashMap;
import java.util.Map;

public class LRUCache implements Cache {

    private final Map<Integer, Node> nodeMap;
    private final DLL list;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        list = new DLL();
    }

    @Override
    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        list.remove(node);
        list.add(node);
        return node.value;
    }

    @Override
    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            nodeMap.get(key).value = value;
        } else {
            if (nodeMap.size() == capacity) {
                Node deleteNode = list.removeTail();
                nodeMap.remove(deleteNode.key);
            }
            Node node = new Node(key, value);
            nodeMap.put(key, node);
            list.add(node);
        }
    }

    @Override
    public int size() {
        return nodeMap.size();
    }

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class DLL {

        Node head;
        Node tail;
        int size;

        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
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
