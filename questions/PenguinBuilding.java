import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class PenguinBuilding {

 
 //Make sure before you submit that the main method hasn't been changed!
 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader (new FileReader ("PenguinBuildingIN.txt"));
  
  while (br.ready()) {
   String[] data = br.readLine().split(" ");
   int a = Integer.parseInt(data[0]);
   int b = Integer.parseInt(data[1]);
   int c = Integer.parseInt(data[2]);
   System.out.println(howdoitriangle(a, b, c));
  }
  br.close();
 }
 
 //Fill out the body of this method
 public static boolean howdoitriangle(int a, int b, int c) {
  
  
 }

}
