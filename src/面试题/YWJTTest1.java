package 面试题;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/10/21 19:54
 */
public class YWJTTest1 {

    public static void main(String[] args) {
        String str = "aabtdddfffbbbgggaaa";
        removeMethod(str);
    }

    public static void removeMethod(String s) {

        StringBuffer bu = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                bu.append(c);
            } else {
                int number = s.indexOf(c);
                if (number == i) {
                    bu.append(c);
                }
            }
        }System.out.println( bu.toString());
    }


}
