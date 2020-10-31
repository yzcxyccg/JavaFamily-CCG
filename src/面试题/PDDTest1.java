package 面试题;

import java.util.Scanner;

/**
 * @author 程从广
 * @Description 拼多多面试题
 * @Date 创建于 2020/8/2 18:58
 */
public class PDDTest1 {
    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int n = scanner.nextInt();
        int huitui = 0, sign = 0;
        if(sum <= 0)return;
        for (int i = 0; i < n; i++) {
            int dup = scanner.nextInt();
            int count = sum - dup;
            if (count == 0) {
                System.out.println("paradox");
                return;
            } else if (count > 0) {
                sum = count;
            }else{
                sum = -count;
                huitui++;
            }
        }
        System.out.println(sum+" "+huitui);
    }
    public static void main(String[] args) {
        test1();
    }
}
