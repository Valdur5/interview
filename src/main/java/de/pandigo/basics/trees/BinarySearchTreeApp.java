package de.pandigo.basics.trees;

public class BinarySearchTreeApp {


    public static void main(String[] args) {

        /**
         * Constructing the following binary search tree.
         *
         *
         */
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(5);
        binarySearchTree.addValue(3);
        binarySearchTree.addValue(7);

        binarySearchTree.addValue(1);

        binarySearchTree.addValue(4);


        System.out.println(binarySearchTree.search(3).getValue());
        System.out.println(binarySearchTree.search(7).getValue());
        binarySearchTree.addValue(19);
        System.out.println(binarySearchTree.search(19).getValue());

        binarySearchTree.addValue(22);
        System.out.println(binarySearchTree.search(22).getValue());
        binarySearchTree.addValue(23);
        System.out.println(binarySearchTree.search(23).getValue());

        binarySearchTree.printTree();

    }

}
