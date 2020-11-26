import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 组合总和
 * 可以重复利用元素
 */
class Solution{
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);                // 必须排序
        backtrack(candidates, target, 0,0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int sum, int start){
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        //if(sum > target)                                      //如果不剪枝的这里是需要的
            //return;
        for(int i=start;i<candidates.length; i++){
            if(sum + candidates[i] > target)                  // 这里想了很长时间，这里用来剪枝，就是数的同一层没必要再执行了
                return;
            sum = sum + candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, target, sum, i);         // 这里从i开始
            sum = sum - candidates[i];
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> res = s.combinationSum2(new int[]{2,1,3,4}, 7);
        System.out.println(res);
    }
}