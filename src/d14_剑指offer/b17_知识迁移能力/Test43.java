package d14_剑指offer.b17_知识迁移能力;

/**
 * 左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class Test43 {

    public String LeftRotateString(String str,int n) {
        if(str.length() < 2 || n < 1)return str;
        int len = str.length();
        n = n % len;
        char[] chars = str.toCharArray();
        for(int i = 0 ; i < n ; i++){
            char a = chars[0];
            for(int j = 0 ; j < len-1 ; j++){
                chars[j] = chars[j+1];
            }
            chars[len-1] = a;
        }
        return String.valueOf(chars);
    }
    public static void main(String[] args) {
        String string ="dfsd";
        System.out.println(string.substring(1));
    }
}
