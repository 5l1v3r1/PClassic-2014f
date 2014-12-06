import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PenguinMathematics {
    // Before submitting, make sure the main method hasn't been changed!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader
            ("PenguinMathematicsIN.txt"));
        
        while (br.ready()) {
            String data = br.readLine();
            System.out.println(manipulateAbacus(data));
        }
    }

    // Fill out the body of this method
    public static String manipulateAbacus(String input) {
        return "";
    }
}
