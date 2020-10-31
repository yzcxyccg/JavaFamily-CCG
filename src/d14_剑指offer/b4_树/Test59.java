package d14_剑指offer.b4_树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按之字型顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推
 */
public class Test59 {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>>result = new ArrayList<>();
        if(pRoot == null)return result;
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.add(pRoot);
        boolean sign = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode pTree = queue.poll();
                if(pTree == null)continue;
                if(!sign){
                    list.add(pTree.val);
                }else
                    list.add(0,pTree.val);
                if(pTree.left!=null)queue.add(pTree.left);
                if(pTree.right!=null)queue.add(pTree.right);
            }
            sign = !sign;
            if(list.size() > 0)result.add(list);
        }
        return result;
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
        System.out.println(Print(t1));
    }
}
