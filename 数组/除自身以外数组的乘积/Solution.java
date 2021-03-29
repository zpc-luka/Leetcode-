class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];

        L[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = nums[i -1] * L[i - 1];
        }

        R[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) [
            res[i] = L[i] * R[i];
        ]

        return res;
    }    
}


class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        // 利用ans 本身 存储 nums[i] 左边的乘积
        for(int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i -1];
        }

        int R = 1;

        for(int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R = R * nums[i];
        }
        
        return ans;
    }
}