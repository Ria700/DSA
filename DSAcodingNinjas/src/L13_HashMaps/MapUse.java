package L13_HashMaps;

import java.util.HashMap;
import java.util.Set;

public class MapUse {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("abc", 2);
		map.put("def", 1);
		map.put("abc", 2);
		map.put("def", 1);
		
		// size
		System.out.println("size: " + map.size());
		
		// check Presence
		if(map.containsKey("abc")) {
			System.out.println("Has abc");
		}
		
		if(map.containsKey("abc1")) {
			System.out.println("Has abc1");
		}
		
		if(map.containsValue(2)) {
			System.out.println("has 2 as value");
		}
		
		// get Value
		//int v = map.get("abc1"); // VERY WRONG STATEMENT
								 // Because int copies the value directly pointed by Integer
								 // And get NULL if the key is not present
		//System.out.println(v);
		
		//Rather do this :
		int v = 0;
		if(map.containsKey("abc1")) {
			v = map.get("abc");
		}
		System.out.println(v);
		
		//remove
		int s = map.remove("abc");
		System.out.println(s);
		
		// iterate
		Set<String> keys = map.keySet();
		for(String str : keys) {
			System.out.println(str);
		}
	}

}
