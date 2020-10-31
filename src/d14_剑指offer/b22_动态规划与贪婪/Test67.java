package d14_剑指offer.b22_动态规划与贪婪;

/**
 * 剪绳子
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为k[1],.
 * ..,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Test67 {
    /**
     * 递归
     *
     * @param target
     * @return
     */
    public int cutRope(int target) {
        return cutRope(target, 0);
    }

    public int cutRope(int target, int max) {
        int maxValue = max;
        for (int i = 1; i < target; ++i) {
            maxValue = Math.max(maxValue, i * cutRope(target - i, target - i));
        }
        return maxValue;
    }

    public int cutRope2(int target) {
        if (target <= 1) return 0;
        if (target == 2) return 1;
        if (target == 3) return 2;
        //数字长度
        int length = target % 3 == 0 ? target / 3 : target / 3 + 1;
        //数字后面2的个数
        int length2 = target % 3 == 0 ? 0 : 3 - target % 3;
        int result = 1;
        //算乘积
        for (int i = 0; i < length; i++) {
            result = result * (i < length - length2 ? 3 : 2);
        }
        return result;
    }

    public static void main(String[] args) {
        Test67 test67 = new Test67();
        System.out.println(test67.cutRope2(12));
    }
}
