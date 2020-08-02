package com.viveksb007.ds;

import java.util.ArrayList;
import java.util.List;

public class AVLTree {

    private Node root;

    public Node insert(int val) {
        root = insert(root, val);
        return root;
    }

    private Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && val < node.left.val) {
            return rightRotate(node);
        }

        if (balance < -1 && val > node.right.val) {
            return leftRotate(node);
        }

        if (balance > 1 && val > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && val < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public List<Integer> inOrderTraversal() {
        List<Integer> sol = new ArrayList<>();
        inOrderUtil(root, sol);
        return sol;
    }

    private void inOrderUtil(Node node, List<Integer> sol) {
        if (node == null) return;
        inOrderUtil(node.left, sol);
        sol.add(node.val);
        inOrderUtil(node.right, sol);
    }

    /*
     *          y
     *           \
     *            x
     *             \
     *              z
     * */
    private Node leftRotate(Node y) {
        Node x = y.right;

        y.right = x.left;
        x.left = y;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return x;
    }

    /*
     *         y
     *        /
     *       x
     *      /
     *     z
     *
     * */
    private Node rightRotate(Node y) {
        Node x = y.left;

        y.left = x.right;
        x.right = y;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return x;
    }

    private int getBalance(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    static class Node {
        int val;
        int height;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

}
