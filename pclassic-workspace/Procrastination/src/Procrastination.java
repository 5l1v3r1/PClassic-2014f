import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Procrastination {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader("ProcrastinationIN.txt"));

		while(reader.ready()){

			int[][] board = new int[4][4];

			for(int row = 0; row < 4; row++){
				String ln = reader.readLine();
				String[] nums = ln.split(" ");

				for(int col = 0; col < 4; col++){
					board[row][col] = Integer.parseInt(nums[col].trim());
				}
			}

			System.out.println(procrastinate(board));

		}

		reader.close();
	}

	public static boolean procrastinate(int[][] board) {
		//fill in this stub
		
	}
	
	public static int[][] move(int[][] board, String direction) {
		int[][] copy = new int[4][4];
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				copy[i][j] = board[i][j];
			}
		}
		if (direction.equals("DOWN")) {
			
		}
	}
	
}