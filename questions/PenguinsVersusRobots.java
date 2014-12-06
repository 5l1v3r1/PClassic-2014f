import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class Robot {
  long xPosition;
  long yPosition;
  long detectionRange;
  Robot(){}
}
public class PenguinsVersusRobots {
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("PenguinsVersusRobotsIN.txt"));

    while (br.ready()) {
      String[] data = br.readLine().split(" ");
      long valleyWidth = Long.parseLong(data[0]);
      long valleyHeight = Long.parseLong(data[1]);
      int nRobots = Integer.parseInt(br.readLine()); 
      Robot[] robots = new Robot[nRobots];
      for (int i = 0; i < nRobots; i++) {
        robots[i] = new Robot();
        data = br.readLine().split(" ");
        robots[i].xPosition = Long.parseLong(data[0]);
        robots[i].yPosition = Long.parseLong(data[1]);
        robots[i].detectionRange = Long.parseLong(data[2]);
      }

      System.out.println(minRobotsKilled(valleyWidth, valleyHeight, robots));
    }
    br.close();
  }

  // Fill out the body of this method
  public static long minRobotsKilled(long valleyWidth, long valleyHeight, Robot[] robots) {
    return 0;
  }
}
