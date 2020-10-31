package d15_leetcode;

import java.util.ArrayList;

/**
 * palindrome-partitioning
 * 给定一个字符串s，分割s使得s的每一个子串都是回文串。返回所有的回文分割结果。（注意：返回结果的顺序需要
 * 和输入字符串中的字母顺序一致。）例如:给定字符串s="aab",
 * 返回 [↵    ["aa","b"],↵    ["a","a","b"]↵  ]
 */
public class Test20 {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if(s == null || s.length() == 0)return result;
        slove(s,0,new ArrayList<String>(),result);
        return result;
    }
    public void slove(String s,int index,ArrayList<String> preList,ArrayList<ArrayList<String>> result){
        if(index == s.length()){
            result.add(new ArrayList<String>(preList));
            return;
        }
        ArrayList<String> list = new ArrayList<>(preList);
        for(int i = index ; i < s.length() ; i++){
            if(isPalindrome(s.substring(index,i+1))){
                list.add(s.substring(index,i+1));
                slove(s,i+1,list,result);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s){
        int start = 0,end = s.length() - 1;
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Test20 test20 = new Test20();
        System.out.println(test20.partition("aab"));
    }
}
