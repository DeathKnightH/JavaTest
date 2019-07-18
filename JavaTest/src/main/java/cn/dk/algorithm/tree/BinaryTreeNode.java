package cn.dk.algorithm.tree;

public class BinaryTreeNode {
    private int value;
    private BinaryTreeNode leftNode;
    private BinaryTreeNode rightNode;

    public BinaryTreeNode(int value, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }
}
