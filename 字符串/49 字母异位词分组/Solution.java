//383 赎金信
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
class Solution {
    /**
     * 创建一个哈希表
     * 哈希表的键值是每个字符串转换为字符数组的排序
     */
    public List<List<String>> groupAnagrams(String[] strs){
        if(strs.length == 0)
            return new ArrayList();
        
        HashMap<String,List> map = new HashMap<String,List>();
        for(String s: strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if(!map.containsKey(key))
                map.put(key,new ArrayList<String>());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());   //注意这种写法
    }
    
}


