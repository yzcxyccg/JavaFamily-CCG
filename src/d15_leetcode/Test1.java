package d15_leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * minimum-depth-of-binary-tree
 * 求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class Test1 {
    /**
     * BFS
     * @param root
     * @return
     */
    public int run(TreeNode root) {
        if(root == null)return 0;
        int dep = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            dep++;
            for(int i = 0 ; i < size ; i++){
                root = queue.poll();
                if(root.left == null && root.right == null)return dep;
                if(root.left != null)queue.offer(root.left);
                if(root.right != null)queue.offer(root.right);
            }
        }
        return dep;
    }

    /**
     * 递归调用
     * @param root
     * @return
     */
    public int run1(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left  = run(root.left);
        int right  = run(root.right);
        if(left*right >0){
            return (left>right?right:left)+1;
        }else{
            return (left>right?left:right)+1;
        }
    }
}
