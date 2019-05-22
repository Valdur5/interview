package de.pandigo.arrays.rabitAndTurtel;

public class RabbitAndTurtle {

    private static RabbitAndTurtleImpl rabbitAndTurtle = new RabbitAndTurtleImpl();

    public static void main(String [] args) {

        System.out.println("Not cyclic should be false: " + rabbitAndTurtle.isCyclic(new int [] {1, 2, 3, 4, 5, 6}));
        System.out.println("Cyclic should be true: "+ rabbitAndTurtle.isCyclic(new int [] {1, 2, 1, 4, 5, 6}));
    }
}
