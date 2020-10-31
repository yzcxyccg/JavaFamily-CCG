package d14_剑指offer.b2_字符串;

/**
 * 正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面
 * 的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，
 * 字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Test52 {

    public boolean matchStr(char[] str, int i, char[] pattern, int j) {
        //字符串和模式串都为空
        if (str.length == i && pattern.length == j) return true;
        //字符串不为空，模式串为空
        if (i < str.length && pattern.length == j) return false;
        //模式串下一个字符是否为空
        boolean next = (j + 1 < pattern.length && pattern[j + 1] == '*');
        if (next) {
            if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.'))
                return matchStr(str, i + 1, pattern, j) || matchStr(str, i, pattern, j + 2);
            return matchStr(str, i, pattern, j + 2);
        } else {
            if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.'))
                return matchStr(str, i + 1, pattern, j + 1);
            return false;
        }
    }

    public boolean match(char[] str, char[] pattern) {
        return matchStr(str, 0, pattern, 0);
    }

    public static void main(String[] args) {
        Test52 test52 = new Test52();
        System.out.println(test52.match(new char[]{'a', 'a', 'a', 'b'}, new char[]{'a', '*', 'a', 'b'}));
    }
}
