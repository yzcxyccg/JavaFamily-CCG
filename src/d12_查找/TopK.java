package d12_查找;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 程从广
 * @Description 获取前K大的数
 * @Date 创建于 2020/8/12 9:13
 */
public class TopK {
    // 堆方法(优先队列)
    // 1.堆的性质是每次可以找出最大或最小的元素
    // 快排变形
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 34, 4, 5, 6};
        //int[] nums = getLeastNumbers(arr, 3);
        int[] nums = getLeastNumbersTwo(arr, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0)
            return new int[0];
        // 使用一个最大堆（大顶堆）
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));
        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek())
                heap.offer(e);
            // 删除堆顶最大元素
            if (heap.size() > k)
                heap.poll();
        }
        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap)
            res[j++] = e;
        Arrays.sort(res);
        return res;
    }

    public static int[] getLeastNumbersTwo(int[] arr, int k) {
        if (k == 0)
            return new int[0];
        else if (arr.length <= k)
            return arr;

        // 原地不断划分数组
        partitionArray(arr, 0, arr.length - 1, k);

        // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = arr[i];

        return res;
    }

    static void partitionArray(int[] arr, int lo, int hi, int k) {
        // 做一次 partition 操作
        int m = partition(arr, lo, hi);
        // 此时数组前 m 个数，就是最小的 m 个数
        if (k == m) return;// 正好找到最小的 k(m) 个数
        else if (k < m) partitionArray(arr, lo, m - 1, k);  // 最小的 k 个数一定在前 m 个数中，递归划分
        else partitionArray(arr, m + 1, hi, k); // 在右侧数组中寻找最小的 k-m 个数
    }

    static int partition(int[] a, int lo, int hi) {
        int midIndex = lo - 1;
        for (int i = lo; i <= hi; i++) {
            if (a[i] <= a[hi]) {
                midIndex++;
                if (midIndex < i) {
                    swap(a, i, midIndex);
                }
            }
        }
        return midIndex;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
