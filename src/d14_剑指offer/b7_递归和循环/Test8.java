package d14_剑指offer.b7_递归和循环;

/**
 * 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Test8 {
    public static int jumpFloor(int target) {
        if(target <= 2) return target;
        int a = 1,b = 2;
        for (int i = 3; i <= target; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(jumpFloor(6));
    }
}
