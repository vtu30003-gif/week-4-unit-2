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
