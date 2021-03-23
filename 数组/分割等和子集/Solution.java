class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, maxSum = 0;
        if(nums.length < 2) return false;
        for(int num: nums) {
            sum += num;
            maxSum = Math.max(maxSum, num);
        }

        if(sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        if(maxSum > target) {
            return false;
        }

        //该数组表示 dp[i][j] 选取 nums 前 i 个数组 是否有 和为 j 的子集
        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;

        for(int i = 1; i < nums.length; i++) {
            for (int j = 0; j < target + 1; j++) {
                if(j >= nums[i]) {
                    dp[i][j] = dp[i -1][j] | dp[i - 1][j - nums[i]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[nums.length - 1][target];
    }    
}
