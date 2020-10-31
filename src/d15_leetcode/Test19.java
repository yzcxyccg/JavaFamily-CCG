package d15_leetcode;

/**
 * palindrome-partitioning-ii
 * 给出一个字符串s，分割s使得分割出的每一个子串都是回文串,计算将字符串s分割成回文分割结果的最小切割数
 * 例如:给定字符串s="aab",返回1，因为回文分割结果["aa","b"]是切割一次生成的。
 */
public class Test19 {
    public static int minCut(String s) {
        if(s == null || s.length() <= 1)return 0;
        int dp[] = new int[s.length()];
        dp[0] = 0;
        for(int i = 1 ; i < s.length() ; i++){
            dp[i] = isPlalindrome(s.substring(0,i+1))?0:i;
            if(dp[i] != 0){
                for(int j = i ; j > 0 ; j--){
                    if(isPlalindrome(s.substring(j,i+1)))
                        dp[i] = Math.min(dp[i],dp[j-1]+1);
                }
            }
        }
        return dp[s.length()-1];
    }
    public  static boolean isPlalindrome(String s){
        int start = 0,end = s.length() - 1;
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minCut("ababa"));
    }
}
