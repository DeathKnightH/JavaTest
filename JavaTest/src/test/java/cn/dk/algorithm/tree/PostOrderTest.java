package cn.dk.algorithm.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class PostOrderTest {

    @Test
    public void postOrderNoRecursion() {
        int i = PostOrder.postOrderNoRecursion(BinaryTreeStub.generateNormalBinaryTree());
    }
}