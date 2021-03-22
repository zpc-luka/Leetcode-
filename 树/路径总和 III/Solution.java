import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> map;
    
    public int pathSum(TreeNode root, int sum) {
        map = new HashMap<>();
        map.put(0, 1);          // 和为0时，只有一种就是什么都不选   
        //   任意一个节点的前缀和减去零，对应的是从根节点到该节点的路径和；如果不加这一条语句，任意两个节点的前缀和相减是一定会把根节点减掉的，得到的所有路径都不是从根节点开始的

        int res = backtrack(root, sum, 0);

        return res;

    }
    /**
     * 这个函数计算 以每个节点出发 的路径和
     * @param root
     * @param sum
     * @param curSum
     * @return
     */
    private int backtrack(TreeNode root, int sum, int curSum) {
        if(root == null) {
            return 0;
        }

        int res = 0;
        curSum += root.val;

        if(map.containsKey(curSum - sum)) {
            res += map.getOrDefault(curSum - sum, 0);
        }

        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        int left = backtrack(root.left, sum, curSum);
        int right = backtrack(root.right, sum, curSum);

        res = res + left + right;

        map.put(curSum, map.get(curSum) - 1);

        return res;
    }
}
