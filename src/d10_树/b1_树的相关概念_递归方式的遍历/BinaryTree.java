package d10_树.b1_树的相关概念_递归方式的遍历;

public class BinaryTree {
    TreeNode root; //根节点

    public BinaryTree() {
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     * @param node
     */
    public void preTraversal(TreeNode node) {
        if (node != null) {
            System.out.println(node.getData());
            preTraversal(node.getLeft());
            preTraversal(node.getRight());
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void minTraversal(TreeNode node) {
        if (node != null) {
            minTraversal(node.getLeft());
            System.out.println(node.getData());
            minTraversal(node.getRight());
        }
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public void postTraversal(TreeNode node) {
        if (node != null) {
            postTraversal(node.getLeft());
            postTraversal(node.getRight());
            System.out.println(node.getData());
        }
    }

    public static void main(String[] args) {
        TreeNode l21 = new TreeNode("left21", null, null);
        TreeNode r21 = new TreeNode("right21", null, null);
        TreeNode l22 = new TreeNode("left22", null, null);
        TreeNode r22 = new TreeNode("right22", null, null);
        //根节点的左孩子
        TreeNode l1 = new TreeNode("left1", l21, r21);
        //根结点的右孩子
        TreeNode r1 = new TreeNode("right1", l22, r22);

        TreeNode root = new TreeNode("root", l1, r1);
        BinaryTree binaryTree = new BinaryTree(root);
        System.out.println("-----先序遍历-----");
        binaryTree.preTraversal(root);
        System.out.println("-----中序遍历-----");
        binaryTree.minTraversal(root);
        System.out.println("-----后序遍历-----");
        binaryTree.postTraversal(root);

    }
}
