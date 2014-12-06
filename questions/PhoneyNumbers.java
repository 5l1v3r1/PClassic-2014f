import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneyNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (
				new FileReader ("PhoneyNumbersIN.txt"));
		
		while (br.ready()) {
			System.out.println(getPhoneNumber(br.readLine()));
		}
		
		br.close();
	}
	public static String getPhoneNumber(String text) {
                //Fill in this stub
        }
}
