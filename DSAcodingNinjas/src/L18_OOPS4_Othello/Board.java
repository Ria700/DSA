package L18_OOPS4_Othello;

public class Board {
	private char board[][];
	private int boardSize = 8;
	private char p1Symbol, p2Symbol;
	private int count;
	public final static int PLAYER_1_WINS = 1;
	public final static int PLAYER_2_WINS = 1;
	public final static int DRAW = 3;
	public final static int INCOMPLETE = 4;
	public final static int INVALID = 5;
	
	public Board(char p1Symbol, char p2Symbol) {
		board = new char[boardSize][boardSize];
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				board[i][j] = ' ';
			}
		}
		this.p1Symbol = p1Symbol;
		this.p2Symbol = p2Symbol;
		board[3][3]=p1Symbol;
		board[4][4]=p1Symbol;
		board[3][4]=p2Symbol;
		board[4][3]=p2Symbol;
	}

	public int move(char symbol, int x, int y) {
		int[] X_Dir = {-1,1,0,0,1,-1,1,-1 };
		int[] Y_Dir = {0,0,-1,1,1,-1,-1,1 };
		
		
		for(int k=0;k<X_Dir.length;k++) {
		int xstep = x+X_Dir[k];
		int ystep = y+Y_Dir[k];

		if( x>=0 && y>=0 && x< board.length &&
				y < board.length) {
		
			}
		}
		return 0;
	}

	public void print() {
		
		
	}
}
