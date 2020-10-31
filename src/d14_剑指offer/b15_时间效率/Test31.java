package d14_剑指offer.b15_时间效率;

/**
 * 整数中出现1的次数
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class Test31 {
    public static int NumberOf1Between1AndN_Solution1(int n) {
        int count = 0;
        for (int i = n; i > 0; i--) {
            for (int j = i; j > 0; j /= 10) {
                if (j % 10 == 1) count++;
            }
        }
        return count;
    }

    /**
     * 归纳总结每一位上的1出现的次数
     * 个位：n/10 * 1+(n%10!=0 ? 1 : 0)
     * 十位：(n / 100) * 10 + (if(k > 19) 10 else if(k < 10) 0 else k - 10 + 1)
     * 百位：(n / 1000) * 100 + (if(k >199) 100 else if(k < 100) 0 else k - 100 + 1)
     *
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution2(int n) {
        if (n <= 0) return 0;
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            long driver = i * 10;
            count += (n / driver) * i + Math.min(Math.max(n % driver - i + 1, 0), i);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution2(213));
    }
}
