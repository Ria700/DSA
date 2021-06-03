package L13_HashMaps;


/*
 * HashMaps can be implemented using
 * 1. Tree Map - [Operations: O(logn)] 
 * 2. Hash Tables - [Operations: O(n)] (Only containsValue() of O(n))
 * 
 * Note: 3. Implementation using LL - [Operations: O(n)]
 * 		 Not preferable
 * 
 * 
 * 
 * IMPORTANT TERMS:
 * A. Hash Function:
 * B. Bucket Array:
 * C. Hash Code:
 * 	 	1. Integer -> Integer
 * 		2. sum of ASCII values
 * 		3. sum of first 3 ASCII values
 * 		4. BASE 6 number
 *  	5. For non-primitives:  Address -> Hexadecimal no. -> convert 
 * D. Compression function: (Best option: %),
 * E. Collision Handling:  
 * 		1. Close Addressing: Use of LL called SEPARATE CHAINING(useful) 
 *  	2. Open Addressing:  Use of f(i)
 *  		hi(a) = hF(a) + F(i)
 *  		a. Linear probing: F(i) -> i
 *  		b. Quadratic probing: F(i) -> i^2
 *  		c. Double Hashing: F(i) + i*h'(a)
 *  F: Load Factor: size/numBuckets = n/b
 *     A good hash map has n/b<0.7
 * 
 * 
 */
