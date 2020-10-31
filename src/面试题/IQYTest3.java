package 面试题;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/8/23 15:51
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。2. 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class IQYTest3 {
    private static HashMap<Character, Character> MAP = new HashMap<>();
    public static String isMathch(char[] array) {
        if(array == null || array.length == 0) return "True";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            if(MAP.containsKey(ch)){
                stack.push(ch);
            }else if(MAP.containsValue(ch)){
                if (stack.isEmpty()) {
                    return "False";
                }else {
                    if (MAP.get(stack.peek()) == ch) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return "True";
        }
        return "False";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] array = str.toCharArray();
        MAP.put('(', ')');
        MAP.put('[', ']');
        MAP.put('{', '}');
        System.out.println(isMathch(array));
    }
}
