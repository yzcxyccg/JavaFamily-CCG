package d14_剑指offer.b9_代码的完整性;

import static java.lang.Math.abs;

/**
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class Test12 {
    public static double Power1(double base, int exponent) {
        return Math.pow(base, exponent);
    }
    public static double Power2(double base, int exponent) {
        if (base == 0.0 && exponent == 0) throw new RuntimeException("两者不能同时为零");
        if (base == 0.0) return 0;
        if (exponent == 0) return 1;
        double sum = base;
        for (int i = 1; i < abs(exponent); i++) {
            sum *= base;
        }
        return exponent > 0 ? sum : 1 / sum;
    }

    /**
     * 二分法
     * @param base
     * @param exponent
     * @return
     * log2N
     */
    public static double Power3(double base, int exponent) {
        if (base == 0.0 && exponent == 0) throw new RuntimeException("两者不能同时为零");
        if (base == 0.0) return 0;
        if (exponent == 0) return 1;
        int flag = 1;
        if (exponent > 0)flag = 1;
        else {
            flag = 0;
            exponent = abs(exponent);
        }
        double sum;
        if (exponent % 2 == 0) {
            sum = Power3(base * base, exponent / 2);
        } else {
            sum =  Power3(base * base, exponent / 2) * base;
        }
        return flag == 1 ? sum : 1 / sum;
    }
    public static void main(String[] args) {
        System.out.println(Power3(2, 10));
    }
}
