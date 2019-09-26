package Assignment1;

public class NRooks {
	final int n = 8;
	public static void main(String[] args) {
		NRooks nrs = new NRooks();
		nrs.initialize(); 
		}
	
	
		void initialize() {
			int[][] board= {
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0}
							};
		if(findSolution(board,0)==false) 
			System.out.println("No Solution Exists");
		printBoard(board);
	}
		
		boolean findSolution(int[][] board, int col) {
			if(col>=n)
				return true;
			for(int i=0;i<n;i++) {
				if(putOnBoard(board,i,col)) {
					board[i][col]=1;
					if(findSolution(board,col+1)==true)
					return true;		
					board[i][col] = 0;
				}
			}
			return false;
		}

		boolean putOnBoard(int[][] board, int row, int col) {
			int i;
			//check all columns
			for(i=0;i<col;i++) {
				if(board[row][i]==1) {
					return false;
				}
			}
			//check all rows
			for(i = col + 1; i < n; i++) {
				if(board[i][col]==1) {
					return false;
				}
			}
			
			for(i = col - 1; i > -1; i--) {
				if(board[i][col]==1) {
					return false;
				}
			}
			return true;
		}

	    void printBoard(int[][] board) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if (board[i][j] == 1) {
					System.out.print("R ");
					}else {
					System.out.print("_ ");
					}
			    }
				System.out.println();
		   }
        }
}
