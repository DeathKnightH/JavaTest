package cn.dk.common.tools;

import cn.dk.common.struct.TreeNode;
import sun.font.FontDesignMetrics;

import javax.swing.*;
import java.awt.*;

public class TreePrinter<K, V> extends JPanel{
    public static final int ROUND = 16;
    public static final int SPACE = 16;
    protected TreeNode<K, V> treeNode;

    protected Graphics2D g2d;

    private Color defaultColor;

    private int rootX;

    public TreePrinter(TreeNode<K, V> treeNode) {
        this.treeNode = treeNode;
        this.defaultColor = Color.black;
    }

    public Color getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }

    @Override
    public void paint(Graphics g) {
        g2d = (Graphics2D) g;
        g2d.setBackground(Color.white);
        int height = countHeight(treeNode);
        int space= calculateRootX(height);
        drawTree(rootX, ROUND, space, treeNode);
    }

    /**
     * 从根开始画树
     * @param rootX 根的横坐标
     * @param rootY 根的纵坐标
     */
    protected void drawTree(int rootX, int rootY, int space, TreeNode<K, V> treeNode){
        drawTreeNode(rootX, rootY, treeNode);
        if (treeNode.getLeft() != null){
            drawTreeLine(rootX, rootY, space, true);
            drawTree(rootX - space, rootY + SPACE, space/2, treeNode.getLeft());
        }
        if (treeNode.getRight() != null){
            drawTreeLine(rootX, rootY, space, false);
            drawTree(rootX + space, rootY + SPACE, space/2, treeNode.getRight());
        }
    }

    private int calculateRootX(int height){
        int basicSpace = SPACE;
        rootX = basicSpace;
        for (int i = 0; i < height - 1; i++) {
            basicSpace *= 2;
            rootX += basicSpace;
        }
        return basicSpace;
    }

    private int countHeight(TreeNode<K, V> treeNode){
        if(treeNode == null){
            return 0;
        }
        if (treeNode.getLeft() == null && treeNode.getRight() == null){
            return 1;
        }
        int leftHeight = countHeight(treeNode.getLeft());
        int rightHeight = countHeight(treeNode.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    protected int countLeft(TreeNode<K, V> treeNode){
        int sum = 0;
        while (treeNode != null){
            sum ++;
            treeNode = treeNode.getLeft();
        }
        return sum;
    }

    private void drawTreeLine(int x, int y, int space, boolean left){
        g2d.setColor(Color.black);
        int offset = (int) Math.sqrt(2*ROUND - 1);
        if(left){
            g2d.drawLine(x - ROUND + 1, y + offset, x - space + ROUND - 1, y + SPACE - offset);
        }else {
            g2d.drawLine(x + ROUND - 1, y + offset, x + space - ROUND + 1, y + SPACE - offset);
        }
        initColor();
    }

    private void drawTreeNode(int x, int y, TreeNode<K, V> node){
        drawNode(x, y, ROUND);
        drawKey(x, y, node.getKey());
    }

    /**
     * 画树的结点，以 x,y 为中心
     * @param x 横坐标
     * @param y 纵坐标
     * @param r 半径
     */
    protected void drawNode(int x, int y, int r){
        g2d.setColor(Color.black);
        g2d.drawOval(x - r, y - r, 2*r, 2*r);
        g2d.setColor(Color.WHITE);
        g2d.fillOval(x - r, y - r, 2*r, 2*r);
        initColor();
    }

    /**
     * 画树的 key 值
     * @param x 横坐标
     * @param y 纵坐标
     * @param key node 的 key 值
     */
    protected void drawKey(int x, int y, K key){
        g2d.setColor(Color.black);
        FontDesignMetrics fontDesignMetrics = FontDesignMetrics.getMetrics(getFont());
        String string = key.toString();
        int width = fontDesignMetrics.stringWidth(string);
        int height = fontDesignMetrics.getHeight();
        g2d.drawString(string, x - width/2, y + height/2 - fontDesignMetrics.getAscent()/2);
        initColor();
    }

    private void initColor(){
        g2d.setColor(defaultColor);
    }
}
