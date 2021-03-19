import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {

        int[] s_count = new int[26];
        int[] p_count = new int[26];
        
        List<Integer> ans= new ArrayList<>();
        int left = 0, right = -1;

        if(s.length() < p.length()) {
            return ans;
        }
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            char cs = s.charAt(i);
            p_count[c - 'a']++;
            s_count[cs - 'a']++;
            right++;                    // 使窗口达到固定长度      
        }

        if(Arrays.equals(s_count, p_count)) {
            ans.add(left);
        }

        while(right < s.length() - 1) {
            s_count[s.charAt(left) - 'a']--;            // 将现在左指针指向的的字符去除
            left++;                        //左指针右移

            right++;
            s_count[s.charAt(right) - 'a']++;       // 有指针右移

            if(Arrays.equals(s_count, p_count)) {
                ans.add(left);
            }
        }

        return ans;
    }    
}
