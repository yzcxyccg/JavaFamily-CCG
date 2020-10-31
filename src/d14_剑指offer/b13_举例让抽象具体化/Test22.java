package d14_剑指offer.b13_举例让抽象具体化;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;


    public TreeNode(int val) {
        this.val = val;
    }

}
public class Test22 {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null) return null;
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            result.add(root.val);
            if(root.left != null)queue.add(root.left);
            if(root.right != null)queue.add(root.right);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(8);
        t1.left = t2;t1.right = t3;t3.left=t4;t3.right = t5;
        System.out.println(PrintFromTopToBottom(t1));
    }
}
