package de.pandigo.tasks.graphs;

public class NodeUtils {

    /**
     *        4
     *    4        5
     *  1   4    7   2
     * 3 5 9 2  2 8 1 3
     *
     * @return a sample graph
     */
    public static BinaryNode createBinaryNodeFullGraph() {
        BinaryNode leftSide = new BinaryNode(4,
                new BinaryNode(1, new BinaryNode(3, null,null), new BinaryNode(5, null, null)),
                new BinaryNode(4, new BinaryNode(9, null, null), new BinaryNode(2, null, null)));
        BinaryNode rightSide = new BinaryNode(5,
                new BinaryNode(7, new BinaryNode(2, null,null), new BinaryNode(8, null, null)),
                new BinaryNode(2, new BinaryNode(1, null, null), new BinaryNode(3, null, null)));

        return new BinaryNode(4, leftSide, rightSide);
    }
}
