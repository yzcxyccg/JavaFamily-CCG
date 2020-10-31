package d15_leetcode;

/**
 * binary-tree-maximum-path-sum
 * 给定一个二叉树，请计算节点值之和最大的路径的节点值之和是多少。这个路径的开始节点和结束节点可以是
 * 二叉树中的任意节点,例如：给出以下的二叉树，
 *        1↵      / ↵     2   3 ,返回的结果为6
 */
public class Test27 {
    int maxValue;
    public int maxPathSum(TreeNode root) {
        if(root == null)return -1;
        maxValue = Integer.MIN_VALUE;
        getMaxValue(root);
        return maxValue;
    }
    public int getMaxValue(TreeNode root){
        if(root == null)return 0;
        int left = Math.max(0,getMaxValue(root.left));
        int right = Math.max(0,getMaxValue(root.right));
        maxValue = Math.max(maxValue , left + right + root.val);
        return Math.max(left,right) + root.val;
    }
}
