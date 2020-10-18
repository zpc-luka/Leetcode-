// leetcode 389

import java.util.HashMap;

import java.util.HashMap;
class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch, 0)+1);      // 这个函数要记住
        }
        for(char ch: t.toCharArray()){
            map.put(ch,map.getOrDefault(ch, 0)-1);
            if(map.get(ch) < 0){
                return ch;
            }
        }
        return t.charAt(t.length()-1);      // 如果上述循环结束，那么不同的一定在最后
    }

    public char findTheDifference2(String s, String t){
        char ans = 0;
        for(int i=0;i<s.length();i++){
            ans ^= s.charAt(i);
            ans ^= t.charAt(i);
        }
        return ans^=t.charAt(t.length()-1);
    }// 看到比较的可以想到 异或 ！！！！
}


