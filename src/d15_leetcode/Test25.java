package d15_leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * word-ladder
 * 给定两个单词（初始单词和目标单词）和一个单词字典，请找出所有的从初始单词到目标单词的最短转换序列的长度：
 * 每一次转换只能改变一个单词,每一个中间词都必须存在单词字典当中
 * 例如：给定的初始单词start="hit"，目标单词end ="cog"。单词字典dict =["hot","dot","dog","lot","log"]
 * 一个最短的转换序列为"hit" -> "hot" -> "dot" -> "dog" -> "cog",返回长度5
 * 注意：如果没有符合条件的转换序列，返回0。题目中给出的所有单词的长度都是相同的,题目中给出的所有单词都仅包含小写字母
 */
public class Test25 {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start == null || end == null || start.length() == 0 || dict == null) return 0;
        if (start == end) return 1;
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size > 0) {
                String path = queue.poll();
                size--;
                if (canChange(path, end)) return level + 1;
                for (Iterator<String> it = dict.iterator(); it.hasNext(); ) {
                    String str = it.next();
                    if (canChange(str, path)) {
                        queue.offer(str);
                        it.remove();
                    }
                }
            }
        }
        return 0;
    }

    public boolean canChange(String one, String two) {
        int count = 0;
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) != two.charAt(i))
                count++;
        }
        return count == 1 ? true : false;
    }

    public static void main(String[] args) {
        Test25 test25 = new Test25();
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("hot");
        hashSet.add("dot");
        hashSet.add("dog");
        hashSet.add("lot");
        hashSet.add("log");
        String start = "hit";
        String end = "cog";
        System.out.println(test25.ladderLength(start, end, hashSet));
    }
}
