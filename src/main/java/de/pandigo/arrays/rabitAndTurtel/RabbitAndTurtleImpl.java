package de.pandigo.arrays.rabitAndTurtel;

public class RabbitAndTurtleImpl {

    public boolean isCyclic(int[] array) {
        int rabbitIndex = 0;
        int turtleIndex = 0;

        while(true) {
            // If the indexes out of the array it means that there is no cycle in the array.
            if(rabbitIndex < 0 || rabbitIndex >= array.length || turtleIndex < 0 || turtleIndex >= array.length) {
                return false;
            }
            // Move the rabbit two steps
            for(int i=0; i<2; i++) {
                rabbitIndex = array[rabbitIndex];
                if(rabbitIndex < 0 || rabbitIndex >= array.length) {
                    return false;
                }
                if(rabbitIndex == turtleIndex) {
                    return true;
                }
            }
            // Move the turtle one step (it cant be outside before the rabbit, therefore there is no check for the
            // array boundaries.
            turtleIndex = array[turtleIndex];
            if(rabbitIndex == turtleIndex) {
                return true;
            }
        }
    }
}
