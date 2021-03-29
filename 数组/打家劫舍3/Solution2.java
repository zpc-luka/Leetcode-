import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

class Solution2 {
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) return 0;
        if(map.containsKey(root)) {
            return map.get(root);
        }

        int money = root.val;

        if(root.left != null) {
            money += (rob(root.left.left) + rob(root.left.right));
        } 
        if(root.right != null) {
            money += (rob(root.right.left) + rob(root.right.right));
        }

        int res = Math.max(money, rob(root.left) + rob(root.right));
        map.put(root, res);
        return res;
    }    
}
