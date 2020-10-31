package d9_栈和队列练习题;

/**
 * 6.斐波那契数列（递归、动态规划、循环）
 */
public class Exercises6 {
    static int count1 = 0;
    static int count2 = 0;
    static int count3 = 0;

    public static int fibonacii1(int n) {

        if (n == 1 || n == 2) {
            count1++;
            return 1;
        }
        count1++;
        return fibonacii1(n - 1) + fibonacii1(n - 2);
    }

    public static int fibonacii2(int[] a, int n) {

        if (n == 1) {
            count2++;
            return 1;
        }
        if (n == 2) {
            count2++;
            return 1;
        }
        if (a[n] > 0) {
            count2++;
            return a[n];
        }
        count2++;
        return fibonacii2(a, n - 1) + fibonacii2(a, n - 2);
    }

    public static int fibonacii3(int n) {

        if (n == 1 || n == 2) {
            count3++;
            return 1;
        }
        int pre = 1;
        int current = 1;
        int sum = 1;
        for (int i = 3; i <= n; i++) {
            count3++;
            sum = pre + current;
            pre = current;
            current = sum;
        }
        count3++;
        return sum;
    }

    public static void main(String[] args) {
        int[] a = new int[50];
        System.out.println(Exercises6.fibonacii1(30));
        System.out.println("递归执行操作数：" + count1);
        System.out.println(Exercises6.fibonacii2(a, 30));
        System.out.println("动态规划执行操作数：" + count2);
        System.out.println(Exercises6.fibonacii3(30));
        System.out.println("循环执行操作数：" + count3);
    }

}
