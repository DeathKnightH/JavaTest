package cn.dk.common.struct;

public class BSTTreeNode<K, V> extends TreeNode<K, V>{
    private BSTTreeNode<K, V> parent;
    public BSTTreeNode(K key, V value) {
        super(key, value);
    }

    public BSTTreeNode(K key, V value, TreeNode<K, V> left, TreeNode<K, V> right, BSTTreeNode<K, V> parent) {
        super(key, value, left, right);
        this.parent = parent;
    }

    public BSTTreeNode<K, V> getParent() {
        return parent;
    }

    public void setParent(BSTTreeNode<K, V> parent) {
        this.parent = parent;
    }
}
