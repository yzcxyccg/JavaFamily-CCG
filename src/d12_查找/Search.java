package d12_查找;

import d11_10种排序.Sort;

import java.util.Arrays;
import java.util.HashMap;

public class Search {
    /**
     * 二分查找
     * @param array
     * @param key
     * @return
     */
    public static int binarySearch(int[] array, int key) {
        int begin = 0, end = array.length - 1;
        Sort.quickSort(array, 0, end);
        while (begin <= end) {
            int mid = (end + begin) / 2;
            int nows = array[mid];
            if (nows == key) {
                return mid;
            } else if (nows < key)
                begin = mid + 1;
            else if(nows > key)
                end = mid - 1;
        }
        return -1;
    }

    /**
     * 哈希查找
     * @param array
     * @param key
     * @return
     */
    public static int hashSearch(int[] array, int key) {
        if(array == null || array.length < 1) return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        int index = map.get(key);
        if(index != 0)
            return index;
        return -1;
    }
    public static void main(String[] args) {
        int array[] = {2, 45, 66, 7, 10, 22, 44, 55, 99, 101, 11,11};
        //System.out.println(Arrays.toString(Sort.quickSort(array,0,array.length-1)));
        //System.out.println(binarySearch(array,99)+1);
        System.out.println(hashSearch(array,11)+1);
    }
//    int pLen = p.length;
//    int[] next = new int[pLen];
//    int k = -1;
//    int j = 0;
//    next[0] = -1; // next数组中next[0]为-1
//        while (j < pLen - 1) {
//        if (k == -1 || p[j] == p[k]) {
//            k++;
//            j++;
//            // 修改next数组求法
//            if (p[j] != p[k]) {
//                next[j] = k;// KMPStringMatcher中只有这一行
//            } else {
//                // 不能出现p[j] = p[next[j]],所以如果出现这种情况则继续递归,如 k = next[k],
//                // k = next[[next[k]]
//                next[j] = next[k];
//            }
//        } else {
//            k = next[k];
//        }
//    }
//        return next;
//}
//    public static int indexOf(String source, String pattern) {
//        int i = 0, j = 0;
//        char[] src = source.toCharArray();
//        char[] ptn = pattern.toCharArray();
//        int sLen = src.length;
//        int pLen = ptn.length;
//        int[] next = getNext(ptn);
//        while (i < sLen && j < pLen) {
//            // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
//            if (j == -1 || src[i] == ptn[j]) {
//                i++;
//                j++;
//            } else {
//                // 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
//                j = next[j];
//            }
//        }
//        if (j == pLen)
//            return i - j;
//        return -1;
//    }
}
