package 面试题;

import java.util.Scanner;

/**
 * @author 程从广
 * @Description 快速计算出由2、3、5这三个数字组成的由小到大的第n个数，当然也包括2、3和5
 * @Date 创建于 2020/8/27 19:36
 */
public class JDTest1 {
    public static int getN(int n) {
        int count = 0,result = 2;
        while (true) {
            if(isTrue(String.valueOf(result)))count++;
            if(count == n) break;
            result++;
        }
        return result;
    }

    public static boolean isTrue(String str) {
        for(int i = 0 ; i < str.length() ; i++){

            if(str.charAt(i) == '2' || str.charAt(i) == '3' || str.charAt(i) == '5') continue;
            else return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getN(n));
    }
}
