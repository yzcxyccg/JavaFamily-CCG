package d15_leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * word-break
 * 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，使得单词序列中所有的单词都是
 * dict中的单词（序列可以包含一个或多个单词）。例如:给定s=“leetcode”；
 * dict=["leet", "code"].返回true，因为"leetcode"可以被分割成"leet code".
 */
public class Test12 {

    static boolean sign = false;
    static int count = 0;
    public boolean wordBreak1(String s, Set<String> dict) {
        if(s.length() == 0 || dict == null)return false;
        return DFS(s,dict);

    }
    public boolean DFS(String s, Set<String> dict){
        if(s.length() == 0)sign = true;
        if(sign)return true;
        for(String str:dict){
            if(sign)return true;
            if(s.startsWith(str)){
                DFS(s.substring(str.length()),dict);
            }
            count++;
        }
        return sign;
    }
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        //i循环的目的是，确定能不能拼成以i为下标结尾的字符串
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(res[j]&&dict.contains(s.substring(j, i))){
                    res[i]=true;
                    //只要找到一个 能拼成以i为下标结尾的字符串，就可以跳出循环

                    break;
                }
                count++;
            }
        }

        return res[s.length()];
    }

    public static void main(String[] args) {
        Test12 test12 = new Test12();
        String s = "catsanddog";
        String s1 = "catsanddoghhh";
        String s2 = "a";

        Set<String> set = new HashSet<>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        //set.add("b");
        System.out.println(test12.wordBreak1(s1,set));
        System.out.println(count);
    }
}
