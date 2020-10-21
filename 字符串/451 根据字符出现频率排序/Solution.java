//383 赎金信
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
class Solution {
    public String frequencySort(String s) {
        HashMap<Integer, String> map = new HashMap<>();      // 使用一个哈希表记录 键值 是每个字母出现的次数  值是这个字母按次数进行拼接

        int[] freq = new int[256];               //使用一个数组记录每个字符出现的次数，这里的256也可改为128. 因为ASCII值只有128位，注意这里的数组int类型
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                char ch = (char) i;           // char强制转换

                String str = map.get(freq[i]);
                // 字符出现次数相同, 进行拼接    *****!!!
                if (str != null) {
                    String strNew = str.concat(build(ch, freq[i]));
                    map.put(freq[i], strNew);
                }else {
                    map.put(freq[i], build(ch, freq[i]));
                }
            }
        }


        Integer[] keys = map.keySet().toArray(new Integer[]{});              // 这个写法。。。
        Arrays.sort(keys);
        StringBuilder sbl = new StringBuilder();
        for (int i = keys.length - 1; i >= 0; i--) {
            sbl.append(map.get(keys[i]));
        }

        return sbl.toString();

    }

    private String build(char ch, int times) {
        String string = Character.toString(ch);
        StringBuilder res = new StringBuilder(string);
        int t = 1;
        while (t < times) {
            res.append(string);
            t++;
        }

        return res.toString();
    }        
    
}


