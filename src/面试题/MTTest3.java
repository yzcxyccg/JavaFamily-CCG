package 面试题;

import java.util.Scanner;

/**
 * @author 程从广
 * @Description  美团考试
 * @Date 创建于 2020/8/8 16:01
 */
public class MTTest3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0D;
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            int n = scanner.nextInt();
            sum += n ;
            result += n * i;
        }
        //System.out.println(String.valueOf(result/sum).substring(0,3));
        System.out.println(Math.floor((result/sum)*10)/10);
    }
}
