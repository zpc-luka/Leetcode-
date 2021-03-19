package 字符串.回文子串;

public class Solution2 {
    public int countSubstrings(String s) {
        int ans = 0;

        for(int center = 0; center < 2 * s.length() - 1; center++) {
            int left = center / 2;
            int right = center % 2 + left;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                ans++;
            }
        }

        return ans;
    }
}
