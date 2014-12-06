import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class APenguinJumpedOverTheMoon {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (
				new FileReader ("APenguinJumpedOverTheMoonIN.txt"));
		
		while (br.ready()) {
			String line = br.readLine();
			String[] tokens = line.split(" ");
			int launch_x = Integer.parseInt(tokens[0]);
			int launch_y = Integer.parseInt(tokens[1]);
			int land_r = Integer.parseInt(tokens[2]);
			int land_x = Integer.parseInt(tokens[3]);
			int land_y = Integer.parseInt(tokens[4]);
			int land_w = Integer.parseInt(tokens[5]);
			int land_h = Integer.parseInt(tokens[6]);
			
			System.out.println(canWeSucceed(launch_x, launch_y, land_r,
											land_x, land_y, land_w, land_h));
		}
		
		br.close();
	}
	public static boolean canWeSucceed(	int launch_x, int launch_y, int land_r,
									int land_x, int land_y, int land_w, 
									int land_h) {
                //Fill in this stub
	}
}
