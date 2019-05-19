package de.pandigo.connectedColors;

public class ConnectedColors {

    private static Array2dRecursive array2dRecursive = new Array2dRecursive();

    public static void main(String[] args) {
        array2dRecursive.calculateConnectedFields(new int [][] {
                {1, 2, 3, 3, 2},
                {2, 2, 1, 3, 2},
                {1, 2, 3, 3, 3}
        });

        array2dRecursive.calculateConnectedFields(new int [][] {
                {1, 2, 3, 3, 2},
                {2, 2, 2, 2, 2},
                {1, 2, 3, 3, 3}
        });

        array2dRecursive.calculateConnectedFields(new int [][] {
                {1, 2, 3, 3, 2},
                {2, 2, 1, 2, 2},
                {1, 2, 3, 3, 3}
        });
    }
}
