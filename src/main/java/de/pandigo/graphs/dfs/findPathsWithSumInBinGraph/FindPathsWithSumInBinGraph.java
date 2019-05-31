package de.pandigo.graphs.dfs.findPathsWithSumInBinGraph;

import de.pandigo.graphs.NodeUtils;

import java.util.List;

public class FindPathsWithSumInBinGraph {

    private static FindPathsWithSumInBinGraphImpl findPathsWithSumInBinGraph = new FindPathsWithSumInBinGraphImpl();

    public static void main(String [] args) {

        List<List<Integer>> resultList = findPathsWithSumInBinGraph.findPathsWithSumInGraph(
                NodeUtils.createBinaryNodeFullGraph(), 14);

        for(List<Integer> path : resultList) {
            System.out.println(path);
        }
    }




}

