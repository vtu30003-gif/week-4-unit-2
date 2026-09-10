import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Extract AM/PM indicator
        String modifier = s.substring(s.length() - 2);
        
        // Extract hour, minute, second components
        int hour = Integer.parseInt(s.substring(0, 2));
        String rest = s.substring(2, s.length() - 2);
        
        // Adjust hour based on AM/PM rules
        if (modifier.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else { // PM
            if (hour != 12) {
                hour += 12;
            }
        }
        
        // Format output as 2-digit hour followed by remaining time string
        return String.format("%02d%s", hour, rest);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
