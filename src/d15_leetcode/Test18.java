package d15_leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * clone-graph
 * 本题要求复制一个无向图，图中每个节点都包含一个标签和它的邻居列表.我们无向图用以下的方法序列化：
 * 节点的标签是互不相同的，我们使用“#”作为节点之间的分隔符，使用“,”作为节点标签和节点的节点邻居的分隔符。
 * 例如：现在有一个序列化的无向图{0,1,2#1,2#2,2}.这个无向图一共有3个节点，因此序列被#分隔成三部分
 * 第一个节点的标签是0，节点0和节点1，节点2之间有边,第二个节点的标签是1，节点1和节点2之间有边
 * 第三个节点的标签是2，节点2和节点2（它自己）之间有边，形成了自环
 * 这个无向图如下图所示
 *        1↵      / ↵     /   ↵    0 --- 2↵         / ↵         \_/↵
 */
 class UndirectedGraphNode {
     int label;
     ArrayList<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 }
public class Test18 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        // map存储旧节点到新节点的映射
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        map.put(node, head);
        // DFS需要用到栈
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        stack.push(node);
        while (!stack.isEmpty()) {
            UndirectedGraphNode root = stack.pop();
            ArrayList<UndirectedGraphNode> lists = new ArrayList<UndirectedGraphNode>();
            for (UndirectedGraphNode n : root.neighbors) {
                if (map.containsKey(n)) {
                    lists.add(map.get(n));
                } else {
                    UndirectedGraphNode n1 = new UndirectedGraphNode(n.label);
                    stack.push(n);
                    map.put(n, n1);
                    lists.add(n1);
                }
            }
            System.out.println(map.containsKey(root));
            map.get(root).neighbors = lists;
        }
        return head;
    }

    /**
     * 递归
     */
    public HashMap<Integer,UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        return clone(node);
    }
    public UndirectedGraphNode clone(UndirectedGraphNode node){
        if(node == null)return node;
        if(map.containsKey(node.label))
            return map.get(node.label);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label,clone);
        for(UndirectedGraphNode n : node.neighbors){
            clone.neighbors.add(clone(n));
        }
        return clone;
    }

    public static void main(String[] args) {
        UndirectedGraphNode u1 = new UndirectedGraphNode(0);
        UndirectedGraphNode u2 = new UndirectedGraphNode(1);
        UndirectedGraphNode u3 = new UndirectedGraphNode(2);
        UndirectedGraphNode u4 = new UndirectedGraphNode(3);
//        u1.neighbors.add(new UndirectedGraphNode(u2.label));
//        u1.neighbors.add(new UndirectedGraphNode(u3.label));
//        u2.neighbors.add(new UndirectedGraphNode(u3.label));
//        u3.neighbors.add(new UndirectedGraphNode(u3.label));
        u1.neighbors.add(u2);u1.neighbors.add(u3);
        u2.neighbors.add(u3);u3.neighbors.add(u3);
        Test18 test18 = new Test18();
        test18.cloneGraph(u1);
    }
}
