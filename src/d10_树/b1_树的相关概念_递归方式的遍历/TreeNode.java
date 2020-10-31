package d10_树.b1_树的相关概念_递归方式的遍历;

public class TreeNode {
    private String data;//数据部分
    private TreeNode left;//左节点的引用
    private TreeNode right;//右节点的引用

    public TreeNode() {
    }

    public TreeNode(String data) {
        this.data = data;
    }

    public TreeNode(String data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
