package 面试题;

import java.util.HashMap;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/8/2 13:12
 */

class Node1 {
    String key;
    int value;
    Node1 pre;
    Node1 post;
}

public class LRU {
    private int catacity;
    HashMap<String, Node1> cache = new HashMap<>();
    private int count;
    private Node1 head, tail;

    public LRU(int catacity) {
        this.catacity = catacity;
        this.head = new Node1();
        this.tail = new Node1();
        head.pre = null;
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }
    public int get(String key) {
        Node1 node1 = cache.get(key);
        if (node1 != null) {
            this.moveToHead(node1);
            return node1.value;
        }
        return -1;
    }

    public void set(String key, int value) {
        Node1 node1 = cache.get(key);
        if (node1 != null) {
            node1.value = value;
            this.moveToHead(node1);
        } else {
            Node1 newNode = new Node1();
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
        Node1 node1 = tail.pre;
        node1.pre.post = tail;
        tail.pre = node1.pre;
        return node1.value;
    }

    private void moveToHead(Node1 node1) {
        this.remove(node1);
        this.addNode(node1);
    }

    private void addNode(Node1 node1) {
        node1.pre = head;
        node1.post = head.post;
        head.post.pre = node1;
        head.post = node1;
    }

    private void remove(Node1 node1) {
        Node1 pre = node1.pre;
        Node1 post = node1.post;
        pre.post = post;
        post.pre = pre;
    }

    public static void main(String[] args) {
        LRU lru = new LRU(4);
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
