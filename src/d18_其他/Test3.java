package d18_其他;

/**
 * @author 程从广
 * @Description 找出数组中比左边所有数字都大，比右边所有数字都小的元素
 * @Date 创建于 2020/8/22 9:48
 */
public class Test3 {
    public static void getNum(int[] array , int len) {
        int[] rigntMin = new int[len];
        int rMin = array[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            if(array[i] < rMin) rMin = array[i];
            rigntMin[i] = rMin;
        }
        int l_max = array[0];
        for (int i = 1; i < len; i++) {
            if(array[i] > l_max) l_max = array[i];
            if(l_max == rigntMin[i]) System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 7, 8, 12, 10, 15};
        getNum(array,array.length);
    }
}
