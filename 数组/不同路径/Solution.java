import java.util.Currency;
// 不同路径
class Solution{
    public int count = 0;

    public int uniquePaths(int m, int n){
        dfs(m, n, 0, 0);
        return count;
    }

    public void dfs(int m, int n, int cur_x, int cur_y){
        if(m-1 == cur_x && n-1== cur_y){
            count++;
            return;
        }

        for(int i=0; i<2; i++){     // 0:right, 1:down
            if(cur_x < m && i == 0){
                cur_x++;
            }else if(cur_y < n && i == 1){
                cur_y++;
            }else{
                return;
            }
            dfs(m, n, cur_x, cur_y);
            if(i == 0){
                cur_x--;
            }else if(i == 1){
                cur_y--;
            }  
        }
    }         //此方法超时

    public int uniquePaths2(int m, int n){
        int[][] dp = new int[m][n];           //dp[i][j]　表示到ｉ和ｊ有几种走法
        for(int i=0; i<n; i++) dp[0][i] = 1;
        for(int i=0; i<m; i++) dp[i][0] = 1;

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];

    }
}