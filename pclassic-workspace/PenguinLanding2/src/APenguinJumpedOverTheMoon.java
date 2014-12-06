import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class APenguinJumpedOverTheMoon {

	public static class Point {
		public int x;
		public int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		boolean insideCircle(Point center, int radius) {
			double distance = Math.sqrt(Math.pow((double)(center.x - x), 2) +
					Math.pow((double)(center.y - y), 2));
			// Fix rounding issues by adding 0.00001
			return distance <= (double)radius;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (
			new FileReader ("APenguinJumpedOverTheMoonIN.txt"));
				//new FileReader ("/Users/alex/Downloads/questions/APenguinJumpedOverTheMoonIN.txt"));
		
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
	public static boolean canWeSucceed(int circleX, int circleY, int r,
									   int x, int y, int w, int h) {
		return containsVertical(circleX, circleY, r, x, y - h, h) ||
				containsVertical(circleX, circleY, r, x + w, y - h, h) ||
				containsHorizontal(circleX, circleY, r, x, y - h, w) ||
				containsHorizontal(circleX, circleY, r, x, y, w) ||
				centerInside(circleX, circleY, r, x, y, w, h);
	}
	
	public static boolean containsVertical(int circleX, int circleY, int r, int x, int y, int h) {
		if (new Point(x, y).insideCircle(new Point(circleX, circleY), r)) {
			return true;
		} else if (new Point(x, y + h).insideCircle(new Point(circleX, circleY), r)) {
			return true;
		}
		if (x < circleX - r) {
			return false;
		} else if (x > circleX + r) {
			return false;
		}
		return y <= r && y + h >= r;
	}
	
	public static boolean containsHorizontal(int circleX, int circleY, int r, int x, int y, int w) {
		if (new Point(x, y).insideCircle(new Point(circleX, circleY), r)) {
			return true;
		} else if (new Point(x + w, y).insideCircle(new Point(circleX, circleY), r)) {
			return true;
		}
		if (y < circleY - r) {
			return false;
		} else if (y > circleY + r) {
			return false;
		}
		return x <= r && x + w >= r;
	}
	
	public static boolean centerInside(int circleX, int circleY, int r,
									   int x, int y, int w, int h) {
		if (circleX <= x || circleY <= y) {
			return false;
		}
		if (circleX >= x + w || circleY >= y + h) {
			return false;
		}
		return true;
	}
}
