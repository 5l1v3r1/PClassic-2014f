import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PenguinIcebergHopping {
  
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("PenguinIcebergHoppingIN.txt"));

    while (br.ready()) {
      String[] data = br.readLine().split(" ");
      int nIcebergs = Integer.parseInt(data[0]);
      int nPenguins = Integer.parseInt(data[1]);
      long[] nextIceberg = new long[nIcebergs];
      long[] startingPositions = new long[nPenguins];
      long[] numHops = new long[nPenguins];
      data = br.readLine().split(" ");
      for (int i = 0; i < nIcebergs; i++) {
        nextIceberg[i] = Long.parseLong(data[i]);
      }
      data = br.readLine().split(" ");
      for (int i = 0; i < nPenguins; i++) {
        startingPositions[i] = Long.parseLong(data[i]);
      }
      data = br.readLine().split(" ");
      for (int i = 0; i < nPenguins; i++) {
        numHops[i] = Long.parseLong(data[i]);
      }

      System.out.println(Arrays.toString(endingPositions(nextIceberg, startingPositions, numHops)));
    }
    br.close();
  }

  // Fill out the body of this method
  public static long[] endingPositions(long[] nextIceberg, long[] startingPositions, long[] numHops) {
  }
}
