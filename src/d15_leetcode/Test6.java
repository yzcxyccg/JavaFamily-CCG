package d15_leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * binary-tree-postorder-traversal
 * 求给定的二叉树的后序遍历。
 * 例如：
 * 给定的二叉树为{1,#,2,3},
 */
public class Test6 {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null)return list;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(root != null || !stack1.isEmpty()){
            while(root != null){
                stack1.push(root);
                stack2.push(0);
                root = root.left;
            }
            while(!stack1.isEmpty() && stack2.peek() == 1){
                list.add(stack1.pop().val);
                stack2.pop();
            }
            if(!stack1.isEmpty()){
                stack2.pop();
                stack2.push(1);
                root = stack1.peek().right;
            }
        }
        return list;
    }
}
