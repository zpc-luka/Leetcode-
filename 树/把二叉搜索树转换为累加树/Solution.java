package 树.把二叉搜索树转换为累加树;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private int sum = 0;

    private void dfs(TreeNode root) {
        if(root == null)  return;

        dfs(root.right);
        sum = sum + root.val;
        root.val = sum;
        dfs(root.left);
    }

    /**
     * 使用栈模拟 广度优先遍历   反向中序遍历
     * @param root
     */
    private void bfs(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        int sum = 0;
        TreeNode cur = root;

        while(cur != null) {        // 将右子树压入栈
            stack.push(cur);
            cur = cur.right;
        }

        while(!stack.isEmpty()) {
            cur = stack.pop();
            sum = cur.val + sum;            // 对当前节点操作
            cur.val = sum;

            cur = cur.left;                 // 将左子树压入栈
            while(cur != null) {
                stack.push(cur);
                cur = cur.right;          // 让当前左子节点的右子节点不断压栈
            }
        }

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
    