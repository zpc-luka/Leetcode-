class Solution {
    public int findTargetSumWays(int[] nums, int S) { 
        int len = nums.length;
        int sum = 0;

        for(int num: nums) sum += num;
        if(sum < S) return 0;

        int dp[][] = new int[len][2 * sum + 1];

        if(nums[0] == 0) {
            dp[0][sum] = 2;      // dp[0][sum] 指的是用nums[0](0)得到0的方法数量 +0 -0 有两种
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]]= 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                int l = (j - nums[i]) >= 0 ? j - nums[i] : 0;   // 防止越界：如果条件成立，意味着选+号没有可行方案，故+0即可
                int r = (j + nums[i]) < 2 * sum + 1 ? j + nums[i] : 0;

                dp[i][j] = dp[i -1][l] + dp[i-1][r];
            }
        }

        return dp[len - 1][sum + S];
    }
}
