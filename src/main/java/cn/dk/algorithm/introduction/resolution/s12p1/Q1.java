package cn.dk.algorithm.introduction.resolution.s12p1;

import cn.dk.common.struct.TreeNode;
import cn.dk.common.tools.Frame;
import cn.dk.common.tools.TreePrinter;

public class Q1 {
    private static int[] keys = new int[]{1, 4, 5, 10, 16, 17, 21};

    private static TreeNode<Integer, Integer>[] treeNodeList;

    public static void main(String[] args) {
//        TreeNode<Integer, Integer> root = practice2();
        TreeNode<Integer, Integer> root = practice3();
//        TreeNode<Integer, Integer> root = practice4();
//        TreeNode<Integer, Integer> root = practice5();
//        TreeNode<Integer, Integer> root = practice6();
        Frame frame = new Frame(new TreePrinter<>(root));
    }

    private static void initNodes(){
        treeNodeList = new TreeNode[7];
        treeNodeList[0] = new TreeNode<>(1, 0);
        treeNodeList[1] = new TreeNode<>(4, 0);
        treeNodeList[2] = new TreeNode<>(5, 0);
        treeNodeList[3] = new TreeNode<>(10, 0);
        treeNodeList[4] = new TreeNode<>(16, 0);
        treeNodeList[5] = new TreeNode<>(17, 0);
        treeNodeList[6] = new TreeNode<>(21, 0);
    }

    private static TreeNode<Integer, Integer> practice2(){
        initNodes();
        treeNodeList[1].setLeft(treeNodeList[0]);
        treeNodeList[1].setRight(treeNodeList[2]);
        return treeNodeList[1];
    }

    static TreeNode<Integer, Integer> practice3(){
        initNodes();
        treeNodeList[3].setLeft(treeNodeList[1]);
        treeNodeList[3].setRight(treeNodeList[5]);
        treeNodeList[1].setLeft(treeNodeList[0]);
        treeNodeList[1].setRight(treeNodeList[2]);
        treeNodeList[5].setLeft(treeNodeList[4]);
        treeNodeList[5].setRight(treeNodeList[6]);
        return treeNodeList[3];
    }

    private static TreeNode<Integer, Integer> practice4(){
        initNodes();
        treeNodeList[3].setLeft(treeNodeList[1]);
        treeNodeList[3].setRight(treeNodeList[6]);
        treeNodeList[1].setLeft(treeNodeList[0]);
        treeNodeList[1].setRight(treeNodeList[2]);
        treeNodeList[6].setLeft(treeNodeList[5]);
        treeNodeList[5].setLeft(treeNodeList[4]);
        return treeNodeList[3];
    }

    private static TreeNode<Integer, Integer> practice5(){
        initNodes();
        treeNodeList[2].setLeft(treeNodeList[1]);
        treeNodeList[1].setLeft(treeNodeList[0]);
        treeNodeList[2].setRight(treeNodeList[6]);
        treeNodeList[6].setLeft(treeNodeList[5]);
        treeNodeList[5].setLeft(treeNodeList[4]);
        treeNodeList[4].setLeft(treeNodeList[3]);
        return treeNodeList[2];
    }

    private static TreeNode<Integer, Integer> practice6(){
        initNodes();
        treeNodeList[1].setLeft(treeNodeList[0]);
        treeNodeList[1].setRight(treeNodeList[6]);
        treeNodeList[6].setLeft(treeNodeList[5]);
        treeNodeList[5].setLeft(treeNodeList[4]);
        treeNodeList[4].setLeft(treeNodeList[3]);
        treeNodeList[3].setLeft(treeNodeList[2]);
        return treeNodeList[1];
    }
}
