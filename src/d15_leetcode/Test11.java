package d15_leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * word-break-ii
 * 给定一个字符串s和一组单词dict，在s中添加空格将s变成一个句子，使得句子中的每一个单词都是dict中的单词
 * 返回所有可能的结果.例如：给定的字符串s ="catsanddog",dict =["cat", "cats", "and", "sand", "dog"].
 * 返回的结果为["cats and dog", "cat sand dog"].
 */
public class Test11 {
    public ArrayList<String> wordBreak(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, ArrayList<String>>());
    }

    private ArrayList<String> DFS(String s, Set<String> wordDict, HashMap<String, ArrayList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);
        ArrayList<String> res = new ArrayList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String subStr : wordDict) {
            if (s.startsWith(subStr)) {
                for (String str : DFS(s.substring(subStr.length()), wordDict, map)) {
                    res.add(subStr + (str == "" ? "" : " ") + str);
                }
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        String s = "catsanddog";
        Set<String> set = new HashSet<>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        System.out.println(test11.wordBreak(s,set));
    }
}
