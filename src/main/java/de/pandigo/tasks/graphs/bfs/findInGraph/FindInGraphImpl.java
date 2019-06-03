package de.pandigo.tasks.graphs.bfs.findInGraph;

import de.pandigo.tasks.graphs.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindInGraphImpl {


    public BinaryNode find(BinaryNode rootNode, int valueToFind) {

        Queue<BinaryNode> nextNodeQueue = new LinkedList<>();
        nextNodeQueue.add(rootNode);

        while(!nextNodeQueue.isEmpty()) {
            BinaryNode currentNode = nextNodeQueue.poll();
            System.out.println("Checking node " + currentNode.getValue());
            if(currentNode.getValue() == valueToFind) {
                return currentNode;
            }
            if(currentNode.getLeft() != null) {
                nextNodeQueue.add(currentNode.getLeft());
            }
            if(currentNode.getRight() != null) {
                nextNodeQueue.add(currentNode.getRight());
            }
        }
        return null;
    }
}
