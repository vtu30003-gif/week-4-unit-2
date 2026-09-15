# Matrix Layer Rotation

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a 2D  matrix of dimension $m \times n$ and a positive integer $r$. You have to rotate the matrix $r$ times and print the resultant matrix. Rotation should be in anti-clockwise direction.  

Rotation of a $4x5$ matrix is represented by the following figure. Note that in one rotation, you have to shift elements by one step only.

![matrix-rotation](https://hr-challenge-images.s3.amazonaws.com/2517/matrix-rotation.png)

It is guaranteed that the minimum of _m_ and _n_ will be even.  

As an example rotate the Start matrix by 2:

<pre>
	Start		  First 		  Second
	 1 2 3 4	   2  3  4  5      3  4  5  6
	12 1 2 5  ->   1  2  3  6 ->   2  3  4  7
	11 4 3 6      12  1  4  7      1  2  1  8
	10 9 8 7      11 10  9  8     12 11 10  9
</pre>

**Function Description**  

Complete the *matrixRotation* function in the editor below.  

matrixRotation has the following parameter(s):  

- *int matrix[m][n]:* a 2D array of integers  
- *int r:* the rotation factor   

**Prints**   
It should print the resultant 2D integer array and return nothing.  Print each row on a separate line as space-separated integers.  

**Input Format**

The first line contains three space separated integers, $m$, $n$, and $r$, the number of rows and columns in $matrix$, and the required rotation.    
The next $m$ lines contain $n$ space-separated integers representing the elements of a row of $matrix$.  

**Constraints**

$2 \le \text{m, n} \le 300$  
$1 \le r \le 10^9$  
$min(m, n) \% 2 = 0$  
$1 \le matrix[i][j] \le 10^8 \text{ where }i \in [1 \dots m] \text{ and }j \in [1 \dots n]$
 

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-15T03:32:58.044Z  

```java
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */
    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        
        // Convert List to 2D array for faster indexing
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = matrix.get(i).get(j);
            }
        }

        int numLayers = Math.min(m, n) / 2;
        int[][] res = new int[m][n];

        for (int layer = 0; layer < numLayers; layer++) {
            List<Integer> elements = new ArrayList<>();

            // 1. Traverse Top Row (Left to Right)
            for (int col = layer; col < n - layer; col++) {
                elements.add(grid[layer][col]);
            }
            // 2. Traverse Right Column (Top + 1 to Bottom)
            for (int row = layer + 1; row < m - layer; row++) {
                elements.add(grid[row][n - 1 - layer]);
            }
            // 3. Traverse Bottom Row (Right - 1 to Left)
            for (int col = n - 2 - layer; col >= layer; col--) {
                elements.add(grid[m - 1 - layer][col]);
            }
            // 4. Traverse Left Column (Bottom - 1 to Top + 1)
            for (int row = m - 2 - layer; row > layer; row--) {
                elements.add(grid[row][layer]);
            }

            int len = elements.size();
            int rot = r % len; // Anti-clockwise shift offset

            int idx = rot;

            // Re-populate layer using rotated offset
            // 1. Top Row
            for (int col = layer; col < n - layer; col++) {
                res[layer][col] = elements.get(idx);
                idx = (idx + 1) % len;
            }
            // 2. Right Column
            for (int row = layer + 1; row < m - layer; row++) {
                res[row][n - 1 - layer] = elements.get(idx);
                idx = (idx + 1) % len;
            }
            // 3. Bottom Row
            for (int col = n - 2 - layer; col >= layer; col--) {
                res[m - 1 - layer][col] = elements.get(idx);
                idx = (idx + 1) % len;
            }
            // 4. Left Column
            for (int row = m - 2 - layer; row > layer; row--) {
                res[row][layer] = elements.get(idx);
                idx = (idx + 1) % len;
            }
        }

        // Print final rotated matrix
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(res[i][j]).append(j == n - 1 ? "" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/matrix-rotation-algo/problem)