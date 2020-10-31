package d14_剑指offer.b6_查找和排序;

/**
 * 旋转数组最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Test6 {
    public static int minNumberInRotateArray(int [] array) {
       if(array.length == 0)return 0;
       if(array.length == 1) return array[0];
        int l = 0, r = array.length - 1;
        while (array[l] == array[r]) {
            l++;
            r--;
            if(l >= r) return array[0];
        }
        while (array[l] > array[r]) {
            int mid = l + (r - l) / 2;
            if (array[mid] >= array[l]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return array[l];
    }

    public static void main(String[] args) {
        int[] array = {3,3,3,3,3,1,2};
        System.out.println(minNumberInRotateArray(array));
    }
}
