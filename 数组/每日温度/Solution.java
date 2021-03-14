/**
 * 遍历整个数组，如果栈不空，且当前数字大于栈顶元素，那么如果直接入栈的话就不是 递减栈 ，所以需要取出栈顶元素，由于当前数字大于栈顶元素的数字，而且一定是第一个大于栈顶元素的数，直接求出下标差就是二者的距离。

继续看新的栈顶元素，直到当前数字小于等于栈顶元素停止，然后将数字入栈，这样就可以一直保持递减栈，且每个数字和第一个大于它的数的距离也可以算出来。


https://leetcode-cn.com/problems/daily-temperatures/solution/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/

 */
class Solution {
    public int[] dailyTemperature(int[] T) {
        Deque<Integer> stack = new LinkedList<>();
        
        int len = T.length;
        int[] res = new int[len];
        
        for (int i=0; i < len; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int temp = stack.pop();
                res[temp] = i - temp;
            }

            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] T = {73, 74,75,71,69,72,76,73};

        System.out.println(s.dailyTemperature(T));
    }
}