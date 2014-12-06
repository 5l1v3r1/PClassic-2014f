import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;

public class PenguinSums {
  
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("PenguinSumsIN.txt"));

    while (br.ready()) {
      String[] data = br.readLine().split(" ");
      long N = Long.parseLong(data[0]);
      long M = Long.parseLong(data[1]);
      System.out.println(calculate(N, M));
    }
    br.close();
  }

  public static long f(long p, int k) {
    if (p <= 1) return 1;
    long pw = 1;
    for (int i = 0; i < k; i++) pw *= p;
    return pw + (pw/p)*(p-1)*(long)k;
  }

  // Fill out the body of this method
  public static long calculate(long N, long M) {
    return 0;
  }
}
