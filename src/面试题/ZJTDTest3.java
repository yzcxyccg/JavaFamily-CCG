package 面试题;

import java.util.HashMap;

/**
 * @author 程从广
 * @Description LRU（最久未使用）
 * @Date 创建于 2020/7/28 0:54
 */
class Node {
    Integer key;
    int value;
    Node pre;
    Node post;
}

public class ZJTDTest3 {
    HashMap<Integer, Node> cache = new HashMap<>();
    private int count;
    private int capacity;
    private Node head, tail;

    public ZJTDTest3(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        this.head = new Node();
        head.pre = null;
        this.tail = new Node();
        tail.post = null;
        tail.pre = head;
        head.post = tail;
    }

    public int get(Integer key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        this.moveToHead(node);
        return node.value;
    }

    public void set(Integer key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node();
            newNode.value = value;
            newNode.key = key;
            cache.put(key, newNode);
            this.addNode(newNode);
            ++count;
            if (count > capacity) {
                Node tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }

    private Node popTail() {
        Node res = this.tail.pre;
        this.removeTail(res);
        return res;
    }

    private void removeTail(Node node) {
        Node pre = node.pre;
        Node post = node.post;
        pre.post = post;
        post.pre = pre;
    }

    private void addNode(Node node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    private void moveToHead(Node node) {
        this.removeTail(node);
        this.addNode(node);
    }

    public static void main(String[] args) {
        ZJTDTest3 zjtdTest3 = new ZJTDTest3(4);
        zjtdTest3.set(1,7);
        zjtdTest3.set(2,0);
        zjtdTest3.set(3,2);
        zjtdTest3.set(4,1);
        zjtdTest3.set(5,6);
        zjtdTest3.get(3);
        zjtdTest3.set(2,0);
        zjtdTest3.get(5);
        zjtdTest3.set(1,7);
    }
}
