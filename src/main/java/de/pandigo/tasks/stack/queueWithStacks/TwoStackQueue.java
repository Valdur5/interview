package de.pandigo.tasks.stack.queueWithStacks;

import java.util.Stack;

public class TwoStackQueue<T> {

    private Stack<T> enqueue = new Stack<>();
    private Stack<T> dequeue = new Stack<>();

    public void add(T number) {
        enqueue.add(number);
    }

    public T poll() {
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
