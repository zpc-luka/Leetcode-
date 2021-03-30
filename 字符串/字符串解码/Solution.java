import java.util.Deque;
import java.util.LinkedList;

class Solution {
    /**
     * https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
     */
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Deque<Integer> stack_multi = new LinkedList<>();
        Deque<String> stack_res = new LinkedList<>();

        int multi = 0;

        for(char c: s.toCharArray()) {
            if(c == '[') {
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int curMulti = stack_multi.poll();
                for(int i = 0; i < curMulti; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.poll() + tmp);
            } else if(c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else{
                res.append(c);
            }
        }
        return res.toString();
    }    
}
