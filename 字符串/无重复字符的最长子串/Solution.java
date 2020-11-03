import java.util.HashSet;
import java.util.Set;

//两数相加
class Solution {
    public int lengthOfLongestSubString(String s) {
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();

        int rk = -1;
        int ans = 0;
        //使用双指针  这里的双指针是 i 和 rk
        for(int i=0; i<n; i++){
            // 这里是移动左指针， 并且在set去掉这个字符
            if(i != 0){
                occ.remove(s.charAt(i-1));
            }
            //从这个字符向后添加不重复的字符
            while(rk + 1 < n && !occ.contains(s.charAt(rk+1))){
                occ.add(s.charAt(rk+1));
                ++rk;
            }

            ans = Math.max(ans, rk - i + 1);
        }

        return ans;
    }
}


