package d10_树.b2_非递归方式的遍历;


import java.util.Stack;

public class BinaryTree {
    Node root;

    public BinaryTree() {
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * 前序递归方式创建二叉树，利用数组创建完全二叉树
     *
     * @param data 数据数组
     * @param i    数组的下标
     * @return
     */
    public Node createTree(int[] data, int i) {
        // 如果值为-1表示没有节点
        if (i >= data.length || data[i] == -1) {
            return null;
        }
        Node temp = new Node(data[i]);
        temp.left = createTree(data, i * 2 + 1);
        temp.right = createTree(data, i * 2 + 2);
        return temp;
    }

    /**
     * 前序遍历 非递归
     *
     * @param node root
     */
    public void preTraversal(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                System.out.print(node.element + "\t");
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 中序遍历 非递归
     *
     * @param node root
     */
    public void minTraversal(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                System.out.print(node.element + "\t");
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历 非递归
     *
     * @param node root
     */
    public void postTraversal(Node node) {
        Stack<Node> stack = new Stack<>();//元素栈
        Stack<Integer> signStack = new Stack<>();//辅助元素标志栈
        int i = 1;//表示当前元素已经遍历过
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                signStack.push(0);
                node = node.left;
            }
            while (!stack.empty() && signStack.peek() == i) {
                signStack.pop();
                System.out.print(stack.pop().element + "\t");
            }
            if (!stack.empty()) {
                signStack.pop();
                signStack.push(i);
                node = stack.peek().right;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] array = {1, 2, 3, 4, 5, 6, 7, -1, -1, 10, -1, -1, 13, -1, -1};
        Node node = binaryTree.createTree(array, 0);
        System.out.println("前序遍历：");
        binaryTree.preTraversal(node);
        System.out.println("\n中序遍历：");
        binaryTree.minTraversal(node);
        System.out.println("\n后序遍历：");
        binaryTree.postTraversal(node);
    }
}
