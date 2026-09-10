# Java Lambda Expressions

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

This Java 8 challenge tests your knowledge of [Lambda expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)!

Write the following methods that *return a lambda expression* performing a specified action:

1. PerformOperation isOdd(): The lambda expression must return $true$ if a number is odd or $false$ if it is even.
2. PerformOperation isPrime(): The lambda expression must return $true$ if a number is prime or $false$ if it is composite.
3. PerformOperation isPalindrome(): The lambda expression must return $true$ if a number is a palindrome or $false$ if it is not.

**Input Format**

Input is handled for you by the locked stub code in your editor.

**Constraints**

 

**Output Format**

The locked stub code in your editor will print $T$ lines of output.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-10T06:21:48.499Z  

```java
import java.io.*;
import java.util.*;

@FunctionalInterface
interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    // Checks if the number is odd
    public PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    // Checks if the number is prime
    public PerformOperation isPrime() {
        return n -> {
            if (n < 2) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
    }

    // Checks if the number is a palindrome
    public PerformOperation isPalindrome() {
        return n -> {
            String str = Integer.toString(n);
            String reversed = new StringBuilder(str).reverse().toString();
            return str.equals(reversed);
        };
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;

        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(ans);
        }
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-lambda-expressions/problem)