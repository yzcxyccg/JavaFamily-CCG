package 面试题;

import java.util.ArrayList;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/10/15 20:13
 */
public class BossTest2 {
    public ArrayList<String> filterWords(String context, String[] words) {
        String[] all = context.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < all.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (all[i].contains(words[j])) {
                    list.add(words[j]);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        BossTest2 bossTest2 = new BossTest2();
        String s1 = "while there is life, there is hope.";
        String[] s2 = {"hope", "here"};
        bossTest2.filterWords(s1, s2);

        System.out.println();

    }
}
