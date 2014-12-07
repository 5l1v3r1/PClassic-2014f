import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class NestAndBreakfast {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new FileReader 
												("NestAndBreakfastIN.txt"));
				//("/Users/alex/Downloads/questions/NestAndBreakfastIN.txt"));
		
		while (br.ready()) {
			String line = br.readLine();
			
			String[] data = line.split(" ");
			int num = Integer.parseInt(data[0]);
			int[] reservations = new int[num];
			for (int i = 0; i < num; i++) {
				reservations[i] = Integer.parseInt(data[i+1]);
			}
			
			System.out.println(maxReservations(reservations));
		}
		
		
		br.close ();
	}

	private static long maxReservations(int[] reservations) {
		//Fill in this stub
		long[] heuristic = new long[reservations.length];
		Arrays.fill(heuristic, -1);
		for (int i = reservations.length; i >= 0; --i) {
			recursiveSum(reservations, heuristic, i);
		}
		return recursiveSum(reservations, heuristic, 0);
    }
	
	private static long recursiveSum(int[] reservations, long[] heuristic, int start) {
		long sum = 0;
		if (start >= reservations.length) {
			return 0;
		} else if (heuristic[start] >= 0) {
			return heuristic[start];
		}
		// start at every point
		for (int first = start; first < reservations.length && first < start + 4;
         ++first) {
			long potentialSum = (long)reservations[first];
			potentialSum += recursiveSum(reservations, heuristic, first + 2);
			if (potentialSum > sum) {
				sum = potentialSum;
			}
		}
		heuristic[start] = sum;
		return sum;
	}
}
