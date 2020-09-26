import java.util.Deque;
import java.util.LinkedList;

class Solution{
    /**
     * 递归
     * 比较左子树与根节点 右子树与根节点的大小
     */
    public boolean isValidBST(TreeNode root){
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode node, int lower, int upper){
        if(node == null){
            return true;
        } 
        int val =node.value;
        if(val <= lower || val >= upper) return false;

        return helper(node.left, lower, node.value) && helper(node.right, node.value, upper);
        
    }
/**
 * 中序遍历 使用一个栈
 * 这个没咋看懂
 */
    public boolean isValidBST2(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = Double.MIN_VALUE;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if(root.val <= inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
/**
 * 这个还可以勉强理解
 */
    public boolean isValidBST3(TreeNode root){
        if(root == null){
            return true;
        }

        if(!isValidBST3(root.left)){
            return false;
        }
        if(root.value <= pre){
            return false;
        }
        pre = root.value;
        return isValidBST3(root.right);

    }
}

public class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value){
        this.value = value;
    }
}