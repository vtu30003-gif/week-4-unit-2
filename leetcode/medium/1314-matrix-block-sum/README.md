# Matrix Block Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a `m x n` matrix `mat` and an integer `k`, return  *a matrix*  `answer`  *where each*  `answer[i][j]`  *is the sum of all elements*  `mat[r][c]`  *for* :

- i - k <= r <= i + k,
- j - k <= c <= j + k, and
- (r, c) is a valid position in the matrix.

 

 **Example 1:** 

```
Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[12,21,16],[27,45,33],[24,39,28]]

```

 **Example 2:** 

```
Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
Output: [[45,45,45],[45,45,45],[45,45,45]]

```

 

 **Constraints:** 

- m == mat.length
- n == mat[i].length
- 1 <= m, n, k <= 100
- 1 <= mat[i][j] <= 100

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 96.20%)  
**Memory:** 46.8 MB (beats 22.64%)  
**Submitted:** 2026-09-10T06:51:22.572Z  

```java
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // 1. Build 2D Prefix Sum matrix
        int[][] pref = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pref[i + 1][j + 1] = mat[i][j] 
                                  + pref[i][j + 1] 
                                  + pref[i + 1][j] 
                                  - pref[i][j];
            }
        }
        
        // 2. Calculate matrix block sums
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);
                
                ans[i][j] = pref[r2 + 1][c2 + 1] 
                          - pref[r1][c2 + 1] 
                          - pref[r2 + 1][c1] 
                          + pref[r1][c1];
            }
        }
        
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/matrix-block-sum/)