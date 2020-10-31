package d14_剑指offer.b2_字符串;

import java.util.regex.Pattern;

/**
 * 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123",
 * "3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Test53 {
    public static boolean isNumeric1(char[] str) {
        String pattern = "^[-+]?\\d*(?:\\.\\d*)?(?:[eE][+\\-]?\\d+)?$";
        String s = new String(str);
        return Pattern.matches(pattern, s);
    }

    public boolean isNumeric2(char[] str) {
        boolean point = false, exp = false; // 标志小数点和指数
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '+' || str[i] == '-') {
                if (i + 1 == str.length || !(str[i + 1] >= '0' && str[i + 1] <= '9' || str[i + 1] == '.')) { // +-号后面必定为数字 或 后面为.（-.123 = -0.123）
                    return false;
                }
                if (!(i == 0 || str[i - 1] == 'e' || str[i - 1] == 'E')) { // +-号只出现在第一位或eE的后一位
                    return false;
                }
            } else if (str[i] == '.') {
                if (point || exp || !(i + 1 < str.length && str[i + 1] >= '0' && str[i + 1] <= '9')) { // .后面必定为数字 或为最后一位（233. = 233.0）
                    return false;
                }
                point = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                if (exp || i + 1 == str.length || !(str[i + 1] >= '0' && str[i + 1] <= '9' || str[i + 1] == '+' || str[i + 1] == '-')) { // eE后面必定为数字或+-号
                    return false;
                }
                exp = true;
            } else if (str[i] >= '0' && str[i] <= '9') {
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(isNumeric(new char[]{5,'e',2}));
        System.out.println(new Double("5e2"));
        double l = 123.45e+6;
    }
}
