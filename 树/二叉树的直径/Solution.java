package 树.二叉树的直径;

public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    
    private int max = 0;

    private int depth(TreeNode root) {       // 这个函数就是球一个节点的深度
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        max = Math.max(max, left+right);     // 直径 就是 左子树深度 和 右子树深度 之和

        return Math.max(left, right) + 1;    // 返回该节点深度

    }
}
