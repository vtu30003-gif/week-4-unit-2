# Time Conversion

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a time in [$12$-hour AM/PM format](https://en.wikipedia.org/wiki/12-hour_clock), convert it to military (24-hour) time.  

Note: 
- 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.  
- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.  

**Example**  

- $\text{s = '12:01:00PM'}$   

  Return '12:01:00'.

- $\text{s = '12:01:00AM'}$   

  Return '00:01:00'.

**Function Description**  

Complete the $timeConversion$ function with the following parameter(s):

- $string\ s$: a time in $12$ hour format  

**Returns**

- $string$: the time in $24$ hour format

**Input Format**

A single string $s$ that represents a time in $12$-hour clock format (i.e.: $\text{hh:mm:ssAM}$ or $\text{hh:mm:ssPM}$).

**Constraints**

- All input times are valid

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-10T06:32:37.341Z  

```java
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

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/time-conversion/problem)