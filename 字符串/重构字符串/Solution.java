//重构字符串
class Solution{
    public String reorganizeString(String s){
        char[] chs = s.toCharArray();
        int length = s.length();
        int[] count = new int[26];
        int letter = 0;
        int max = 0;
        int threshold = (length + 1) >> 1;
        // 统计字母出现次数同时计算出现次数最多的字母。
        for(int i=0; i<length;i++){
            count[chs[i]-'a']++;
            if(count[chs[i]-'a'] > max){
                letter = chs[i] - 'a';             //letter为出现次数最大的字母相对""a"的偏移量
                max = count[chs[i] - 'a'];
            }        
            if(max > threshold){
                return "";
            }
        }
        int index = 0;
        char[] res = new char[length];

        while(count[letter] > 0){                 //将出现次数最多的字符放在偶数位
            res[index] = (char)(letter + 'a');
            index += 2;
            count[letter]--;
        }

        
        for(int i=0; i<count.length; i++){
            while(count[i] > 0){              // 这里最巧妙 喵喵猫
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char)(i + 'a');
                index += 2;
                count[i]--;
            }
        }
        return new String(res);
    }
    public static void main(String[] args) {
        String s = "aabbbccdef";
        Solution a = new Solution();
        System.out.println(a.reorganizeString(s));
    }
}