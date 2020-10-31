package d15_leetcode;

import java.util.*;

/**
 * word-ladder-ii
 * 给定两个单词（初始单词和目标单词）和一个单词字典，请找出所有的从初始单词到目标单词的最短转换序列：
 * 每一次转换只能改变一个单词,每一个中间词都必须存在单词字典当中
 * 例如：给定的初始单词start="hit"，目标单词end ="cog"。单词字典dict =["hot","dot","dog","lot","log"]
 * 返回的结果为：[↵    ["hit","hot","dot","dog","cog"],↵    ["hit","hot","lot","log","cog"]↵  ]
 * 注意：题目中给出的所有单词的长度都是相同的,题目中给出的所有单词都仅包含小写字母
 */
public class Test24 {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        int wordSize = start.length(), minSize = Integer.MAX_VALUE, level = 1;
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if (wordSize == 0 || dict == null || dict.size() == 0) return result;
        Queue<ArrayList<String>> queue = new LinkedList<>();
        queue.offer(new ArrayList<String>() {{
            add(start);
        }});
        ArrayList<String> words = new ArrayList<>();
        words.add(start);
        while (!queue.isEmpty()) {
            ArrayList<String> path = queue.poll();
            int currentSize = path.size();
            if (currentSize > level) {
                //已找到最短序列
                if (currentSize + 1 > minSize) break;
                for (String str : words) {
                    dict.remove(str);
                }
                words.clear();
                level = currentSize;
            }
            String lastword = path.get(currentSize - 1);
            if(canChange(lastword,end)) {
                result.add(deepCopy(path,end));
                minSize = currentSize+1;
            }
            for (Iterator<String> it = dict.iterator(); it.hasNext(); ){
                String str = it.next();
                if(canChange(str,lastword))
                    queue.offer(deepCopy(path,str));
            }
           /* for (int i = 0; i < wordSize; i++) {
                char[] charArr = lastword.toCharArray();
                for (char j = 'a'; j < 'z'; j++) {
                    charArr[i] = j;
                    String newStr = new String(charArr);
                    if (newStr.equals(end)) {
                        result.add(deepCopy(path, newStr));
                        minSize = currentSize + 1;
                    } else if (dict.contains(newStr)) {
                        words.add(newStr);
                        queue.offer(deepCopy(path, newStr));
                    }
                }
            }*/
        }
        return result;
    }
    public boolean canChange(String one ,String two){
        int count = 0;
        for(int i = 0 ; i < one.length() ; i++){
            if(one.charAt(i) != two.charAt(i))
                count++;
        }
        return count == 1 ? true : false;
    }

    public ArrayList<String> deepCopy(ArrayList<String> arr, String newStr) {
        ArrayList<String> newPath = new ArrayList<>();
        for (String str : arr) {
            newPath.add(str);
        }
        newPath.add(newStr);
        return newPath;
    }

    public static void main(String[] args) {
        Test24 test24 = new Test24();
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("hot");
        hashSet.add("dot");
        hashSet.add("dog");
        hashSet.add("lot");
        hashSet.add("log");
        String start = "hit";
        String end = "cog";
        System.out.println(test24.findLadders(start, end, hashSet));
    }
}
