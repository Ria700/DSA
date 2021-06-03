package L18_OOPS4_TicTacToe;

public class Player {

	private String name;
	private char symbol;
	
	Player(String name, char symbol){
		setName(name);
		setSymbol(symbol);
	}

	public void setSymbol(char symbol) {
		if(symbol != '\0' || symbol != ' ') {
			this.symbol = symbol;
		}
	}

	public void setName(String name) {
		if(!name.isEmpty()) {
			this.name = name;
		}
	}
	
	public char getSymbol() {
		return this.symbol;
	}

	public String getName() {
		return this.name;
	}
}
