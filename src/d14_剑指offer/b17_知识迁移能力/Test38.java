package d14_剑指offer.b17_知识迁移能力;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）
 * 形成树的一条路径，最长路径的长度为树的深度。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Test38 {
    public int TreeDepth1(TreeNode root) {
        if (root == null) return 0;
        int left = TreeDepth1(root.left);
        int right = TreeDepth1(root.right);
        return Math.max(left, right) + 1;
    }

    public int TreeDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int d = 0, count = 0, nextCount = queue.size();
        while (queue.size() != 0) {
            root = queue.poll();
            count++;
            if (root.left != null) queue.add(root.left);
            if (root.right != null) queue.add(root.right);
            if (count == nextCount) {
                d++;
                count = 0;
                nextCount = queue.size();
            }
        }
        return d;
    }
}
