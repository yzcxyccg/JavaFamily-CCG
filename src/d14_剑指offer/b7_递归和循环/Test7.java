package d14_剑指offer.b7_递归和循环;

/**
 * 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Test7 {
    public static int fibonacci1(int n) {
        int a = 0;
        int b = 1;
        while (n-- > 0) {
            b = a + b;
            a = b - a;
        }
        return a;
    }
    public static int fibonacci2(int n) {
        if(n <= 1)
            return n;
        return fibonacci2(n-1) + fibonacci2(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci1(3));
    }
}
