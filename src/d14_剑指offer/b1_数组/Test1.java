package d14_剑指offer.b1_数组;

import d12_查找.Search;
/**
 * 数组
 * 二维数组中的查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Test1 {
    /**
     * 遍历查找
     * @param target
     * @param array
     * @return
     */
    public boolean find(int target, int[][] array) {
        int x = array.length;
        int y = array[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 左下角查找
     * @param target
     * @param array
     * @return
     */
    public boolean find1(int target, int[][] array) {
        int rows = array.length;
        if (rows == 0) {
            return false;
        }
        int cols = array[0].length;
        if (cols == 0) {
            return false;
        }
        int x = rows-1;
        int y = 0;
        while (x >= 0 && y < cols) {
            if (array[x][y] > target) {
                x--;
            } else if (array[x][y] < target) {
                y++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 折半查找
     * @param target
     * @param array
     * @return
     */
    public boolean find2(int target, int[][] array) {
        int rows = array.length;
        if (rows == 0) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            int[] array1 = array[i];
            int j = Search.binarySearch(array1, target);
            System.out.println(j);
            if (j != -1 && target == array1[j]) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}};
        Test1 test1 = new Test1();
        System.out.println(test1.find2(6, array));

    }
}
