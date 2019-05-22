The task is to find a combination where some dependencies needs to be built.

1: []
2: [1]
3: [1, 2]
4: [7]
5: [1]
6: [4, 5]
7: [5]
8: []

There can be different solutions, a possible solution would be:

1, 2, 3, 5, 7, 4, 6, 8

Also cycles should be detected, for example if 3 depends on 4 and 4 depends on 3, 
and exception should be thrown.

Solution: The algorithm used is a topological search with a time complexity of O(E+V)
where E are the edges and V are the vertexes. 