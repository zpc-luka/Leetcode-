import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Solution {
    private Map<Character, String> map = new HashMap<>(){
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9', "wxyz");
        }
    }; // 映射

    private StringBuilder sb = new StringBuilder();  // 路径

    private List<String> res = new ArrayList<>();   // 结果

    /**
     * 使用回溯算法，其实感觉像是深度优先算法，构建决策树，使用路径保存决策
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 || digits == null)
            return res;
        backtrack(0, digits);
        return res;
    }

    public void backtrack(int index, String digits){
        // 这边的递归看了还是蛮长时间的，这个递归函数作用就是在digits的第index处的字符构建决策树并
        // 向下回溯
        if(index == digits.length()){
            res.add(sb.toString());                     // 如果路径里保存的字符的长度与digits的长度相同就保存词路径
        }else{
            String s = map.get(digits.charAt(index));
            for(int i=0;i<s.length();i++){
                sb.append(s.charAt(i));
                backtrack(index+1, digits);
                sb.deleteCharAt(index);                 //去掉最后一个结果向上回溯
            }
        }
    }
}