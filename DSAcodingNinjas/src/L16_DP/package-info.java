package L16_DP;

/*
 * Use DP and memoization where there are:
 * 1. Overlapping sub-problems
 *    eg. fib(n) = fib(n-1) + fib(n-2)
 *        fib(n-1) = fib(n-2) + fib(...
 *        
 *        So, fib(n-2) is being calculated multiple times.
 * 2. Optimal sub-structure
 * 	  eg. if fib(n-1) and fib(n-2) can give fib(n) it is an 
 *    optimal sub-structure
 */