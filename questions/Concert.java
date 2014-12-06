import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Concert {
    // Before submitting, make sure the main method hasn't been changed!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader
            ("ConcertIN.txt"));

        while (br.ready()) {
            String base = br.readLine();
            String height = br.readLine();
            String[] pillars = br.readLine().split(" ");
            double[] pillarDoubles = new double[pillars.length];
            for (int i = 0; i < pillars.length; i++) {
                pillarDoubles[i] = Double.parseDouble(pillars[i]);
            }

            System.out.println(computeSeatingCapacity(
                Double.parseDouble(base),
                Double.parseDouble(height),
                pillarDoubles
            ));
        }
    }

    // Fill out the body of this method
    public static int computeSeatingCapacity(double base, double height, double[] pillars) {
        return 0;
    }
}
