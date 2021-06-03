package L15A_Tries;

/*
 * Types of Tries:
 * 1) Suffix Trie
 * 2) Compressed Trie
 * 3) 1+2
 * 
 * HashMaps vs Tries
 * 
 * Time Complexity: Tries: O(wordLength)
 * 					HashMaps: O(wordLength)- HashCode =  each char * 31^smth = calculations
 * 
 *   So becz of calculations of HashCode Tries>>>HashMaps
 *   
 * Space Complexity: Tries>>HashMaps
 * +Tries can be used in various applications
 * 1. Pattern matching
 * 2. T9 dictionary
 * 3. Auto complete
 * 4. Spell Checker
 * 
 */