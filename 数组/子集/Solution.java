import java.util.ArrayList;
import java.util.List;

class Solution{
    /**
     * 子集
     * 选择回溯算法
     */
    
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums){
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int index){
        res.add(new ArrayList<>(path));
        for(int i=index; i<nums.length;i++){
            path.add(nums[i]);
            backtrack(nums, i+1);
            path.remove(path.size()-1);
        }
    }
}