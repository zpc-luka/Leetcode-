package 数组.最长上升子序列;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        Arrays.fill(dp, 1);

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < i; j ++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for(int d: dp) {
            res = Math.max(res, d);
        }

        return res;
    }
}
