package 面试题;


import java.util.Arrays;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/10/15 20:34
 */
public class BossTest3 {
    public int[] calculate(int[] dataArr) {
        Arrays.sort(dataArr);
        int[] array = new int[4];
        int len = dataArr.length;
        array[0] = dataArr[len / 2 - 1];
        array[1] = dataArr[0];
        array[2] = dataArr[len - 1];
        array[3] = dataArr[len*9/10-1];
        return array;
    }
    public static void main(String[] args) {
        BossTest3 bossTest3 = new BossTest3();
        int array[] = {10,9,8,7,6,5,4,3,2,1};
        bossTest3.calculate(array);
    }
}
