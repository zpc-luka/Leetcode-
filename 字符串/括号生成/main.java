import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution{
    /**
     *  Dynmaic Programming
     *  https://leetcode-cn.com/problems/generate-parentheses/solution/zui-jian-dan-yi-dong-de-dong-tai-gui-hua-bu-lun-da/
     */
    public List<String> generateParenthesis(int n) {
        List<List<String>> result = new LinkedList<>();
        if(n == 0)
            return new ArrayList<String>();
        LinkedList<String> list0 = new LinkedList<>();
        list0.add("");
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("()");
        result.add(list0);
        result.add(list1);

        for(int i=2; i<=n; i++){
            List<String> temp = new LinkedList<>();
            for(int j=0; j<i; j++){
                List<String> str1 = result.get(j);
                List<String> str2 = result.get(i-1-j);
                for(String s1: str1){
                    for(String s2:str2){
                        String s = "(" + s1 + ")" + s2;
                        temp.add(s);
                    }
                }
            }
            result.add(temp);
        }

        return result.get(n);
    }

    /**
     * DFS
     * https://leetcode-cn.com/problems/generate-parentheses/solution/jian-dan-dfsmiao-dong-by-sweetiee/
     */
    public List<String> generateParenthesis_2(int n){
        List<String> res = new ArrayList<>();
        String path = "";

        if(n == 0){
            return res;
        }
        dfs(n, n, res, path);
        return res;
    }

    private void dfs(int left, int right, List<String> res, String path){
        if(left == 0 && right ==0)
            res.add(path.toString());
        if(left > 0)
            dfs(left-1, right, res, path+"(");
        if(left < right)
            dfs(left, right-1, res, path+")");
    }
}

