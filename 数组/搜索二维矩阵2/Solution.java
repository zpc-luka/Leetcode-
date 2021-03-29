/**
 * 使用二分查找 按行寻找
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, column = matrix[0].length;

        for(int i = 0; i < row; i++) {
            if(target < matrix[i][0] || target > matrix[i][column - 1]) {
                continue;
            }
            boolean temp = binarySearch(matrix[i], target);
            if(temp) return temp;
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        int len = nums.length;

        int left = 0; 
        int right = len - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return true;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return false;
    }
}
