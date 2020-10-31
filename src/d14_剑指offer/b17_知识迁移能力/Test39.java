package d14_剑指offer.b17_知识迁移能力;

/**
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Test39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;

    }
    public int depth(TreeNode root){
        if(root == null)return 0;
        int left = depth(root.left);
        if(left == -1)return -1;
        int right = depth(root.right);
        if(right == -1)return -1;
        if(left - right > 1 || left - right <-1)return -1;
        return 1 + (left>right?left:right);
    }
}
