package d18_其他;

import java.util.HashMap;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/8/22 16:58
 */
class Node {
    String key;
    int value;
    Node pre;
    Node post;
}

public class Test5 {
    private int catacity;
    HashMap<String, Node> cache = new HashMap<>();
    private int count;
    private Node head, tail;

    public Test5(int catacity) {
        this.catacity = catacity;
        this.head = new Node();
        this.tail = new Node();
        head.pre = null;
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }
    public int get(String key) {
        Node node1 = cache.get(key);
        if (node1 != null) {
            this.moveToHead(node1);
            return node1.value;
        }
        return -1;
    }

    public void set(String key, int value) {
        Node node1 = cache.get(key);
        if (node1 != null) {
            node1.value = value;
            this.moveToHead(node1);
        } else {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            this.addNode(newNode);
            ++count;
            if (count > catacity) {
                this.popTail();
                --count;
            }
        }
    }

    private int popTail() {
        Node node1 = tail.pre;
        node1.pre.post = tail;
        tail.pre = node1.pre;
        return node1.value;
    }

    private void moveToHead(Node node1) {
        this.remove(node1);
        this.addNode(node1);
    }

    private void addNode(Node node1) {
        node1.pre = head;
        node1.post = head.post;
        head.post.pre = node1;
        head.post = node1;
    }

    private void remove(Node node1) {
        Node pre = node1.pre;
        Node post = node1.post;
        pre.post = post;
        post.pre = pre;
    }

    public static void main(String[] args) {
        Test5 lru = new Test5(4);
        lru.set("key1",7);
        lru.set("key2",5);
        lru.set("key3",2);
        lru.get("key1");
        lru.set("key4",9);
        lru.set("key5",3);
        lru.set("key5",3);
        System.out.println("");
    }
}
