package sudoku;


	public class sudoku {
	  
	  private static final int BoardSize  = 9; // choose the row && column size
	  
	  public static void main(String[] args) {
	    
	    int[][] sudokuBoard = {
	        {7, 0, 2, 0, 5, 0, 6, 0, 0},
	        {0, 0, 0, 0, 0, 3, 0, 0, 0},
	        {1, 0, 0, 0, 0, 9, 5, 0, 0},
	        {8, 0, 0, 0, 0, 0, 0, 9, 0},
	        {0, 1, 3, 0, 0, 0, 7, 5, 0},
	        {0, 9, 0, 0, 0, 0, 0, 0, 4},
	        {0, 0, 9, 7, 0, 0, 0, 0, 5},
	        {0, 0, 0, 2, 0, 0, 0, 0, 0},
	        {0, 0, 7, 0, 4, 0, 2, 3, 0} //build the board
	      };
	    
	    System.out.println("The Unsolves dudoko is : ");
	    printBoard(sudokuBoard);
	    System.out.println();
	    
	    if (canBeSolve(sudokuBoard)) {
	    	System.out.println("This board is solvable!");
	    	printBoard(sudokuBoard);
	    }
	    else {
	    	System.out.println("This board isnt solvable!");
	    }
	    
	  }
	  
	  private static void printBoard(int[][] sudokuBoard) {
		System.out.println();
		for (int i = 0 ; i < BoardSize ; i++ ) {
			
			for (int j = 0 ; j < BoardSize ; j++) {
				System.out.print(sudokuBoard[i][j]+ " ");
			
			}
			System.out.println();
		}
	}

	private static boolean checkInRow(int[][] sudokuBoard, int num, int row) {
		
		    for (int i = 0; i < BoardSize; i++) {
		      if (sudokuBoard[row][i] == num) {
		        return true;
		      }
		    }
		    return false;
		  }
	//check for if the number is already on the row
	  
	  private static boolean checkInColumn(int[][] sudokuBoard, int num, int column) {
		    for (int i = 0; i < BoardSize; i++) {
		      if (sudokuBoard[i][column] == num) {
		        return true;
		      }
		    }
		    return false;
		  }
		// check for if the number is already on the column
	  
		private static boolean checkInBox(int [][]sudokuBoard , int row , int column , int num) {
			int rowBox = row - (row % 3);
			int columnBox = column - (column % 3);
			for (int i = rowBox; i < rowBox + 3 ; i++) {
				for (int j = columnBox ; j < columnBox + 3 ; j++) {
					if (sudokuBoard[i][j] == num) {
						return true;
					}
				}
			} 
			return false;
		}
		// check for if the number is already on the box
		// % 3  is because sudoku board is divide to 3X3 boxes
	  
		private static boolean validPlace(int [][]sudokuBoard , int row , int column , int num) {
			return (!checkInRow(sudokuBoard , num , row) && 
				!checkInColumn(sudokuBoard , num , column) && !checkInBox(sudokuBoard , row , column , num));
		}
		// one big algorithm that check with the whole 3 functions , to check the place
		
		private static boolean canBeSolve(int[][]sudokuBoard) {
			
			for (int i = 0 ; i < BoardSize ; i++ ) {
				for (int j = 0 ; j < BoardSize ; j ++ ) {
					if (sudokuBoard[i][j] == 0) {
						for (int numToCheck = 1 ; numToCheck <= BoardSize ; numToCheck ++ ) {
							if (validPlace(sudokuBoard , i , j , numToCheck)) {
								sudokuBoard[i][j] = numToCheck; // if the place&&number is valid
								if (canBeSolve (sudokuBoard)) {
									return true;
								}
								else {
									sudokuBoard[i][j]= 0; // if the number doesn't solve the board just zero the place
								}
							}
						}
						return false; // Can't be solved
					}
				}
			}
			return true;
		}
	}


	//int[][] sudokuBoard = {
	        //{7, 0, 5, 0, 2, 0, 6, 0, 0},
	        //{0, 0, 0, 0, 0, 3, 0, 0, 0},
	        //{1, 0, 0, 0, 0, 9, 5, 0, 0},
	        //{8, 0, 0, 0, 0, 0, 0, 9, 0},
	        //{0, 3, 4, 0, 0, 0, 7, 5, 0},
	        //{0, 9, 0, 0, 0, 0, 0, 0, 8},
	        //{0, 0, 9, 7, 0, 0, 0, 0, 6},
	        //{3, 0, 0, 2, 0, 0, 0, 0, 0},
	        //{0, 0, 7, 0, 4, 0, 2, 3, 0} 
//	      }; Example - Unsolved sudoku board




