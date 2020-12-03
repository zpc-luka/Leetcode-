
class Solution{
    public int[] searchRange(int[] nums, int target){
        int len = nums.length;
        if(len == 0){
            return new int[]{-1,-1};
        }
        int[] res = new int[2];
        int i = 0, j = 0;

        while(i < len){
            if(nums[i] == target){
                res[0] = i;
                break;
            }
            i++;
        }
        
        if(i == len)
            return new int[]{-1,-1};
        
        if(i == len-1)
            return new int[]{len-1,len-1};
        
        j = i;
        while(j < len){
            if(nums[j] == target){
                res[1] = j; 
            }
            j++;
        }

        return res;
    }

    /**
     * 这里使用二分法寻找边界
     * https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE%E8%AF%A6%E8%A7%A3.md
     */
    public int[] searchRange2(int[] nums, int target){
        int len = nums.length;
        if(len == 0){
            return new int[]{-1,-1};
        }
        
        int left = findLeft(nums, target);
        if(left == -1)
            return new int[]{-1,-1};
        
        int right = findRight(nums, target);
        return new int[]{left, right};
    }

    private int findLeft(int[] nums, int target){
        int len = nums.length;
        int left = 0;
        int right = len;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] == target){
                right = mid;                 // 这里需要注意，不返回而是缩小范围继续寻找
            }else{
                right = mid;
            }
        }
        if(left == nums.length)            // 边界条件需要判断
            return -1;
        
        return nums[left] == target ? left : -1;
    }

    private int findRight(int[] nums, int target){
        int len = nums.length;
        int left = 0;
        int right = len;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] == target){
                left = mid + 1;                             // 这里如果找到边界的话，left=mid+1 然后 left == right 跳出循环， 所以返回值要减一
            }else{
                right = mid;
            }
        }
        if(left == 0) return -1;
        return nums[left - 1] == target ? (left-1): -1;           // 返回left-1
    }

    public static void main(String[] args) {
        Solution s =new Solution();
        int[] a = s.searchRange2(new int[]{5,7,7,8,8,10}, 8);
        for(int i:a){
            System.out.println(i);
        }
    }
}