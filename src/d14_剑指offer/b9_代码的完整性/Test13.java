package d14_剑指offer.b9_代码的完整性;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Test13 {
    public static void reOrderArray1(int [] array) {
        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)queue1.add(array[i]);
            else
            queue2.add(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            if(queue2.size() != 0) array[i] = queue2.poll();
            else
            array[i] = queue1.poll();
        }
    }

    /**
     * 模仿快排，j=i+1,array[i]为偶数时，令j++直到array[j]为奇数，j经过的j-i个偶数依次后移，array[i]=array[j]
     * @param array
     */
    public static void reOrderArray2(int[] array) {
        int len = array.length;
        if(len<=1) return;
        for (int i = 0; i < len; i++) {
            int j = i + 1;
            if (array[i] % 2 == 0) {
                while (array[j] % 2 == 0) {
                    if(j == len-1)return;
                    j++;
                }
                int temp = array[j];
                int count = j - i;
                while (count > 0) {
                    array[i + count] = array[i + count - 1];
                    count--;
                }
                array[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int array[] = {1,5,4,7,8,1,6,9,12};
        reOrderArray2(array);
        System.out.println(Arrays.toString(array));
    }
}
