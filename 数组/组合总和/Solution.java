import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 组合
 * 可以重复利用元素
 */
class Solution{
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);
        backtrack(candidates, target, 0,0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int sum, int start){
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        if(sum > target)
            return;
        for(int i=start;i<candidates.length; i++){
            sum = sum + candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, target, sum, i);         // 这里从i开始
            sum = sum - candidates[i];
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> res = s.combinationSum2(new int[]{2,3,6,7}, 7);
        System.out.println(res);
    }
}