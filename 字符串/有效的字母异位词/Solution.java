import java.util.HashMap;
import java.util.Map;

class Solution{
    public boolean isAnagram_1(String s, String t){
        // 使用了两个哈希表 ，感觉有点蠢， 而且 最后两个表的比较直接使用函数，也不知道咋回事
        Map<Character,Integer> map1 = new HashMap<Character,Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }

        for(int i=0; i< t.length();i++){
            char c = t.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }

        return map1.equals(map2);

    }

    public boolean isAnagram_2(strings s, String t){
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                return false;
            } else if (count > 1) {
                map.put(ch, count - 1);
            } else {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }
}