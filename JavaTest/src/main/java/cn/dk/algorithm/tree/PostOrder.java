package cn.dk.algorithm.tree;

import java.util.Stack;

public class PostOrder {
    /**
     * 非递归的二叉树后序遍历
     * @param root
     * @return 遍历节点次数
     */
    public static int postOrderNoRecursion(BinaryTreeNode root){
        if (root == null){
            return 0;
        }
        int sum = 0;
        Stack<BinaryTreeNode> parentStack = new Stack<>();
        BinaryTreeNode temp = root;
        BinaryTreeNode lastNode = null;    //上一个已经访问过的结点
        while (temp != null){     //移动到最左下的叶子节点
            parentStack.push(temp);
            temp = temp.getLeftNode();
            sum++;
        }

        //开始正式后序遍历
        while (!parentStack.isEmpty()){
            temp = parentStack.peek();
            if(temp.getRightNode() == null || temp.getRightNode() == lastNode){
                BinaryTreeNode out = parentStack.pop();
                System.out.println(out.getValue());
                lastNode = out;
            }else {
                BinaryTreeNode rightRoot = temp.getRightNode();
                while (rightRoot != null){     //移动到最左下的叶子节点
                    parentStack.push(rightRoot);
                    rightRoot = rightRoot.getLeftNode();
                    sum ++;
                }
            }

        }
        return sum;
    }
}
