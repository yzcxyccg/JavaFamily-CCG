package d14_剑指offer.b16_时间空间效率的平衡;

/**
 * 一个只出现一次的字符
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 */
public class Test34 {
    public static int FirstNotRepeatingChar(String str) {
        int counts[] = new int[59];
        for(int i = 0 ; i < str.length() ; i++){
            counts[str.charAt(i)-'A']++;
        }
        for(int i = 0 ; i < str.length() ; i++){
            if(counts[str.charAt(i)-'A'] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "google";
        System.out.println(FirstNotRepeatingChar(str));

    }
}
