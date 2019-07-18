package cn.dk.algorithm.tree;

public class BinaryTreeStub {
    /**
     * 生成一个正常的二叉树
     * 前序遍历为 124356
     * 中序遍历为 421536
     * 后序遍历为 425631
     * @return
     */
    public static BinaryTreeNode generateNormalBinaryTree(){
        BinaryTreeNode node6 = new BinaryTreeNode(6,null,null);
        BinaryTreeNode node5 = new BinaryTreeNode(5,null,null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node5, node6);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4,null);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
        return node1;
    }
}
