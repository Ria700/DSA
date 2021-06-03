package L04_JaggedArrayNEmptyArray;

/* Revision 2D Array
 * int[][] a = new int[m][n];
 * row length: a.length
 * column length: a[row.no].length
 *(for normal array a[0].length) 
 */
  
 



/* JAGGED ARRAY is a type of 2D Array 
 * in which you define the number of Rows but not the number of Columns
 * AND EVERY ROW CAN HAVE DIFFERENT NUMBER OF COLUMNS
 *
 * eg.
 * int output[][] = new int[5][0];
 * 
 *
 * To define the Number of columns of each row you need to 
 * Allocate memory individually to each row like thissss:
 *
 * output[0] = new int[p];
 * Allocates 0th row p columns
 */



/* How to define an empty array
 * int input[] = {};
 * int input[][] = {};

 * int input[][] = [0][0];*/