/**
 *  动态规划
 */
public class Solution2 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];  // dp[i][j] 表示 从 （0,0）到（i,j）的最短路径和
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0]. length; j++){
                if(i ==0 && j==0) {
                    dp[0][0] = grid[0][0];
                }else if(j == 0 && i > 0){
                    dp[i][0] = dp[i-1][0] + grid[i][0];
                }else if(i == 0 && j > 0){
                    dp[0][j] = dp[0][j-1] + grid[0][j];
                }else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
                }
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }    
}
