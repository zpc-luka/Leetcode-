//383 赎金信
import java.util.HashMap;

import java.util.HashMap;
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();

        for(char ch: magazine.toCharArray()){
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        for(char ch: ransomNote.toCharArray()){
            if(!map.containsKey(ch) || map.get(ch) == 0){
                return false;
            }else{
                map.put(ch,map.get(ch)-1);
            }
        }
        return true;
    }

}


