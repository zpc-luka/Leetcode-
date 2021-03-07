import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> path = new ArrayList<>();
    private List<List<String>> res = new ArrayList<>();
    
    public List<List<String>> partition(String s){
        if(s.length() == 0){
            return res;
        }
        int len = s.length();
        char[] charArray = s.toCharArray();

        // 预处理
        // 状态：dp[i][j] 表示 s[i][j] 是否是回文
        boolean[][] dp = new boolean[len][len];
        // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
        for (int right = 0; right < len; right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (charArray[left] == charArray[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        backtrack(charArray, 0, s.length(), dp);
        return res;
    }

    public void backtrack(char[] charArray, int index, int len, boolean[][] dp) {
        if(len == index){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < len; i++){
            if(dp[index][i]) {
                path.add(new String(charArray, index, i + 1 - index));
                backtrack(charArray, i + 1, len, dp);
                path.remove(path.size() - 1);
            }
        }
    }
}
