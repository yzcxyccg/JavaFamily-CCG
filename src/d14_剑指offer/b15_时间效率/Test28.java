package d14_剑指offer.b15_时间效率;

/**
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组
 * {1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Test28 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) return 0;
        int temp = array[0];
        int time = 1;
        for (int i = 1; i < array.length; i++) {
            if (time == 0) {
                temp = array[i];
                time = 1;
            } else if (temp == array[i]) {
                time++;
            } else time--;
        }
        int count = 0;
        if (time == 0) return 0;
        for (int i = 0; i < array.length; i++) {
            if (temp == array[i]) count++;
        }
        if (count > array.length / 2) return temp;
        return 0;
    }
}
