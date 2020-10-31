package 面试题;

/**
 * @author 程从广
 * @Description 两个数组合并之后升序排列
 * @Date 创建于 2020/8/28 16:34
 */
public class YYTest2 {
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
                if (i > minIndex) {
                    array[i] = array[i] ^ array[minIndex];
                    array[minIndex] = array[i] ^ array[minIndex];
                    array[i] = array[i] ^ array[minIndex];
                }
            }
        }
        return minIndex;
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int index = 0;
        for (int i = 0 ; i < left.length ; i++) {
            result[index++] = left[i];
        }
        for (int i = 0 ; i < right.length ; i++) {
            result[index++] = right[i];
        }
        return quickSort(result, 0, result.length - 1);

    }

    public static void main(String[] args) {
        int[] one = {3,1,2,5};
        int[] two = {2,5,4,4};
        int[] result = merge(one, two);
        System.out.println();
    }
}
