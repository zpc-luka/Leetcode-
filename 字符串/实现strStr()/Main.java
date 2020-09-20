class Solution{
    public static void main(String[] args){
        String str = "abababca";
        Solution s = new Solution();
        int[] pmt = new int[str.length()];

        pmt = s.calculateMaxMatchLengths(str);
        for(int i=0;i<str.length();i++){
            System.out.println(pmt[i]);
        }

    }
    
    public int strStr(String haystack, String needle){
        int hay_len = haystack.length();
        int need_len = needle.length();

        if(hay_len < need_len) return -1;

        for(int i=0; i<hay_len-need_len+1; i++){
            if(haystack.substring(i, i+need_len).equals(needle)){
                return i;
            }
        }

        return -1;

        
    }

    // 构造模式串 pattern 的最大匹配数表
    int[] calculateMaxMatchLengths(String pattern) {
        int[] maxMatchLengths = new int[pattern.length()];
        int maxLength = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (maxLength > 0 && pattern.charAt(maxLength) != pattern.charAt(i)) {
                maxLength = maxMatchLengths[maxLength - 1]; // ①
            }
            if (pattern.charAt(maxLength) == pattern.charAt(i)) {
                maxLength++; // ②
            }
            maxMatchLengths[i] = maxLength;
        }
        return maxMatchLengths;
    }
}

