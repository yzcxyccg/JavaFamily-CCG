package 面试题;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 程从广
 * @Description 删除链表的第k个结点
 * @Date 创建于 2020/8/23 20:02
 */
public class TXTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        list.remove(m-1);
        list.stream().forEach(l->{
            System.out.print(l + " ");});
    }
}
