import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Extract the period (AM or PM)
        String period = s.substring(s.length() - 2);
        
        // Extract the hour integer value
        int hour = Integer.parseInt(s.substring(0, 2));
        
        // Extract minutes and seconds (without AM/PM)
        String timeWithoutPeriod = s.substring(2, s.length() - 2);
        
        if (period.equals("AM")) {
            if (hour == 12) {
                hour = 0; // Midnight case: 12AM becomes 00
            }
        } else { // PM case
            if (hour != 12) {
                hour += 12; // PM case except 12PM: add 12 hours
            }
        }
        
        // Format hour as 2 digits with leading zero if needed
        return String.format("%02d%s", hour, timeWithoutPeriod);
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
