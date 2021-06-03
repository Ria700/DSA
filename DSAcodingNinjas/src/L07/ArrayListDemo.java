package L07;

import java.util.*;

public class ArrayListDemo {

	public static void main(String[] args) {
		
	// ArrayList is Dynamic array class which 
	// increases array size 1.5 times every time the  array is out of memory
		
	// ArrayList<Integer> list1 = new ArrayList<>(5);
		ArrayList<Integer> list1 = new ArrayList<>(); // Default Capacity = 10
	
	// Add 1
		list1.add(15);
		list1.add(20);
		list1.add(25);
	// Add 2
		list1.add(1, 100);
	// for each loop: Traverses each ELEMENT, not index
	// Also called Quick traversal
		for(int elem: list1) {
			System.out.println(elem);
			elem = 100; // for each loop can't edit/change the elements
		}
	// get()
	// set()
	// remove()
	
	// Elements stored in Array list just like in array(for references to indices) 
	}

}
