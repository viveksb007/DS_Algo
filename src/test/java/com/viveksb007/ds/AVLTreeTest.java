package com.viveksb007.ds;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class AVLTreeTest {

    @Test
    public void testAVLTree() {
        AVLTree tree = new AVLTree();
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        tree.insert(7);
        tree.insert(40);
        tree.insert(2);
        tree.insert(3);
        tree.insert(16);
        System.out.println(tree.inOrderTraversal());
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 7, 16, 40), tree.inOrderTraversal());
    }

}
