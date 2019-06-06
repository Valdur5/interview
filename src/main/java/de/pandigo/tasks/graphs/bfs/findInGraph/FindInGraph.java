package de.pandigo.tasks.graphs.bfs.findInGraph;

import de.pandigo.tasks.graphs.NodeUtils;

public class FindInGraph {

    private static FindInGraphImpl findInGraph = new FindInGraphImpl();

    public static void main(String[] args) {
        System.out.println("Found node: " + findInGraph.find(NodeUtils.createBinaryNodeFullGraph(), 7).getValue());
        System.out.println("Found node: " + findInGraph.find(NodeUtils.createBinaryNodeFullGraph(), 8).getValue());
        System.out.println("Found node: " + findInGraph.find(NodeUtils.createBinaryNodeFullGraph(), 9).getValue());
    }
}
