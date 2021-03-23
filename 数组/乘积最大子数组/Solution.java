class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) return nums[0];

        int ans = 0;

        int[] maxDP = new int[nums.length];    // 这类题的动态规划都定义为 以nums[i]为结尾的。。。。
        int[] minDP = new int[nums.length];

        maxDP[0] = nums[0];
        minDP[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] >= 0) {
                maxDP[i] = Math.max(maxDP[i - 1] * nums[i], nums[i]);
                minDP[i] = Math.min(minDP[i - 1] * nums[i], nums[i]);
            } else {
                maxDP[i] = Math.max(minDP[i - 1] * nums[i], nums[i]);
                minDP[i] = Math.min(maxDP[i - 1] * nums[i], nums[i]);
            }
        }

        for(int i: maxDP) {
            ans = Math.max(ans, i);
        }

        return ans;
    }    
}
