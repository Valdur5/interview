package de.pandigo.tasks.graphs.dfs.topologicalSearch;

import java.util.*;

public class TopologicalSearch {

    private static TopologicalSearchImpl topologicalSearch = new TopologicalSearchImpl();

    public static void main(String [] args) {

        Map<Integer, List<Integer>> acyclicDirectedGraphMap = new HashMap<>();
        acyclicDirectedGraphMap.put(1, new ArrayList<>());
        acyclicDirectedGraphMap.put(2, Arrays.asList(1));
        acyclicDirectedGraphMap.put(3, Arrays.asList(1, 2));
        acyclicDirectedGraphMap.put(4, Arrays.asList(7));
        acyclicDirectedGraphMap.put(5, Arrays.asList(1));
        acyclicDirectedGraphMap.put(6, Arrays.asList(4, 5));
        acyclicDirectedGraphMap.put(7, Arrays.asList(5));
        acyclicDirectedGraphMap.put(8, new ArrayList<>());

        System.out.println("Working example: WORKING " + topologicalSearch.orderAcyclicDirectedGraph(acyclicDirectedGraphMap));

        Map<Integer, List<Integer>> acyclicDirectedGraphMap2 = new HashMap<>();
        acyclicDirectedGraphMap2.put(1, new ArrayList<>());
        acyclicDirectedGraphMap2.put(2, Arrays.asList(1));
        acyclicDirectedGraphMap2.put(3, Arrays.asList(1, 2));
        acyclicDirectedGraphMap2.put(4, Arrays.asList(1));
        acyclicDirectedGraphMap2.put(5, Arrays.asList(4, 1));
        acyclicDirectedGraphMap2.put(6, Arrays.asList(5, 3));
        acyclicDirectedGraphMap2.put(7, Arrays.asList(6));
        acyclicDirectedGraphMap2.put(8, new ArrayList<>());

        System.out.println("Working example: WORKING " + topologicalSearch.orderAcyclicDirectedGraph(acyclicDirectedGraphMap2));

        Map<Integer, List<Integer>> cyclicDirectedGraphMap = new HashMap<>();
        cyclicDirectedGraphMap.put(1, new ArrayList<>());
        cyclicDirectedGraphMap.put(2, Arrays.asList(1));
        cyclicDirectedGraphMap.put(3, Arrays.asList(4));
        cyclicDirectedGraphMap.put(4, Arrays.asList(3));
        cyclicDirectedGraphMap.put(5, Arrays.asList(1));
        try {
            topologicalSearch.orderAcyclicDirectedGraph(cyclicDirectedGraphMap);
            System.out.println("Cyclic example, FAILED cycle not detected.");
        } catch (RuntimeException e) {
            System.out.println("Cyclic example, WORKING exception catched.");
        }

        Map<Integer, List<Integer>> complexCyclicDirectedGraphMap = new HashMap<>();
        complexCyclicDirectedGraphMap.put(1, new ArrayList<>());
        complexCyclicDirectedGraphMap.put(2, Arrays.asList(3));
        complexCyclicDirectedGraphMap.put(3, Arrays.asList(4));
        complexCyclicDirectedGraphMap.put(4, Arrays.asList(5));
        complexCyclicDirectedGraphMap.put(5, Arrays.asList(2));
        try {
            topologicalSearch.orderAcyclicDirectedGraph(complexCyclicDirectedGraphMap);
            System.out.println("Complex cyclic example, FAILED cycle not detected.");
        } catch (RuntimeException e) {
            System.out.println("Complex cyclic example, WORKING exception catched.");
        }
    }
}
