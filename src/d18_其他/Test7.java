package d18_其他;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/9/7 17:59
 */
public class Test7 {
    private static HashSet<String> set = new HashSet<>();
    public static void getAllOrder(char[] array, int start, int end) {
        if(start == end) {
            String arrayStr = new String(array);
            if(!set.contains(arrayStr)) {
                set.add(arrayStr);
            }
            return;
        } else {
            for(int i = start; i < end; i++) {
                swap(array, start, i);
                getAllOrder(array, start + 1, end);
                swap(array, i, start);
            }
        }
    }
    private static void swap(char[] array, int i, int j) {
        if(i == j) {
            return;
        }
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {

        String str1 = "you";
        String str2 = "I love you,ouy love me";
        String str3 = "jack";
        char[] chars = str1.toCharArray();
        getAllOrder(chars,0,chars.length);
        AtomicReference<StringBuffer> str = new AtomicReference<>(new StringBuffer(str2));
        set.stream().forEach(s->{
               str.set(new StringBuffer(str.toString().replace(s, str3)));
        });
        System.out.println(str);
    }
}
