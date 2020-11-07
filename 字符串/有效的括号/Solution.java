import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//有效的括号
class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        if(length % 2 != 0){
            return false;
        }
        //用哈希表判断左右括号对应关系
        Map<Character, Character> hashmap = new HashMap<>();
        hashmap.put('(', ')');
        hashmap.put('[', ']');
        hashmap.put('{', '}');

        Deque<Character> stack = new LinkedList<Character>();
        for(char c: s.toCharArray()){
            if(hashmap.containsKey(c)){   // 遇见左括号就入栈
                stack.push(c);
            }else{                        // 遇见右括号
                if(!stack.isEmpty()){     // 如果栈顶弹出的括号和此时的c不匹配直接返回false
                    if(hashmap.get(stack.poll()) != c){
                        return false;
                    }
                }else{                     // 此时栈为空,但却来了个右括号,也直接返回false
                    return false;
                }
            }
        }
        return stack.isEmpty();           //循环结束时,栈为空,就为有效括号

    }
}