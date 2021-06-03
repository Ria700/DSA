package L19_Graphs;

/*
 * Tree is a special kind of graph. 
 * Properties of tree as graph:
 * 1. CONNECTED/NO BREAKAGE: Every node has connection to at least one node.
 * 2. ACYCLIC
 * 
 * Graph Terminologies:
 * 1. Adjacent vertices: If two vertices are directly connected through an edge.	A----->B
 * 2. Degree: no. of edges connected to an vertex.                                         |
 * 3. Path: To reach from A to c the path is A -> B -> C                                   |
 * 4. Connected Graph: If for every 2 vertices, there is PATH b/w them.                    V
 * example. the given graph is not a complete graph.								D	   C
 * 5. Connected components: The various components that can be made in a graph.
 * example. Here are 2
 * 6. Complete graph: When every vertex has a direst path/ an edge with every other vertex.
 * 7. Tree.
 * 8. DFS: Depth First Search: We are going in as much depth as possible.
 * 9. BFS: Breadth First Search
 * 
 * Formulas:
 * Consider a graph with n vertices.
 * min. edges: 0
 * min. edges in an connected graph: =TREE: n-1: O(n)
 * min. edges in a complete graph: =nC2: n(n-1)/2: O(n^2)
 * i.e. O(E): O(n)... O(n^2)
 * 
 * Graph implementation:
 * 1. Edge List: An array that  contains list of all edges present.
 * Not a good method as: To find a  simple entry we might have to do O(n^2) work.
 * 
 * 2. Adjacency List: Every vertices will have their own list of vertices they have an edge with.
 * ~O(n) or O(1)
 * 
 * 3. Adjacency Matrix: Very fast and easy to implement
 * But occupies a lot of space. 
 * 
 * Types of Graphs:
 * 1. Directed Graphs: For one-way roads.
 * Implementation: Instead of using
 * edges[sv][ev] = 1; & edges[ev][sv] = 1; 
 * "Use just 1".
 *  
 * 2. Weighted Graphs: For how important or weighted an edge is.
 * Implementation: Instead of making data of edges 1, fill it with the weight. 
 * edges[sv][ev] = 5;
 * 
 * 
 * */
