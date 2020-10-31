package d10_树.b2_非递归方式的遍历;

public class Node {
    public int element;//数据域
    public Node left;//左孩子
    public Node right;//右孩子

    public Node() {
    }

    public Node(int element) {
        this.element = element;
    }

    public Node(int element, Node left, Node right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
