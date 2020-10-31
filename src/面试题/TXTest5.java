package 面试题;

import java.util.Scanner;

/**
 * @author 程从广
 * @Description 区间最少回文子串
 * @Date 创建于 2020/8/23 20:49
 */
public class TXTest5 {
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
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt(), end = scanner.nextInt();
            System.out.println(minCut(str.substring(start - 1, end)) + 1);
        }
    }
}

