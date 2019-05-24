# Queue With Two Stacks

### Task

Implement a queue with stacks.

### Solution - Two stacks

* Enqueue
* Dequeue

As long as only items added to the queue the items are pushed onto the Enqueue stack.
If the Dequeue stack has items a get operation in the queue will pop entries from the Dequeue stack.
Only if the Dequeue stack is empty all items are copied from the Enqueue stack to the Dequeue stack when a get operation happens.
If new stuff is added it always is added to the Enqueue stack.

### Solution - Recursive

Another solution is to use only one stack. If we want to pop an item we need to recursively
go into the stack save all values on the way and return the first added item. After that all
the recursive iteration need to push again the temporarily stored values.

