package sokdu;

public class Main {

	
	public static void main(String [] args){
		Sudoku martix = new Sudoku();
		int [][] sudoku = martix.start();
		for(int i = 0; i < 9; i++){
			System.out.println();
			for(int j = 0; j < 9; j++){
				System.out.print(sudoku[i][j] + " ");
			}
		}
	}
}
