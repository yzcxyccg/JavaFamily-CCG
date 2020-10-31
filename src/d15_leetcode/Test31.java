package d15_leetcode;

import java.util.ArrayList;

/**
 * triangle
 * 给出一个三角形，计算从三角形顶部到底部的最小路径和，每一步都可以移动到下面一行相邻的数字，
 * 例如，给出的三角形如下：[↵     [2],↵    [3,4],↵   [6,5,7],↵  [4,1,8,3]↵]
 * 最小的从顶部到底部的路径和是2 + 3 + 5 + 1 = 11。注意：
 * 如果你能只用O（N）的额外的空间来完成这项工作的话，就可以得到附加分，其中N是三角形中的行总数。
 */
public class Test31 {
    /**
     * 不需要额外空间，改变了输入
     * @param triangle
     * @return
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)return 0;
        int len = triangle.size();
        for(int i = len - 2 ; i >= 0; i--){
            for(int j = 0 ; j <= i ; j++){
                int min = triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                triangle.get(i).set(j,min);
            }
        }
        return triangle.get(0).get(0);
    }

    /**
     * o(N)额外空间
     * @param triangle
     * @return
     */
    public int minimumTotal1(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)return 0;
        int len = triangle.size();
        int []arr = new int[len];
        for(int i = 0 ; i < len ; i++){
            arr[i] = triangle.get(len-1).get(i);
        }
        for(int i = len - 2 ; i >= 0 ; i--){
            for(int j = 0 ; j <= i ; j++){
                arr[j] = triangle.get(i).get(j)+Math.min(arr[j],arr[j+1]);
            }
        }
        return arr[0];
    }

    public static void main(String[] args) {
        Test31 test31 = new Test31();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(-1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(-1);
        list3.add(-3);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        System.out.println(test31.minimumTotal1(lists));

    }
}
