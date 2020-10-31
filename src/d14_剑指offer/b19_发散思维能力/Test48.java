package d14_剑指offer.b19_发散思维能力;

/**
 * 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Test48 {
    /**
     * 普通加法	异或
     * 1 + 1 = 0	1 ^ 1 = 0(错误)
     * 1 + 0 = 1	1 ^ 0 = 1(正确)
     * 0 + 1 = 1	0 ^ 1 = 1(正确)
     * 0 + 0 = 0	0 ^ 0 = 0(正确)
     * 问题：没有采取进位操作导致运算错误
     *
     * 与运算
     * 1 & 1 = 1(进位)
     * 1 & 0 = 0(不进位)
     * 0 & 1 = 0(不进位)
     * 0 & 0 = 0(不进位)
     * @param num1
     * @param num2
     * @return
     */
    public static int Add(int num1,int num2) {
        int result = 0;
        int carry = 0;
        do{
            result = num1 ^ num2;       //不带进位的加法
            carry = (num1 & num2) << 1; //进位
            num1 = result;
            num2 = carry;
        }while(carry != 0); // 进位不为0则继续执行加法处理进位
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Add(8,10));
    }
}
