package 面试题;

import java.util.Scanner;

public class MTTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum1[] = new int[2005];
        int sum2[] = new int[2005];
        int n = scanner.nextInt() ,x = scanner.nextInt();
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int num = scanner.nextInt();
            sum1[num]++;
            ans = Math.max(ans,sum1[num]);
            sum2[num|x]++;
            ans = Math.max(ans,sum2[num]);
        }
        System.out.println(ans);
    }
}
