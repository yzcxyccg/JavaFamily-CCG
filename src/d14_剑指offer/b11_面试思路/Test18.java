package d14_剑指offer.b11_面试思路;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Test18 {
    /**
     * 递归
     *
     * @param root
     */
    public static void Mirror1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        TreeNode pTree = root.left;
        root.left = root.right;
        root.right = pTree;
        Mirror1(root.left);
        Mirror1(root.right);
    }

    /**
     * 二叉树深度搜索
     *
     * @param root
     */
    public static void Mirror2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pTree, curTree;
        while (!stack.isEmpty()) {
            curTree = stack.pop();
            if (curTree == null || (curTree.left == null && curTree.right == null)) continue;
            pTree = curTree.left;
            curTree.left = curTree.right;
            curTree.right = pTree;
            stack.push(curTree.left);
            stack.push(curTree.right);
        }
    }

    /**
     * 二叉树广度搜索
     *
     * @param root
     */
    public static void Mirror3(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        Queue<TreeNode> queue = new LinkedList<>();
        //Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode pTree, curTree;
        while (!queue.isEmpty()) {
            curTree = queue.poll();
            if (curTree == null || (curTree.left == null && curTree.right == null)) continue;
            pTree = curTree.left;
            curTree.left = curTree.right;
            curTree.right = pTree;
            queue.add(curTree.left);
            queue.add(curTree.right);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(9);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

    }
}
