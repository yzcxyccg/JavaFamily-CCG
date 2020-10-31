package d14_剑指offer.b14_分解让复杂问题简单;

import java.util.ArrayList;

/**
 * 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，
 * 只能调整树中结点指针的指向。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Test26 {

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null)) return pRootOfTree;
        ArrayList<TreeNode> list = new ArrayList<>();
        minTraversal(pRootOfTree, list);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
    }

    public static void minTraversal(TreeNode root, ArrayList<TreeNode> list) {
        if (root.left != null)
            minTraversal(root.left, list);

        list.add(root);

        if (root.right != null)
            minTraversal(root.right, list);
    }

    /**
     * 先遍历左边按理说是正确的因为题目没说要先左子树还是先右子树，
     * 但是先左边递归样例过不去，所以只能先右再左
     *结果12 10 7 5 4（错误）
     * 4 5 7 10 12（正确）
     */
    static TreeNode pre = null;
    public static TreeNode Convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null ) return null;
        Convert2(pRootOfTree.right);
        if (pre == null) pre = pRootOfTree;
        else {
            pre.left = pRootOfTree;
            pRootOfTree.right = pre;
            pre = pRootOfTree;
        }
        Convert2(pRootOfTree.left);
        return pre;

}

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        System.out.println(Convert2(t1).val);
    }
}
