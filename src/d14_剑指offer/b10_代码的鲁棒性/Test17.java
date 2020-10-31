package d14_剑指offer.b10_代码的鲁棒性;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
/**
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Test17 {
    public boolean isSmall(TreeNode root1, TreeNode root2) {
        if(root2 == null) return true;
        if(root1 == null) return false;
        if (root1.val == root2.val) {
            return isSmall(root1.right, root2.right) && isSmall(root1.left, root2.left);
        } else
            return false;
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        return isSmall(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

    }
}
