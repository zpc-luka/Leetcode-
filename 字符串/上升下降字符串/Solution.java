class Solution{
    /**
     * 上升下降字符串
     * 桶排序
     */
    public String sortString(String s){
        StringBuilder res = new StringBuilder();
        char[] map = new char[26];
        for(int i=0; i<s.length();i++){
            map[s.charAt(i) - 'a']++;        // 记录每个字符出现的次数
        }
        while(res.length() < s.length()){          
            for(int i=0; i< 26; i++){             // 升序
                if(map[i] != 0){
                    res.append((char)('a'+i));
                    map[i]--;
                }
            }

            for(int i=25; i>=0; i--){            // 降序
                if(map[i] != 0){
                    res.append((char)('a'+i));
                    map[i]--;
                }
            }
        }
        return res.toString();
    }
}