# Move Zeroes

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

 **Note**  that you must do this in-place without making a copy of the array.

 

 **Example 1:** 

```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

```

 **Example 2:** 

```
Input: nums = [0]
Output: [0]

```

 

 **Constraints:** 

- 1 <= nums.length <= 104
- -231 <= nums[i] <= 231 - 1

 

 **Follow up:**  Could you minimize the total number of operations done?

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 91.79%)  
**Memory:** 47.7 MB (beats 75.94%)  
**Submitted:** 2026-09-10T06:49:11.022Z  

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap non-zero element with the element at insertPos
                int temp = nums[insertPos];
                nums[insertPos] = nums[i];
                nums[i] = temp;
                
                insertPos++;
            }
        }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/move-zeroes/)