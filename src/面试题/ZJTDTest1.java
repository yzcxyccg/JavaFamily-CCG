package 面试题;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 首先输入一个字符串s
 * 接下来一行输入一个n 表示接下来有n个询问或者修改的操作。
 * 接下来有n行，每行表示一个提问或者修改的操作。
 * 如果是修改，则会先输入一个1，然后然后输入一个整数pos  和一个字符c，即将字符串中pos位置的字符替换成c
 * 如果是提问，则会先输入一个2，然后输入两个整数l r，即求s[l...r]子串中有多少个互不相同的字符
 * 输入abacaba
 * 5
 * 2 1 4
 * 1 4 b
 * 1 5 b
 * 2 4 6
 * 2 1 7
 * 输出
 * 3
 * 1
 * 2
 */
public class ZJTDTest1 {
    public int strLength(String str){
        if(str == null)return 0;
        char[]chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i < chars.length ; i++){
            set.add(chars[i]);
        }
        return set.size();
    }
    public String swap(String str,int k,char s){
        char[] chars = str.toCharArray();
        chars[k-1] = s;
        return  String.valueOf(chars);
    }
    public void input(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int n = scanner.nextInt();
        while(n-- > 0) {
            int choose = scanner.nextInt();
            if (choose == 1) {
                int index = scanner.nextInt();
                char s = scanner.next().charAt(0);
                str = swap(str,index,s);
            }
            else if(choose == 2){
                int begin = scanner.nextInt();
                int end = scanner.nextInt();
                String str1 = str.substring(begin-1,end);
                System.out.println(strLength(str1));
            }
        }
    }
    public static void main(String[] args) {
        ZJTDTest1 zjtdTest1 = new ZJTDTest1();
        zjtdTest1.input();

    }

}
