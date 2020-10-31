package 面试题;

/**
 * @author 程从广
 * @Description 对字符数组进行快排
 * @Date 创建于 2020/8/28 16:34
 */
public class YYTest1 {
    public static String[] quickSort(String[] array, int start, int end) {
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

    public static int partition(String[] array, int start, int end) {
        int minIndex = start - 1;
        for (int i = start; i <= end; i++) {
            if (array[i].charAt(0) <= array[end].charAt(0)) {
                minIndex++;
                if (i > minIndex){
                    String temp = array[i];
                    array[i] = array[minIndex];
                    array[minIndex] = temp;
                }
            }
        }
        return minIndex;
    }
    public  static String[] quick_sort (String[] array) {
        return quickSort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        String[] arr1 = {"nice", "try", "do"};
        String[] arr2 = quick_sort(arr1);
        System.out.println();
    }
}
