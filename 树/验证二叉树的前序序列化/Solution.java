package 树.验证二叉树的前序序列化;

import java.util.Deque;
import java.util.LinkedList;
/**
 * 1）如果遇到的不是'#'，直接入栈；

* 2）如果遇到'#'，则看当前栈顶是否也是'#'。

* 如果是，则弹出2个字符，压入1个'#'（连续两个'#'，则可消掉再前面一个节点，兑成一个'#'，入栈）；
* 否则，直接入栈；
* 兑出来的'#'入栈后，如果满足2），则继续循环2）
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0) return true;
        String[] str = preorder.split(",");

        int n = str.length;

        if("#".equals(str[0]) && n > 1) return false;
        if("#".equals(str[0])) return true;

        Deque<String> stack = new LinkedList<>();

        int i = 0;

        while(i < n) {
            String c = str[i];
            if(!"#".equals(c)) {
                stack.push(c);
                i++;
            } else {
                if ("#".equals(stack.peek())) {
                    stack.pop();
                    if(stack.isEmpty()) return false;
                    stack.pop();
                } else {
                    stack.push(c);
                    i++;
                }
            }
        }
        return stack.size() == 1 && "#".equals(stack.peek());

    }
}
