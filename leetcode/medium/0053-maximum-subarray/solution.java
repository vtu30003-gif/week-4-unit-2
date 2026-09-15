class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to add nums[i] to currentSum or start new from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Track the maximum sum encountered
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}