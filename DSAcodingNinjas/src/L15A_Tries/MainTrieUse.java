package L15A_Tries;

public class MainTrieUse {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.add("new");
		t.add("news");
		t.add("net");
		t.add("a");
		System.out.println(t.countWords());
		
	}

}
