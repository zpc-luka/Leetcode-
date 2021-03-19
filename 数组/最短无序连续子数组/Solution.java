package 数组.最短无序连续子数组;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int l = nums.length;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();
        for (int j = nums.length - 1; j >= 0; j--) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[j]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(j);
        }

        return r - l > 0 ? r - l + 1 : 0;
    }
}
