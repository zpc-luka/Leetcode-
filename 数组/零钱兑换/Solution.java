package 数组.零钱兑换;
import java.util.*;

/**
 * 超出内存限制
 */

public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        backTrack(coins, amount, coins.length-1, 0);
        if(res.size() == 0) return -1;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.size(); i++) {
            min = Math.min(min, res.get(i).size());            
        }

        return min;

    }

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private void backTrack(int[] coins, int amount, int start, int sum) {
        if(sum == amount) {
            res.add(new ArrayList<>(path));
        }

        for(int i = start; i >= 0; i--) {
            if(sum > amount) return;

            sum += coins[i];
            path.add(coins[i]);
            
            backTrack(coins, amount, start, sum);
            sum -= coins[i];
            path.remove(path.size()-1);
        }
    }
}
