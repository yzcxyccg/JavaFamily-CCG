package d14_剑指offer.b20_综合;

/**
 * 字符串转整数
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个
 * 合法的数值则返回0
 */
public class Test49 {
    /**
     * 捕捉异常
     *
     * @param str
     * @return
     */
    public static int StrToInt1(String str) {
        Integer res = 0;
        try {
            res = new Integer(str);
        } catch (NumberFormatException e) {

        } finally {
            return res;
        }
    }

    public static int StrToInt2(String str) {
        if (!str.matches("[1-9,+,-]\\d+")) return 0;
        int len = str.length();
        long res = 0;
        int i = len - 1;
        while (i >= 0 && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            res+=Math.pow(10,len-i-1)*(str.charAt(i)-'0');
            i--;
        }
        res = (str.charAt(0) == '-' ? -res : res);
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)res;
    }
    public static int strToInt3(String str) {
        int sign = 1;
        char[]array = str.toCharArray();
        int sum = 0;
        if(array[0] == '-'){
            sign = -1;
            array[0] = '0';
        }else if (array[0] == '+'){
            array[0] = '0';
        }
        for(int i = 0 ; i < array.length;i++){
            if(array[i] < '0' || array[i] > '9')return 0;
            sum = sum*10 +array[i]-'0';
        }
        return sum*sign;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt2("1234"));
    }
}
