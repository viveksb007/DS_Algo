package com.viveksb007.ds;

import java.util.LinkedList;

public class HashMap<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Node<K, V>>[] array;
    private int size = 0;

    HashMap(int capacity) {
        array = new LinkedList[capacity];
    }

    HashMap() {
        array = new LinkedList[INITIAL_CAPACITY];
    }

    public void put(K key, V value) {
        int index = key.hashCode() % array.length;
        if (array[index] == null) array[index] = new LinkedList<>();
        LinkedList<Node<K, V>> list = array[index];
        for (Node<K, V> node : list) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        list.add(new Node<>(key, value));
        size++;
    }

    public V getValue(K key) {
        int index = key.hashCode() % array.length;
        LinkedList<Node<K, V>> list = array[index];
        if (list == null) return null;
        for (Node<K, V> node : list) {
            if (node.getKey() == key) {
                return node.getValue();
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    static class Node<K, V> {
        private K key;
        private V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

    }
}
