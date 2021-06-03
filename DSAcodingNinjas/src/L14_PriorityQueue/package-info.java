package L14_PriorityQueue;

/*
 * A. MAX Priority Queue- Gets elements w/ MAX Priority
 * B. MIN Priority Queue- ... MIN Priority
 * 
 * Functions of a priority Queue:
 * 1. getMax() / getMin()
 * 2. insert()
 * 3. removeMax() / removeMin()
 * 
 * 
 * Heap Properties:
 * 1. CBT-Complete Binary Tree
 * 2. Heap order property
 * 
 * Heap height(h): h~logn(base2)
 * 
 *  Important Terms:
 *  a. Up-Heapify:
 *  b. Down-Heapify:
 *  
 *  ith node ---> left child: 2*i+1
 *           ---> right child: 2*i+2
 *           
 *  ith node parent ---> (i-1)/2
 *  
 *  TIME COMPLEXITY of Heap Sort:
 *  O(nlogn)
 *  Both insertion and deletion
 *  
 *  Explanation: Complexity of inserting 1 element in
 *  heap is O(1) + O(height)     =   O(logn)
 *                  ^ For heapify
 *  SO TO INSERT n ELEMENTS: Time Complexity = o(nlogn)
 *  
 *  SPACE COMPLEXITY: O(n)
 *  Bec we make an array extra array for making heap
 */