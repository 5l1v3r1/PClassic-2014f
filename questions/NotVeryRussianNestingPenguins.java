import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class NotVeryRussianNestingPenguins {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new FileReader 
				      ("NotVeryRussianNestingPenguinsIN.txt"));
		
		while (br.ready()) {
			String line1 = br.readLine();
			String line2 = br.readLine();
			StringTokenizer st = new StringTokenizer(line1);
			
			ArrayList<Double> nest_list = new ArrayList<Double>();
			ArrayList<Double> hour_list = new ArrayList<Double>();
			
			while (st.hasMoreTokens()) {
				nest_list.add(Double.parseDouble(st.nextToken()));
			}
			st = new StringTokenizer(line2);
			while (st.hasMoreTokens()) {
				hour_list.add(Double.parseDouble(st.nextToken()));
			}
			
			double[] nests = new double[nest_list.size()];
			double[] hours = new double[hour_list.size()];
			for (int i = 0; i < nests.length; i++) {
				nests[i] = nest_list.get(i);
				hours[i] = hour_list.get(i);
			}
			System.out.println(Math.round(10000.0*buildingTime(nests, hours))/10000.0);
		}
		
		
		br.close ();
	}

	private static double buildingTime(double[] nests, double[] hours) {
                //Fill in this stub
        }
}
