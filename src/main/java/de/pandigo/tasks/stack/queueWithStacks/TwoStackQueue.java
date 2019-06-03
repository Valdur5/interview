package de.pandigo.tasks.stack.queueWithStacks;

import java.util.Stack;

public class TwoStackQueue {

    private Stack<Integer> enqueue = new Stack<>();
    private Stack<Integer> dequeue = new Stack<>();

    public void add(Integer number) {
        enqueue.add(number);
    }

    public Integer poll() {
        if(dequeue.size() > 0) {
            return dequeue.pop();
        }
        else if (enqueue.size() > 0) {
            int enqueueSize = enqueue.size();
            for(int i = 0; i < enqueueSize; i++) {
                dequeue.push(enqueue.pop());
            }
            return dequeue.pop();
        }
        throw new RuntimeException("The queue is empty");
    }
}
