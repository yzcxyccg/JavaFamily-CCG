package d14_剑指offer.b13_举例让抽象具体化;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Test24 {
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();

    /**
     * 递归形式
     *
     * @param root
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return result;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
            result.add(new ArrayList<>(list));
        result = FindPath(root.left, target);
        result = FindPath(root.right, target);
        list.remove(list.size() - 1);
        return result;
    }

    /**
     * 非递归
     *
     * @param root
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curTree;
        while (root != null || !stack.isEmpty()) {
            //从根结点到最左边的结点的路径入栈，写入list中
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                target -= root.val;
                root = root.left;
            }
            //弹出5之后因为5的右结点不为空，所以没有删除5，这里将list中的5删除掉
            while ((stack.peek().val) != (list.get(list.size() - 1))) {
                target += list.get(list.size() - 1);
                list.remove(list.size() - 1);
            }
            if (target == 0 && stack.peek().left == null) {
                result.add(new ArrayList<Integer>(list));
            }
            //左节点到null之后，需要去找到右节点对应的元素，通过推栈来实现
            if (!stack.isEmpty()) {
                root = stack.pop();
                curTree = root;
                root = root.right;
                if (root == null) {
                    list.remove(list.size() - 1);
                    target += curTree.val;
                }
            }
        }
        return result;
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
        FindPath2(t1, 22);
        System.out.println(result);
    }
}
