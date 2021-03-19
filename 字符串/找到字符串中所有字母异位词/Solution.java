/**
 * 极其愚蠢的解法
 *  对每一个字符的遍历一遍
 *  感觉遍历了很多重复的东西
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] origin = new int [26];

        int len = p.length();
        for (int i = 0; i < len; i++) {
            char c = p.charAt(i);
            origin[c - 'a']++; 
        }

        int start = 0;

        while(start <= s.length() - len) {
            int[] window = new int[26];
            
            for(int i = 0; i < len; i++) {
                char c = s.charAt(i+start);
                window[c -'a']++;
            }

            if(Arrays.equals(origin, window)) {
                res.add(start);
            }

            start++;
        }
        return res;
    }
}