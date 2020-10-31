package d14_剑指offer.b2_字符串;


public class Test2 {
    /**
     * 字符串
     * 替换空格
     */
    public static void replaceSpace() {
        StringBuffer str = new StringBuffer("asd sdfsa sadfas");
        String s1 = str.toString().replace(" ", "%20");
        System.out.println(s1);
    }

    public static void main(String[] args) {
        replaceSpace();
    }
}
