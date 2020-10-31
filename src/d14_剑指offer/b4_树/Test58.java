package d14_剑指offer.b4_树;

/**
 * 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Test58 {
   static boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        return mirror(pRoot.left,pRoot.right);
    }
    public static boolean mirror(TreeNode left,TreeNode right){
        if(left == null && right == null)return true;
        else if(left == null || right == null)return false;
        if(left.val != right.val)return false;
        return mirror(left.left,right.right) && mirror(left.right,right.left);
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
        System.out.println(isSymmetrical(t1));
    }
}
