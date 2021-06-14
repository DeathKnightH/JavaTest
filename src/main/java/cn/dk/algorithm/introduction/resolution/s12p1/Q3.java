package cn.dk.algorithm.introduction.resolution.s12p1;

import cn.dk.common.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Q3 {
    public static void main(String[] args) {
        TreeNode<Integer, Integer> treeNode = Q1.practice3();
        nonRecursionIterator(treeNode);
    }

    /**
     * 中序遍历非递归写法，使用栈辅助
     * @param treeNode
     */
    public static void nonRecursionIterator(TreeNode<Integer, Integer> treeNode) {
        Deque<TreeNode<Integer, Integer>> treeNodeQueue = new LinkedList<>();
        TreeNode<Integer, Integer> current = treeNode;
        while (current != null || !treeNodeQueue.isEmpty()) {
            // 每次将当前结点的左斜边全部压入
            while (current != null) {
                treeNodeQueue.addLast(current);
                current = current.getLeft();
            }
            current = treeNodeQueue.pollLast();
            System.out.println(current.getKey());
            // 之后的 current 只取右子树，避免重复遍历左子树
            current = current.getRight();
        }
    }
}
