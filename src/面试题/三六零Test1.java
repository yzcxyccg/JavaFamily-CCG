package 面试题;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/8/22 19:55
 */

/**
 * 如果名字仅由大小写英文字母组成且长度不超过10，则我们认为这个名字是真实有效的，否则就判定为恶意填写问卷。
 */
public class 三六零Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            if (str.length() <= 10 && Pattern.compile("^[A-Za-z]+$").matcher(str).matches()) {
                count++;
            }
        }
        System.out.println(count);
    }
}
