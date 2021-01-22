import java.util.ArrayList;
import java.util.List;

class  Solution{
    public List<String> summaryRanges(int[] nums){
        int len = nums.length;
        int i = 0;
        List<String> res = new ArrayList<>();

        if(nums == null || len < 1){
            return res;
        }
        while(i < len){
            int low = i;
            i ++;
            while(i < len && nums[i] - nums[i-1] == 1){
                i++;
            }

            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(low));
            if(low < high){
                temp.append("->");
                temp.append(Integer.toString(high));
            }
            res.add(temp.toString());
        }
    }
}