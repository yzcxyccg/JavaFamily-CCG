package d15_leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * binary-tree-preorder-traversal
 * 求给定的二叉树的前序遍历。
 * 例如：
 * 给定的二叉树为{1,#,2,3},
 */
public class Test7 {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null)return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }
        }
        return list;
    }
}
