/**
 * 字符串转换为整数
 * 这题还是有一定难度的，自己也看了好长时间。
 */

class Solution {
    public int myAtoi(final String str) {
        final int len = str.length();
        int i = 0;
        final char[] strs = str.toCharArray();

        while(i<len && strs[i] == ' '){
            i++;
        }
        if(i==len) return 0;
        boolean negative = false;
        if(strs[i] == '-'){
            negative = true;
            i++;
        }
        else if(strs[i] == '+') i++;
        else if(!Character.isDigit(strs[i])) return 0;
        
        int ans = 0;
        while(i < len && Character.isDigit(strs[i])){
            int digit = strs[i] - '0';
            if(ans > (Integer.MAX_VALUE - digit)/10) return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;

            ans = 10 * ans + digit;
            i++;
        }
        return negative? -ans : ans;
    }
}
/*
-------------------------------------------------------------------------------------------------------------------------------------
*/
class Solution2{
    public int myAtoi(String str ){
        Automata auto=new Automata();
        char[] temp=str.toCharArray();
        for(char c:temp)
        auto.get(c);

        return auto.sign*(int)auto.ans;
    }
}

/**
 * 有限状态机
 */
class Automata{
    private int state=0;
    private int[][] table={{0,1,2,3},{3,3,2,3},{3,3,2,3},{3,3,3,3}};
    long ans=0;
    int sign=1;

    public int gets(char c){
        if(c==' ')return 0;
        if(c=='+'||c=='-')return 1;
        if(Character.isDigit(c))return 2;
        return 3;
    }

    public void get(char c){
        state=table[state][gets(c)];
        if(state==2){
            ans=ans*10+(c-'0');
            ans= sign==1 ? Math.min(ans,Integer.MAX_VALUE):Math.min(ans,-(long)Integer.MIN_VALUE);
        }
        if(state==1&&c=='-')sign=-1;
    }

}