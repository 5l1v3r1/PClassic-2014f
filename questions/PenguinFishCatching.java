import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PenguinFishCatching {
  
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("PenguinFishCatchingIN.txt"));

    while (br.ready()) {
      String[] data = br.readLine().split(" ");
      long startingPosition = Long.parseLong(data[0]);
      long waddlingSpeed = Long.parseLong(data[1]);

      int nFish = Integer.parseInt(br.readLine());
      long[] landingTimes = new long[nFish];
      long[] landingPositions = new long[nFish];

      data = br.readLine().split(" ");
      for (int i = 0; i < nFish; i++) {
        landingTimes[i] = Long.parseLong(data[i]);
      }
      data = br.readLine().split(" ");
      for (int i = 0; i < nFish; i++) {
        landingPositions[i] = Long.parseLong(data[i]);
      }
      System.out.println(maxFishCaught(startingPosition, waddlingSpeed, landingTimes, landingPositions));
    }
    br.close();
  }

  // Fill out the body of this method
  public static long maxFishCaught(long startingPosition, long waddlingSpeed, long[] landingTimes, long[] landingPositions) {
  }
}
