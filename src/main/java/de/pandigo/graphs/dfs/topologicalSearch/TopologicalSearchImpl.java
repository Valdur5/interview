package de.pandigo.graphs.dfs.topologicalSearch;

import java.util.*;

public class TopologicalSearchImpl {


    /**
     * Method to order the dependencies in the graph and provide with a ordered solution.
     *
     * @param graph the acyclic directed graph, the key is the vertex (number) and the value is the list of vertexes which depend on the key.
     * @return the possible ordered list or null if it is not possible.
     */
    public List<Integer> orderAcyclicDirectedGraph(Map<Integer, List<Integer>> graph) {

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting;
        Stack<Integer> resultStack = new Stack<>();

        for(Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if(!visited.contains(entry.getKey())) {
                visited.add(entry.getKey());
                visiting = new HashSet<>();
                topologicalSearch(visited, graph, entry.getKey(), entry.getValue(), resultStack, visiting);
            }
        }
        return new ArrayList<>(resultStack);
    }

    private void topologicalSearch(Set<Integer> visited, Map<Integer, List<Integer>> graph, Integer currentVertex,
                                   List<Integer> childVertexes, Stack<Integer> resultStack, Set<Integer> visiting) {
        visiting.add(currentVertex);

        for (Integer childVertex : childVertexes) {
            if(visiting.contains(childVertex)) {
                throw new RuntimeException("Cyclic Graph detected.");
            }
            if(!visited.contains(childVertex)) {
                visited.add(childVertex);
                topologicalSearch(visited, graph, childVertex, graph.get(childVertex), resultStack, visiting);
            }
        }
        resultStack.push(currentVertex);
    }
}
