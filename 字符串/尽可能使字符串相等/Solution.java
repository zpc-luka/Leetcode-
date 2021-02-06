class Solution {
    public int equalSubstring(String s, String t, int maxCost){
        int n = s.length();

        int start = 0;
        int end = 0;

        int res = 0;
        int sum = 0;

        while(end < n){
            sum += Math.abs(s.charAt(end) - t.charAt(end));

            while(sum > maxCost){
                sum -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
 
            res = Math.max(res, end - start);
            end++;
        }
        
        return res;
    }
}


