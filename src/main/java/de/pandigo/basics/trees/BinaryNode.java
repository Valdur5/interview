package de.pandigo.basics.trees;

public class BinaryNode<T> {

    private T value;
    private BinaryNode left;
    private BinaryNode right;
    private int level;

    public BinaryNode(T value, int level) {
        this.value = value;
        this.level = level;
    }

    public BinaryNode(T value, BinaryNode left, BinaryNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
