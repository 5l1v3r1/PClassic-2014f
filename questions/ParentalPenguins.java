import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ParentalPenguins {
  
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("ParentalPenguinsIN.txt"));

    while (br.ready()) {
      String[] data = br.readLine().split(" ");
      int totalChicks = Integer.parseInt(br.readLine());
      int[] chicks = new int[data.length];
      for (int i = 0; i < chicks.length; i++) chicks[i] = Integer.parseInt(data[i]);
      System.out.println(missingChick(chicks, totalChicks));
    }
    br.close();
  }

  // Fill out the body of this method
  public static int missingChick(int[] chicks, int totalChicks) {
    return 0;
  }
}
