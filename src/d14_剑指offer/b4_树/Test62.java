package d14_剑指offer.b4_树;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序
 * 第三小结点的值为4。
 */
public class Test62 {
    static TreeNode  KthNode(TreeNode pRoot, int k)
    {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || pRoot != null) {
            while (pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            if(!stack.isEmpty()){
                pRoot = stack.pop();
                k--;
                if(k <= 0)return pRoot;
                pRoot = pRoot.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(KthNode(t1,3).val);
    }
}
