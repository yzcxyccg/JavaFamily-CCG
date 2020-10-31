package 面试题;

import d5_链表练习题.LinkList;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/8/23 20:12
 */
public class TXTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int j = scanner.nextInt();
            if((m-1) == i)continue;
            System.out.print(j+" ");
        }
    }
}
