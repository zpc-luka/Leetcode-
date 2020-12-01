import java.lang.Math;
// 完全平方数

// 使用动态规划
// https://leetcode-cn.com/problems/perfect-squares/solution/wan-quan-ping-fang-shu-by-leetcode/
class Solution{
    public int numSquares(int n){
        int[] dp = new int[n+1];                  // dp[n] 表示 数字n的完全平方数
        int max_index = (int) Math.sqrt(n) + 1;
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        int[] square_nums = new int[max_index];
        for(int i=0; i<max_index; i++){
            square_nums[i] = i * i;
        }

        for(int i=1; i<=n; i++){
            for(int s=1; s<max_index;s++){
                if(i < square_nums[s])
                    break;
                dp[i] = Math.min(dp[i], dp[i-square_nums[s]] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int a = s.numSquares(12);
        System.out.println(a);
    }
}