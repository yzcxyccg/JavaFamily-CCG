package d14_剑指offer.b4_树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Test60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>>result = new ArrayList<>();
        if(pRoot == null)return result;
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.add(pRoot);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode pTree = queue.poll();
                if(pTree == null)continue;
                list.add(pTree.val);
                if(pTree.left!=null)queue.add(pTree.left);
                if(pTree.right!=null)queue.add(pTree.right);
            }
            if(list.size() > 0)result.add(list);
        }
        return result;
    }
}
