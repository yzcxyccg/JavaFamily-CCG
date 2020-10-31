package d14_剑指offer.b4_树;

import java.util.ArrayList;

/**
 * 二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，
 * 树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Test57 {
    static ArrayList<TreeLinkNode> list = new ArrayList<>();

    /**
     * 先找根节点，再中序遍历
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext1(TreeLinkNode pNode)
    {
        if(pNode == null)return pNode;
        TreeLinkNode par = pNode;
        while(par.next!=null){
            par = par.next;
        }
        inOrder(par);
        for(int i = 0 ; i < list.size() ; i++){
            if(pNode == list.get(i))
                return i==list.size()-1?null:list.get(i+1);
        }
        return null;
    }
    public void inOrder(TreeLinkNode pNode){
        if (pNode == null)return;
        inOrder(pNode.left);
        list.add(pNode);
        inOrder(pNode.right);
    }

    public TreeLinkNode GetNext2(TreeLinkNode pNode) {
        if(pNode == null) return null;
        //1.存在右结点，下一节点为右结点的最左结点
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            return pRight;
        }
        //2.不存在右结点
        if (pNode.next != null) {
            //2.1 该节点是其父节点的左节点，下一结点就是父节点
            if(pNode.next.left == pNode)return pNode.next;
            //2.2该节点是其父节点的有结点，向上查找，直到一个结点是其父节点的左节点，若找到根节点了，
            // 该节点就是最后一个结点
            TreeLinkNode pNext = pNode.next;
            while (pNext.next != null && pNext.next.right == pNext) {
                pNext = pNext.next;
            }
            return pNext.next;
        }
        return null;
    }
}
