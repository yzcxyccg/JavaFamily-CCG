package d15_leetcode;

/**
 * sum-root-to-leaf-numbers
 * 给定一个仅包含数字0-9的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。例如根节点到叶子节点
 * 的一条路径是1->2->3,那么这条路径就用123来代替。找出根节点到叶子节点的所有路径表示的数字之和
 * 例如：1↵   / ↵  2   3  根节点到叶子节点的路径1->2用数字12代替
 * 根节点到叶子节点的路径1->3用数字13代替 所以答案为12+13=25
 */
public class Test22 {
    public int sumNumbers(TreeNode root) {
        if(root == null)return 0;
        int sum = 0;
        return preOrderSum(root,sum);

    }
    public int preOrderSum(TreeNode root,int sum){
        if(root == null)return 0;
        sum = sum*10+root.val;
        if(root.left == null && root.right == null)return sum;
        return preOrderSum(root.left,sum) + preOrderSum(root.right,sum);
    }

    public static void main(String[] args) {
        Test22 test22 = new Test22();
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);
        t1.right = t2;
        t1.left = t3;
        System.out.println(test22.sumNumbers(t1));
    }
}
