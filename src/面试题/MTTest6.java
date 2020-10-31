package 面试题;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/8/11 22:11
 */
public class MTTest6 {
    private static class Tree {
        ArrayList<Tree> sons;
        int id;
        boolean yellow;

        public Tree(int id, boolean yellow) {
            this.id = id;
            this.yellow = yellow;
            this.sons = new ArrayList<>();
        }

        public int calcDepth(int already, boolean initialColor) {
            int myDepth;
            if (this.yellow == initialColor) {
                myDepth = 0;
            } else
                myDepth = already;
            for (Tree son : sons) {
                myDepth += son.calcDepth(already + 1, initialColor);
            }
            return myDepth;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Tree[] trees = new Tree[n + 1];
        for (int i = 1; i <= n; i++) {
            trees[i] = new Tree(i, scanner.nextInt() != 1);
        }
        for (int i = 1; i <= n - 1; i++) {
            trees[scanner.nextInt()].sons.add(trees[i + 1]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(trees[i].calcDepth(0, trees[i].yellow)).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
