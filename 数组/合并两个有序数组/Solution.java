class Solution{
    public void merge(int[] nums1, int m, int[] nums2, int n){
        //copy nums1
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        //双指针
        int p1 = 0;
        int p2 = 0;
        //nums1 的 指针
        int p = 0;

        while((p1 < m) && (p2 < n)){
            nums[p++] = (nums1_copy[p1 < nums2[p2]]) ? nums1_copy[p1++] : nums2[p2++];
        }
        //如果还有数字没有放到nums1中
        if(p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1+p2, m+n-p1-p2);
        
        if(p2<m)
            System.arraycopy(nums2, p2, nums1, p1+p2, m+n-p1-p2);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n){
        //从后往前放，省去了复制 nums1 的过程
        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;

        while((p1 >= 0) && (p2 >= 0))
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        
        System.arraycopy(nums2, 0, nums1, 0, p2+1);

    }
}