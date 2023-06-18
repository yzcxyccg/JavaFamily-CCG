package d15_leetcode.leetcode.editor.cn;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 9668 👎 0


import java.util.ArrayList;
import java.util.List;

/**
 * 两数相加
 * <p>
 * 2023-06-18 17:37:19
 *
 * @author chengcongguang
 */
public class P2_AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        Solution solution = new P2_AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        solution.addTwoNumbers(l1, l2);

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode head = new ListNode(0);
            ListNode cur = head;
            int jw = 0;
            while (l1 != null || l2 != null) {
                int x = l1 != null ? l1.val : 0;
                int y = l2 != null ? l2.val : 0;
                int sum = x + y + jw;
                jw = sum / 10;
                ListNode node = new ListNode(sum % 10);
                cur.next = node;
                cur = node;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (jw == 1) {
                cur.next = new ListNode(jw);
            }
            return head.next;
//            long sum = getNum(nodeToInt(l1)) + getNum(nodeToInt(l2));
//            List<Integer> resultList = new ArrayList<>();
//            if (sum == 0) {
//                return new ListNode(0);
//            }
//            while (sum > 0) {
//                resultList.add((int) (sum % 10));
//                sum /= 10;
//            }
//            ListNode resultNode = new ListNode(resultList.get(0));
//            ListNode cur = resultNode;
//            for (int i = 1; i < resultList.size(); i++) {
//                ListNode node = new ListNode(resultList.get(i));
//                cur.next = node;
//                cur = node;
//            }
//
//            return resultNode;
        }

        private List<Integer> nodeToInt(ListNode nodeList) {
            List<Integer> list = new ArrayList<>();
            while (nodeList != null) {
                list.add(nodeList.val);
                nodeList = nodeList.next;
            }
            return list;
        }

        private long getNum(List<Integer> l1) {
            StringBuilder s1 = new StringBuilder();
            for (int i = l1.size() - 1; i >= 0; i--) {
                s1.append(l1.get(i));
            }
            return Long.parseLong(s1.toString());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}