package d15_leetcode;

import java.util.Stack;

/**
 * evaluate-reverse-polish-notation
 * 计算逆波兰式（后缀表达式）的值
 * 运算符仅包含"+","-","*"和"/"，被操作数可能是整数或其他表达式
 */
public class Test2 {
    public static int evalRPN(String[] tokens) {
        if (tokens == null) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (t == "+" || t == "-" || t == "/" || t == "*") {
                if (stack.size() < 2) return 0;
                int a = stack.pop();
                int b = stack.pop();
                int c = 0;
                if (t == "+") c = b + a;
                if (t == "-") c = b - a;
                if (t == "/") c = b / a;
                if (t == "*") c = b * a;
                stack.push(c);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }

    /**
     * 异常处理
     * @param tokens
     * @return
     */
    public static int evalRPN1(String[] tokens) {
        if (tokens == null) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            try {
                stack.push(Integer.parseInt(t));
            } catch (Exception e) {
                if (t == "+" || t == "-" || t == "/" || t == "*") {
                    if (stack.size() < 2) return 0;
                    int a = stack.pop();
                    int b = stack.pop();
                    int c = 0;
                    if (t == "+") c = b + a;
                    if (t == "-") c = b - a;
                    if (t == "/") c = b / a;
                    if (t == "*") c = b * a;
                    stack.push(c);
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String str[] = {"0", "3", "/"};
        System.out.println(evalRPN1(str));
    }
}

