// 盛最多的水
/**
 * 典型使用双指针的方法
 */
class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int area = 0;

        while(i < j){
            int temp_area = Math.min(height[i], height[j]) * (j - i);
            area = Math.max(area, temp_area);

            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }

        return area;
    }
}