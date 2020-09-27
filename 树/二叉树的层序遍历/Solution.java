import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * BFS 广度优先遍历
 * 广度优先遍历 也就是层序遍历，主要使用了队列 
 */


class Solution{
    public List<List<Integer>> LevelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();     // 申请一个队列用来存放每一层的数据
        
        if(root != null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            int n = queue.size();         //获得每一层有几个节点
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i<n; i++){
                TreeNode node = queue.poll();       //抛出这个节点的值
                level.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null ){
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
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