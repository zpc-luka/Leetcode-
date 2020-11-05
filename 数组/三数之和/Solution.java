//三数之和
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        int  n = nums.length;
        //首先升序排序
        Arrays.sort(nums);

        for(int i=0; i<n; i++){
            //如果这个数是大于0 后面的数加起来都不可能大于0
            if(nums[i] > 0)
                return lists;
            //如果这个数与上个数相同就跳过，防止重复
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            //使用双指针
            int L = i+1;
            int R = n-1;
            int cur = nums[i];

            while(L < R){
                int tmp = cur + nums[L] + nums[R];
                if(tmp == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    //防止重复
                    while(L < R && nums[L] == nums[L+1]) L++;
                    while(L < R && nums[R] == nums[R-1]) R--;

                    L++;
                    R--;
                }else if(tmp < 0){
                    L++;
                }else{
                    --R;
                }
            }
        }
        return lists;

    }
}