import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> path = new ArrayList<>();
    public List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        char[] charArray = s.toCharArray();
        backtrack(charArray, 0, s.length());
        return res;
    }

    public void backtrack(char[] charArray, int index, int len) {
        if(len == index){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < len; i++){
            if(!check(charArray, index, i)){
                continue;
            }

            path.add(new String(charArray, index, i + 1 - index));
            backtrack(charArray, i + 1, len);
            path.remove(path.size() - 1);
        }
    }

    public boolean check(char[] charArray, int left, int right) {
        while(left < right){
            if(charArray[left] != charArray[right]) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
