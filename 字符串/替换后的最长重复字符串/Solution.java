class Solution {
    public int characterReplacement(String s, int k){
        int len = s.length();
        
        if(len < 2)
            return len;
        
        int res = 0;
        int left = 0;
        int right = 0;
        int[] freq = new int[26];

        int maxCount = 0;

        while(right < len){
            freq[s.charAt(right) - 'A']++;
            right++;

            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);

            if(right - left > maxCount + k){
                freq[s.charAt(left) - 'A'] --;
                left++;
            }
            res = Math.max(res, right - left);
        }

        return res;
    }
}
