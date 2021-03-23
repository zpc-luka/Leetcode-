import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(int key: map.keySet()) {
            int count = map.get(key);
            if(bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(key);
        }

        for(int i = bucket.length - 1; k > 0 & i >0; i--) {
            if(bucket[i] == null) continue;
            for(Integer num: bucket[i]) {
                res[k -1] = num;
                k--;
            }

        }

        return res;
    }
}
