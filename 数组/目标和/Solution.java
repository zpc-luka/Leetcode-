class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0, 0);
        return ans;
    } 
    
    private int ans = 0;
    private int[] signs = {1,0};

    private void dfs(int[] nums, int S, int depth, int sum) {
        if(depth == nums.length) {
            if(sum == S) {
                ans++;
            }
            return;
        } 

        for (int sign: signs) {
            if(sign == 1) {
                sum += nums[depth];
            } else{
                sum -=nums[depth];
            }

            dfs(nums, S, depth+1, sum);

            if(sign == 1) {
                sum -= nums[depth];
            } else {
                sum += nums[depth];
            }
        }

    }
}
