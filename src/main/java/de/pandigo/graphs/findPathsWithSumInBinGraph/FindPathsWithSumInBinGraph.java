package de.pandigo.graphs.findPathsWithSumInBinGraph;

import java.util.List;

public class FindPathsWithSumInBinGraph {

    private static FindPathsWithSumInBinGraphImpl findPathsWithSumInBinGraph = new FindPathsWithSumInBinGraphImpl();

    public static void main(String [] args) {
        TreeGraph leftSide = new TreeGraph(4,
                new TreeGraph(1, new TreeGraph(3, null,null), new TreeGraph(5, null, null)),
                new TreeGraph(4, new TreeGraph(5, null, null), new TreeGraph(2, null, null)));
        TreeGraph rightSide = new TreeGraph(5,
                new TreeGraph(5, new TreeGraph(2, null,null), new TreeGraph(1, null, null)),
                new TreeGraph(2, new TreeGraph(1, null, null), new TreeGraph(3, null, null)));

        TreeGraph graph = new TreeGraph(4, leftSide, rightSide);

        List<List<Integer>> resultList = findPathsWithSumInBinGraph.findPathsWithSumInGraph(graph, 14);

        for(List<Integer> path : resultList) {
            System.out.println(path);
        }
    }




}

