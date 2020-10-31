package 面试题;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/8/23 15:37
 */
import java.util.HashSet;
import java.util.Scanner;

/**
 * 其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。机器人从二维平
 * 面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。如果路径在任何位置上出现相交的情况，也就是走到之前已经
 * 走过的位置，请返回 True ；否则，返回 False 。
 */
public class IQYTest2 {
    public static String getResult(char[] array) {
        if(array == null) return "False";
        HashSet<String> set = new HashSet<>();
        int x = 0, y = 0;
        set.add(x + "," + y);
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 'N')y++;
            else if(array[i] == 'S') y--;
            else if(array[i] == 'E') x++;
            else if(array[i] == 'W') x--;
            if(!set.add(x+","+y))return "True";
        }
        return "False";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] array = str.toCharArray();
        System.out.println(getResult(array));
    }
}
