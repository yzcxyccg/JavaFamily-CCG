package 面试题;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/10/13 11:11
 */
public class BossTest1 {
    public static int[] quickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        int minIndex = partition(array, start, end);
        if (minIndex > start) {
            quickSort(array, start, minIndex - 1);
        }
        if (minIndex < end) {
            quickSort(array, minIndex + 1, end);
        }
        return array;
    }
    public static int partition(int[] array, int start, int end) {
        int minIndex = start - 1;
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                minIndex++;
                if (i > minIndex)
                    swap(array, i, minIndex);
            }
        }
        return minIndex;
    }
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int[] calculate(int[] dataArr) {
        dataArr = quickSort(dataArr, 0, dataArr.length - 1);
        int[] array = new int[4];
        int len = dataArr.length;
        array[0] = len % 2 == 0 ? (dataArr[len / 2] + dataArr[len / 2 - 1]) / 2 : dataArr[len / 2];
        array[1] = dataArr[0];
        array[2] = dataArr[len - 1];
        array[3] = dataArr[len*9/10-1];
        return array;
    }

    public static void main(String[] args) {
        BossTest1 bossTest1 = new BossTest1();
        int array[] = {10,9,8,7,6,5,4,3,2,1};
        bossTest1.calculate(array);
    }
}
