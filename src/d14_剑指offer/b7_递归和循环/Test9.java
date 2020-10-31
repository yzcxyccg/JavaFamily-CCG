package d14_剑指offer.b7_递归和循环;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Test9 {
    public static int JumpFloorII(int target) {
        if(target <=1 )return target;
        return 2*JumpFloorII(target-1);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
    }
}
