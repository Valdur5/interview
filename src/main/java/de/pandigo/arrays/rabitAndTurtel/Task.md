Given an array of integers which represent the following position in the array we need to write an algorithm to identify if an array contain cyclic dependencies. 

Example: 1, 2, 3, 4, 5

Result: No cyclic dependencies, starting from index 0 the first position sets the pointer to 1.
In position 1 the pointer is set to 2. This continues until the last index sets the pointer outside the array.
This terminates the algorithm and false is returned (representing not cyclic).

Example 1, 2, 1, 3

Result: When reaching index 2 the pointer is set to 1 again which then points to 2.
This is a cycle and the algorithm should return false.

Solution: This is solved with a rabbit turtle algorithm. The trick is that the rabbit moves twice as fast
as the turtle. Therefore when the turtle and the rabbit meet it means that there is
a cycle.