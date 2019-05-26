package de.pandigo.graphs.findPathsWithSumInBinGraph;

public class TreeGraph {

    private int value;
    private TreeGraph left;
    private TreeGraph right;

    public TreeGraph(int value, TreeGraph left, TreeGraph right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeGraph getLeft() {
        return left;
    }

    public void setLeft(TreeGraph left) {
        this.left = left;
    }

    public TreeGraph getRight() {
        return right;
    }

    public void setRight(TreeGraph right) {
        this.right = right;
    }
}
