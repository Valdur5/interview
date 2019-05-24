package de.pandigo.queues.queueWithStacks;


import java.util.Stack;

public class RecursiveStackQueue {

    private Stack<Integer> internalStack = new Stack<>();

    public void add(Integer number) {
        internalStack.push(number);
    }

    public Integer poll() {
        if(internalStack.size() == 0) {
            throw new RuntimeException("The stack was empty");
        }
        return rec();
    }

    public Integer rec() {
        if(internalStack.size() == 1) {
            return internalStack.pop();
        }
        Integer tempValue = internalStack.pop();
        Integer returnValue = rec();
        internalStack.push(tempValue);
        return returnValue;
    }
}
