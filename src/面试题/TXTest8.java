package 面试题;

import com.sun.corba.se.spi.activation.RepositoryPackage.StringSeqHelper;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Scanner;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/9/6 20:14
 */
public class TXTest8 {

    public static void sendResult(HashMap<String, Integer> map, int k) {
        ArrayList<HashMap<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.size(); j++) {
                if (map.get(j) > map.get(j + 1)) {

                }
            }
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            if (map.get(str) != null) {
                map.put(str, map.get(str) + 1);
            }else {
                map.put(str, 1);
            }
        }
        sendResult(map,k);
    }
}
