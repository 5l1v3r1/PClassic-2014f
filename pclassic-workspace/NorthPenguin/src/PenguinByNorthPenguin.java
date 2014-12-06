import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class PenguinByNorthPenguin {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (
				new FileReader ("PenguinByNorthPenguinIN.txt"));
				//new FileReader ("/Users/alex/Downloads/questions/PenguinByNorthPenguinIN.txt"));
		
		while (br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double dir = Double.parseDouble(st.nextToken());
			double tolerance = Double.parseDouble(st.nextToken());
			System.out.println(getDirection(dir, tolerance));
		}
		
		br.close();
	}

    public static String getDirection(double dir, double tolerance) {
    	dir = modulusAngle(dir);
    	if (dir <= tolerance || Math.abs(dir - 360.0) <= tolerance) {
    		return "N";
    	} else if (Math.abs(dir - 90.0) <= tolerance) {
    		return "E";
    	} else if (Math.abs(dir - 180.0) <= tolerance) {
    		return "S";
    	} else if (Math.abs(dir - 270.0) <= tolerance) {
    		return "W";
    	}
    	StringBuilder built = new StringBuilder();
    	double gotten = 0.0;
    	if (dir <= 90.0) {
    		// Top right, NE
    		gotten = 90.0;
    		built.append("E");
    		int iter = 0;
    		while (Math.abs(gotten - dir) > Math.abs(tolerance)) {
    			++iter;
    			if (gotten < dir) {
    				built.append("E");
    				gotten += 90.0 / (double)Math.pow(2.0, iter);
    			} else {
    				built.append("N");
    				gotten -= 90.0 / (double)Math.pow(2.0, iter);
    			}
    		}
    	} else if (dir >= 270.0) {
    		// Top left NW
    		gotten = 270.0;
    		built.append("W");
    		int iter = 0;
    		while (Math.abs(gotten - dir) > Math.abs(tolerance)) {
    			++iter;
    			if (gotten < dir) {
    				built.append("N");
    				gotten += 90.0 / (double)Math.pow(2.0, iter);
    			} else {
    				built.append("W");
    				gotten -= 90.0 / (double)Math.pow(2.0, iter);
    			}
    		}
    	} else if (dir >= 180.0) {
    		// Bottom left hemisphere WS
    		gotten = 270.0;
    		built.append("W");
    		int iter = 0;
    		while (Math.abs(gotten - dir) > Math.abs(tolerance)) {
    			++iter;
    			if (gotten < dir) {
    				built.append("W");
    				gotten += 90.0 / (double)Math.pow(2.0, iter);
    			} else {
    				built.append("S");
    				gotten -= 90.0 / (double)Math.pow(2.0, iter);
    			}
    		}
    	} else {
    		// Bottom right hemisphere
    		gotten = 90.0;
    		built.append("E");
    		int iter = 0;
    		while (Math.abs(gotten - dir) > Math.abs(tolerance)) {
    			++iter;
    			if (gotten < dir) {
    				built.append("S");
    				gotten += 90.0 / (double)Math.pow(2.0, iter);
    			} else {
    				built.append("E");
    				gotten -= 90.0 / (double)Math.pow(2.0, iter);
    			}
    		}
    		// Bottom right SE
    	}
    	return built.reverse().toString();
    }
    
    public static double modulusAngle(double dir) { 
    	while (dir < 0.0) {
    		dir += 360.0;
    	}
    	while (dir >= 360.0) {
    		dir -= 360.0;
    	}
    	return dir;
    }
}
