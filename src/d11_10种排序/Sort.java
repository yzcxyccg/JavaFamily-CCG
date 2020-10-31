package d11_10种排序;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 十种排序
 */
public class Sort {
    /**
     * 1.冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] = array[j + 1] ^ array[j];
                    array[j + 1] = array[j + 1] ^ array[j];
                    array[j] = array[j + 1] ^ array[j];
                }
            }
        }
        return array;
    }

    /**
     * 2.选择排序
     *
     * @param array
     * @return
     */
    public static int[] selectSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * 3.插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    /**
     * 4.希尔排序 （有增量的插入排序）
     *
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current, gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                int preIndex = i - gap;
                current = array[i];
                while (preIndex >= 0 && array[preIndex] > current) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = current;
            }
            gap /= 2;
        }
        return array;
    }

    /**
     * 5.归并排序（递归）
     *
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array) {
        if (array.length < 2)
            return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        // System.out.println(Arrays.toString(merge(mergeSort(left), mergeSort(right))));
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * 将两个有序数组合成一个有序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int i = 0, j = 0, index = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }


    /**
     * 6.快速排序
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
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

    /**
     * 快速排序算法——partition
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
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

    //声明全局变量，用于记录数组array的长度；
    static int len;

    /**
     * 7.堆排序算法
     *
     * @param array
     * @return
     */
    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len < 2) return array;
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最0大值）与末位交换，然后在重新调整最大堆
        for (int i = len - 1; i > 0; i--) {
            swap(array, i, 0);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }

    /**
     * 建立最大堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        //for循环这样写会更好一点：i的左子树和右子树分别2i+1和2(i+1)
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i);
        }
    }

    /**
     * 调整使之成为最大堆
     *
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int minIndex = i;
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[minIndex])
            minIndex = i * 2 + 1;
        if (i * 2 + 2 < len && array[i * 2 + 2] > array[minIndex])
            minIndex = i * 2 + 2;
        if (minIndex != i) {
            swap(array, i, minIndex);
            adjustHeap(array, minIndex);
        }
    }

    /**
     * 8.计数排序
     *
     * @param array
     * @return
     */
    public static Integer[] countSort(Integer[] array) {
        if (array.length == 0) return array;
        int min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i])
                min = array[i];
            if (max < array[i])
                max = array[i];
        }
        int bias = 0 - min;
        int[] result = new int[max - min + 1];
        Arrays.fill(result, 0);
        for (int i = 0; i < array.length; i++) {
            result[array[i] + bias]++;
        }
        for (int i = 0, j = 0; i < array.length; i++) {
            if (result[j] != 0) {
                array[i] = j - bias;
                result[j]--;
            } else {
                j++;
                i--;
            }
        }
        return array;
    }

    /**
     * 9.桶排序(递归)
     *
     * @param array
     * @param bucketSize
     * @return
     */
//    public static ArrayList<Integer> bucketSort(ArrayList<Integer> array, int bucketSize) {
//        if (array == null || array.size() < 2) return array;
//        int min = array.get(0), max = array.get(0);
//        for (int i = 1; i < array.size(); i++) {
//            if (min > array.get(i)) min = array.get(i);
//            if (max < array.get(i)) max = array.get(i);
//        }
//        int bucketCount = (max - min) / bucketSize + 1;
//        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
//        ArrayList<Integer> resultArr = new ArrayList<>();
//        for (int i = 0; i < bucketCount; i++)
//            bucketArr.add(new ArrayList<Integer>());
//        for (int i = 0; i < array.size(); i++)
//            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
//        for (int i = 0; i < bucketCount; i++) {
//            if (bucketSize == 1) {
//                for (int j = 0; j < bucketArr.get(i).size(); j++)
//                    resultArr.add(bucketArr.get(i).get(j));
//            } else {
//                if (bucketCount == 1) bucketSize--;
//                ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
//                for (int j = 0; j < temp.size(); j++)
//                    resultArr.add(temp.get(j));
//            }
//        }
//        return resultArr;
//    }

    /**
     * 桶排序（分治--计数排序）
     *
     * @param array
     * @param bucketSize
     * @return
     */
    public static Integer[] bucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2) return array.toArray(new Integer[0]);
        int min = array.get(0), max = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (min > array.get(i)) min = array.get(i);
            if (max < array.get(i)) max = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1, index = 0;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketSize);
        Integer[] resultArr = new Integer[array.size()];
        for (int i = 0; i < bucketCount; i++)
            bucketArr.add(new ArrayList<Integer>());
        for (int i = 0; i < array.size(); i++)
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        for (int i = 0; i < bucketCount; i++) {
            Integer[] temp = countSort(bucketArr.get(i).toArray(new Integer[bucketArr.get(i).size()]));
            for (int j = 0; j < temp.length; j++) {
                resultArr[index] = temp[j];
                index++;
            }
        }
        return resultArr;
    }

    /**
     * 10.基数排序
     * @param array
     * @return
     */
    public static int[] radixSort(int[] array) {
        if (array == null || array.length < 2) return array;
        int max = array[0], maxDigit = 0;
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            bucketArr.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            int index = 0;
            for (int j = 0; j < array.length; j++)
                bucketArr.get((array[j] % mod) / div).add(array[j]);
            for (int j = 0; j < bucketArr.size(); j++) {
                for (int k = 0; k < bucketArr.get(j).size(); k++) {
                    array[index++] = bucketArr.get(j).get(k);
                }
                bucketArr.get(j).clear();
            }
        }
        return array;
    }

    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int array[] = {2, 45, 66, 7, 10, 22, 44, 55, 99, 101, 11};
        int array1[] = {4, 7, 99, 101, 55, 44, 22, 9, 1, 66, 88, 2};
        int array2[] = {5, 8, 99, 101, 55, 44, 66, 0, 1, 6, 10, 2};
        int array3[] = {2,12,16,88,5,10,34};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(45);
        list.add(66);
        list.add(7);
        list.add(10);
        list.add(22);
        list.add(44);
        list.add(55);
        list.add(99);
        list.add(101);
        list.add(11);
        list.add(11);
        list.add(11);
        Integer[] arr = (Integer[]) list.toArray(new Integer[list.size()]);
        //System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(Sort.bubbleSort(array)));
        //System.out.println(Arrays.toString(Sort.selectSort(array)));
        System.out.println(Arrays.toString(Sort.insertSort(array3)));
        //System.out.println(Arrays.toString(Sort.shellSort(array)));
        //System.out.println(Arrays.toString(Sort.mergeSort(array)));
        //System.out.println(Arrays.toString(Sort.quickSort(array, 0, array.length - 1)));
        //System.out.println(Arrays.toString(Sort.HeapSort(array)));
        //System.out.println(Arrays.toString(Sort.countSort(array)));
        //System.out.println(Arrays.toString(Sort.bucketSort(list,10)));
        //System.out.println(Sort.bucketSort(list, 2));
        //System.out.println(Arrays.toString(Sort.radixSort(array)));

    }
}
