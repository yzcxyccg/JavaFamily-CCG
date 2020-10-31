package d18_其他;

/**
 * @author 程从广
 * @Description 大数相加
 * @Date 创建于 2020/8/22 1:18
 */
public class Test2 {
    private int[] array;

    public Test2(String num) {
        StringBuffer sb = new StringBuffer(num);
        String str = sb.reverse().toString();
        array = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            array[i] = Integer.valueOf(str.substring(i, i + 1));
        }
    }
    public int[] instance() {
        return array;
    }

    public static String bigAdd(Test2 firstNum, Test2 secondNum) {
        String result = "";
        //判断数组是否会越界
        boolean sign = false;
        int[] arrayOne;
        int[] arrayTwo;
        int[] arrayThree = null;
        //arrayOne 会存放相加的结果
        if (firstNum.instance().length > secondNum.instance().length) {
            arrayOne = firstNum.instance();
            arrayTwo = secondNum.instance();
        } else {
            arrayOne = secondNum.instance();
            arrayTwo = firstNum.instance();
        }
        for (int i = 0; i < arrayTwo.length; i++) {
            if (arrayOne[i] + arrayTwo[i] < 10) {
                //不需要进位
                arrayOne[i] = arrayOne[i] + arrayTwo[i];
            }else{
                arrayOne[i] = arrayOne[i] + arrayTwo[i] - 10;
                if ((i + 1) < arrayOne.length) {
                    arrayOne[i + 1] = arrayOne[i+1] + 1;
                }else{
                    //当arrayOne 的长度不够时
                    sign = true;
                    arrayThree = new int[arrayOne.length + 1];
                    System.arraycopy(arrayOne, 0, arrayThree, 0, arrayOne.length);
                    arrayThree[arrayOne.length] = 1;
                }
            }
        }
        if (sign) {
            for (int i : arrayThree) {
                result += i;
            }
        }else {
            for (int i : arrayOne) {
                result += i;
            }
        }
        return new StringBuffer(result).reverse().toString();
    }

    public static void main(String[] args) {
        String str = bigAdd(new Test2("521111111111111"), new Test2("479999999999999"));
        System.out.println(str);
    }
}
