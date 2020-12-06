import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//全排列2
class Solution{
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);
        backTrack(nums, used, res, path);

        return res;
    }
    
    private void backTrack(int[] nums, boolean[] used,List<List<Integer>> res, List<Integer> path){
        if(path.size() ==  nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0; i<nums.length; i++){
            // used[i - 1] == true，说明同一树支nums[i - 1]使用过
            // used[i - 1] == false，说明同一树层nums[i - 1]使用过
            // 如果同一树层nums[i - 1]使用过则直接跳过
            
            if(i>0 && nums[i]==nums[i-1] && used[i-1] == false){ 
                continue;
            }
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                backTrack(nums, used, res, path);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,1,2};

        List<List<Integer>> res = s.permuteUnique(nums);

        for(List<Integer> i: res){
            System.out.println(i.toString());
        }

    }
}