import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum (int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefix_sum = 0, res = 0;

        for(int i=0; i < nums.length; i++) {
            prefix_sum += nums[i];             // 计算前缀和

            if(map.containsKey(prefix_sum - k)) {
                res += map.get(prefix_sum -k);
            }

            map.put(prefix_sum, map.getOrDefault(prefix_sum, 0) + 1);
        }

        return res;
    }
}