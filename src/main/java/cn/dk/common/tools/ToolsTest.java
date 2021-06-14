package cn.dk.common.tools;

import cn.dk.common.struct.TreeNode;

public class ToolsTest {
    public static void main(String[] args) {
        TreeNode<Integer, Integer> testTree = new TreeNode<>(1, 100);
        TreeNode<Integer, Integer> node2 = new TreeNode<>(2, 200);
        TreeNode<Integer, Integer> node3 = new TreeNode<>(3, 200);
        TreeNode<Integer, Integer> node4 = new TreeNode<>(4, 200);
        testTree.setLeft(node2);
        testTree.setRight(node3);
        node3.setLeft(node4);
        Frame frame = new Frame(new TreePrinter<>(testTree));
    }
}
