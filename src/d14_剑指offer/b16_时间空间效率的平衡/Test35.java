package d14_剑指offer.b16_时间空间效率的平衡;

/**
 * 数组中逆序对的数量
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,
 * 求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class Test35 {
    static int count = 0;

    public int InversePairs(int[] array) {
        if (array.length < 2) return 0;
        mergeSort(array, 0, array.length - 1);
        return count;
    }

    public void mergeSort(int[] array, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    public void merge(int[] array, int start, int mid, int end) {
        int[] result = new int[end - start + 1];
        for (int i = start, j = mid + 1, index = 0; index < result.length; index++) {
            if (i >= mid + 1)
                result[index] = array[j++];
            else if (j >= end + 1)
                result[index] = array[i++];
            else if (array[i] > array[j]) {
                result[index] = array[j++];
                //错误写法：count+= (mid - i + 1)%1000000007;
                count = (count + mid - i + 1) % 1000000007;
            } else
                result[index] = array[i++];
        }
        for (int i = 0; i < result.length; i++) {
            array[start + i] = result[i];
        }
    }

    public static void main(String[] args) {
        Test35 test35 = new Test35();
        int[] array = {7, 5, 6, 4};
        System.out.println(test35.InversePairs(array));
    }
}
/*
    static int count = 0;
    public int InversePairs(int [] array) {
        if(array.length < 2)return 0;
        mergeSort(array,0,array.length-1);
        return count;
    }
    public void mergeSort(int []array,int start,int end){
        if(start >= end)return;
        int mid = (start + end)/2;
        mergeSort(array,start,mid);
        mergeSort(array,mid+1,end);
        merge(array,start,mid,end);
    }
    public void merge(int[]array,int start,int mid,int end){
        int[]result = new int[end - start + 1];
        int index = 0 , i = start,j = mid+1;
        while(i <= mid && j <= end){
            if(array[i] > array[j]){
                result[index++] = array[j++];
                count = (count+mid - i + 1)%1000000007;
            }else
                result[index++] = array[i++];
        }
        while(i <= mid){
            result[index++] = array[i++];
        }
        while(j <= end){
            result[index++] = array[j++];
        }
        for(int l = 0 ; l < result.length ; l++){
            array[start+l] = result[l];
        }
    }
*/
