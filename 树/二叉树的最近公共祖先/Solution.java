package 树.二叉树的最近公共祖先;

import javax.swing.tree.TreeNode;

public class Solution {
    
    private TreeNode ans;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;

        boolean inCurrentNode = root.val == p.val || root.val == q.val;

        boolean inleft = dfs(root.left, p, q);
        boolean inright = dfs(root.right, p, q);
        
        if((inleft && inright) || (inCurrentNode && (inleft || inright))) {
            ans = root;
        }

        return inleft || inright || inCurrentNode;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
}
