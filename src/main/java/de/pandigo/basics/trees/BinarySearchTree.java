package de.pandigo.basics.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable> {

    private BinaryNode<T> rootNode;

    public BinarySearchTree(T startValue) {
        rootNode = new BinaryNode<>(startValue, 0);
    }

    public void addValue(T value) {
        BinaryNode<T> prevNode = dfs(rootNode, value, false);
        if(prevNode.getValue().compareTo(value) > 0) {
            prevNode.setLeft(new BinaryNode<>(value,prevNode.getLevel()+1));
        }
        if(prevNode.getValue().compareTo(value) < 0) {
            prevNode.setRight(new BinaryNode<>(value,prevNode.getLevel()+1));
        }
    }

    // PRINT TREE

    public void printTree() {
        System.out.println("====== Printing Tree ======");

        Queue<BinaryNode<T>> nextNodeQueue = new LinkedList<>();
        nextNodeQueue.add(rootNode);
        int currentLevel = 0;

        while(!nextNodeQueue.isEmpty()) {
            BinaryNode<T> currentNode = nextNodeQueue.poll();
            if (currentLevel != currentNode.getLevel()) {
                currentLevel = currentNode.getLevel();
                System.out.println();
            }
            System.out.print(currentNode.getValue()+ " ");
            if(currentNode.getLeft() != null) {
                nextNodeQueue.add(currentNode.getLeft());
            }
            if(currentNode.getRight() != null) {
                nextNodeQueue.add(currentNode.getRight());
            }
        }
    }

    // SEARCH IN TREE

    public BinaryNode<T> search(T value) {
        return dfs(rootNode, value, true);
    }

    private BinaryNode<T> dfs(BinaryNode<T> root, T value, boolean last) {
        if(last && root == null) {
            return null;
        }
        if(root.getValue().compareTo(value) > 0) {
            if(!last && root.getLeft() == null) {
                return root;
            }
            return dfs(root.getLeft(), value, last);
        } else if (root.getValue().compareTo(value) < 0) {
            if(!last && root.getRight() == null) {
                return root;
            }
            return dfs(root.getRight(), value, last);
        }
        return root;
    }

}
