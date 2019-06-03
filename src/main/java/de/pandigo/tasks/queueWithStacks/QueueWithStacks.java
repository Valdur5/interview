package de.pandigo.tasks.queueWithStacks;

public class QueueWithStacks {


    private static RecursiveStackQueue recursiveStackQueue = new RecursiveStackQueue();
    private static TwoStackQueue twoStackQueue = new TwoStackQueue();

    public static void main(String [] args) {

        System.out.println("===============================");
        System.out.println("TEST FOR THE RECURSIVE STACK");
        System.out.println("===============================");

        recursiveStackQueue.add(1);
        recursiveStackQueue.add(2);
        recursiveStackQueue.add(3);

        System.out.println("Poll the first time: "+recursiveStackQueue.poll());
        System.out.println("Poll the second time: "+recursiveStackQueue.poll());
        System.out.println("Poll the third time: "+recursiveStackQueue.poll());
        try {
            System.out.println(recursiveStackQueue.poll());
        } catch (RuntimeException e) {
            System.out.println("Fourth time poll is not allowed!: "+ e.getLocalizedMessage());
        }

        System.out.println("===============================");
        System.out.println("TEST FOR THE TWO STACK SOLUTION");
        System.out.println("===============================");

        twoStackQueue.add(1);
        twoStackQueue.add(2);
        twoStackQueue.add(3);

        System.out.println("Poll the first time: "+twoStackQueue.poll());
        System.out.println("Poll the second time: "+twoStackQueue.poll());
        System.out.println("Poll the third time: "+twoStackQueue.poll());
        try {
            System.out.println(twoStackQueue.poll());
        } catch (RuntimeException e) {
            System.out.println("Fourth time poll is not allowed!: "+ e.getLocalizedMessage());
        }
    }
}
