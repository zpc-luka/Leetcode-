import java.util.ArrayList;
import java.util.List;

class Solution{
    /**
     * 全排列
     * 经典回溯
     */
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();

        dfs(0,nums, used, path, res);
        return res;
    }

    private void dfs(int depth,int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res){
        if(depth == nums.length)
            res.add(new ArrayList<>(path));
        
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(depth+1, nums, used, path, res);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    } 
}