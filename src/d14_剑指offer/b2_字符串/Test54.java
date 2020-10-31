package d14_剑指offer.b2_字符串;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Test54 {
    int[] charArr = new int[128];
    Queue<Character> queue = new LinkedList<Character>();

    public void Insert(char ch) {
        if (charArr[ch]++ == 0) //新来的单身字符，入队
            queue.add(ch);
    }
    public char FirstAppearingOnce() {
        Character CHAR = null;
        while ((CHAR = queue.peek()) != null) {
            if (charArr[CHAR] == 1) //判断是否脱单了，没脱单则输出
                return CHAR;
            else queue.remove(); //脱单了就移出队列，它不会再回来了
        }
        return '#'; //队空，返回#
    }

    public static void main(String[] args) {
        Test54 test54 = new Test54();
        test54.Insert('g');
        test54.Insert('o');
        System.out.println(test54.FirstAppearingOnce());
        test54.Insert('o');
        test54.Insert('g');
        test54.Insert('l');
        System.out.println(test54.FirstAppearingOnce());
    }
}
