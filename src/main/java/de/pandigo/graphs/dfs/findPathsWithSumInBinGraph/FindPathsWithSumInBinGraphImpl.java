package de.pandigo.graphs.dfs.findPathsWithSumInBinGraph;

import de.pandigo.graphs.BinaryNode;

import java.util.ArrayList;
import java.util.List;

public class FindPathsWithSumInBinGraphImpl {

    /**
     * Method to trigger the recursive function.
     * @param node the root of the graph.
     * @param sum the sum we are searching paths for.
     * @return the list of possible paths in the graph to reach the sum.
     */
    public List<List<Integer>> findPathsWithSumInGraph(BinaryNode node, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        
        findPath(node, paths, new ArrayList<>(), sum);
        
        return paths;
    }

    /**
     * Recursive function to visit all nodes in the graph.
     * @param node the node of the graph which should be checked, first this is the real root, late this point moves through the graph.
     * @param paths the list which can be filled with valid paths, this list is later returned.
     * @param currentPath the current path we are currently investigating.
     * @param sum the sum we are searching for. This value gets decreased when diving deeper into the graph.
     */
    private void findPath(BinaryNode node, List<List<Integer>> paths, ArrayList<Integer> currentPath, int sum) {
        if(node == null) {
            return;
        }

        // Add the current node to the current Path.
        currentPath.add(node.getValue());

        // First two conditions check if we found a leaf, the last condition checks if the path until this leaf
        // already subtracted enough from the sum so that the value of the leaf is equals to the rest of the sum.
        // This means the path did sum up to the initial sum, this are the cases we search.
        if(node.getLeft() == null && node.getRight() == null && node.getValue() == sum) {
            paths.add(currentPath);
            return; // We can return since we reached a leaf
        }

        // In case we did not reach a leaf we need to recurse deeper.
        // This call has two interesting parts, first we copy the currentPath so for each continuations a separate
        // copy can be filled. Second the sum searched for is decreased by the value of the current node, so that
        // in the following recursions only a reduced sum needs to be searched for.
        findPath(node.getLeft(), paths, new ArrayList<>(currentPath), sum- node.getValue());
        findPath(node.getRight(), paths, new ArrayList<>(currentPath), sum- node.getValue());
    }
}
