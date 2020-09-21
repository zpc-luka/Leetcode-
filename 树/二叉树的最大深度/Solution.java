import java.util.Queue;

/**
 * 这题使用了 深度优先算法（Deepth First Search DFS）
 * 主要思想就是沿着一条路走下去
 * 二叉树的深度  = 左右子树的深度的较大值 + 1
 * 而子树的的深度采用递归
 */


class Solution{
    /**
     * DFS 
     */
    public int maxDepth1(TreeNode root) {
        if(root == null){
            return 0;
        } else{
            int leftHeight = maxDepth1(root.left);
            int rightHeight = maxDepth1(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }

    }

    /**
     * BFS Breadth First Search
     * 就是每一层都记录有多少个分支点
     * 用一个队列来保存
     * 
     */
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
    }
}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}