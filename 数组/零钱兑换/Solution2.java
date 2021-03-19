import java.util.*;
/**
 * 超出时间限制
 * 
 * 但是 这 DFS 用的非常好
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null) return -1;
        Arrays.sort(coins);
        dfs(coins, amount, coins.length-1, 0);
        
        return min == Integer.MAX_VALUE ? -1 : min;

    }

    private int min = Integer.MAX_VALUE;


    private void dfs(int[] coins, int amount, int index, int count) {
        if(index < 0 || count + amount / coins[index] >= min) return;

        if(amount % coins[index] == 0) {
            min = Math.min(min, count + amount / coins[index]);
            return;
        }
        
        for(int k = amount / coins[index]; k >= 0 && k + count < min; k--) {
            dfs(coins, amount - k * coins[index], index - 1, count + k); 
        }
    }
}
