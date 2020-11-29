import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution{
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(0, candidates, target);
        return res;
    }
    
    private void backTrack(int begin, int[] candidates, int target){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=begin; i<candidates.length; i++){
            if(target - candidates[i] < 0){
                return;
            }

            if(i > begin && candidates[i] == candidates[i-1]){
                continue;
            }

            path.add(candidates[i]);
            backTrack(i+1, candidates, target - candidates[i]);
            path.remove(path.size()-1);
        }
    }
}