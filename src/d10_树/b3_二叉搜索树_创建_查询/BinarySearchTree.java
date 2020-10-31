package d10_树.b3_二叉搜索树_创建_查询;

import d10_树.b2_非递归方式的遍历.Node;

/**
 * 二叉搜索树 bst
 */
public class BinarySearchTree {
    Node root;//bst的根节点

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    /**
     * 递归实现bst树的插入操
     * @param val
     */
    public void insert(int val) {
        root = insert(root, val);
    }

    /**
     * 从root节点开始寻找位置，插入val
     *
     * @param root
     * @param val  要插入的值
     * @return
     */
    public Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val, null, null);
        }
        if (val < root.element) {
            root.left = insert(root.left, val);
        } else if (val > root.element) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    /**
     * 非递归实现bst插入操作
     *
     * @param val 要插入的值
     * @return
     */
    public void insert_non(int val) {
        //考虑根节点的特殊情况
        if (root == null) {
            root = new Node(val, null, null);
            return;
        }
        //考虑val值需要插入的地方
        Node parent = null;
        Node cur = root;
        while (cur != null) {
            if (val < cur.element) {
                parent = cur;
                cur = cur.left;
            } else if (val > cur.element) {
                parent = cur;
                cur = cur.right;
            } else {
                return;
            }
        }
        //把cur生成新节点插入bst中
        if (val < parent.element) {
            parent.left = new Node(val, null, null);
        } else {
            parent.right = new Node(val, null, null);
        }
    }

    /**
     * 递归搜索值为val的结点
     *
     * @param root
     * @param val
     * @return
     */
    public Node query(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.element) {
            return query(root.left, val);
        } else if (val > root.element) {
            return query(root.right, val);
        } else {
            return root;
        }
    }

    /**
     * 判断val在bst中是否存在
     *
     * @param root
     * @param val
     * @return
     */
    public boolean query1(Node root, int val) {
        boolean sign = false;
        if (root == null) {
            return false;
        } else if (root.element == val) {
            return true;
        } else {
            sign = query1(root.left, val);
            if (!sign) {
                sign = query1(root.right, val);
            }
        }
        return sign;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
        binarySearchTree.insert(3);
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(0);
        binarySearchTree.insert(1);

        System.out.println(binarySearchTree.query1(binarySearchTree.root, 10));
        System.out.println(binarySearchTree.query(binarySearchTree.root, 6));

    }
}
