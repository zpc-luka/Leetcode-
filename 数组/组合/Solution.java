import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k){
        backtrack(1, n, k);
        return res;
    }

    private void backtrack(int start, int n, int k){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=start; i<=n; i++){
            path.add(i);
            backtrack(i+1, n, k);
            path.remove(path.size()-1);
        }
    }  
}