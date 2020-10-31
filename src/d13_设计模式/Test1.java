package d13_设计模式;

import java.util.List;

/**
 * 单例模式
 * https://blog.csdn.net/qq_35860138/article/details/86477538九种方式非常全面
 */

/**
 * JSON解析
 * {"a": [1,2,
 * 3],  "b": "c"}
 */
public class Test1 {
    enum TokenType {
        LEFT_SQUARE_BRACKET, // [
        RIGHT_SQUARE_BRACKET, // ]
        LEFT_CURLY_BRACKET, // {
        RIGHT_CURLY_BRACKET, // }
        COMMA, // ,
        CONON, // :
        STRING, // "xxxx"，不考虑转义等
        INTEGER, // 数字，只考虑整数
    }
    class Token {
        TokenType type;
        String stringValue;
        int intValue;

        public Token(TokenType type, String stringValue, int intValue) {
            this.type = type;
            this.stringValue = stringValue;
            this.intValue = intValue;
        }
    }

    public Token pre(char ch) {

        switch (ch) {
            case '{':
                return new Token(TokenType.LEFT_CURLY_BRACKET, String.valueOf(ch), 0);
            case '}':
                return new Token(TokenType.RIGHT_CURLY_BRACKET, String.valueOf(ch), 0);
            case '[':
                return new Token(TokenType.LEFT_SQUARE_BRACKET, String.valueOf(ch), 0);
            case ']':
                return new Token(TokenType.RIGHT_SQUARE_BRACKET, String.valueOf(ch), 0);
            case ',':
                return new Token(TokenType.COMMA, String.valueOf(ch), 0);
            case ':':
                return new Token(TokenType.CONON, String.valueOf(ch), 0);
            case '"':
                return new Token(TokenType.CONON, String.valueOf(ch), 0);
        }
        return null;
    }
    List<Token> parseJson(String json) {
               for (int i = 0; i < json.length(); i++) {
            char s = json.charAt(i);


        }
        return null;
    }


    public static void main(String[] args) {

    }
}

