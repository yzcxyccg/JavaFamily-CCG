package d14_剑指offer.b17_知识迁移能力;

/**
 *
 * 统计一个数字在升序数组中出现的次数。
 */
public class Test37 {
    public int GetNumberOfK1(int [] array , int k) {
        if(array.length < 1)return 0;
        int count = 0;
        for(int i = 0 ; i < array.length ; i++){
            if(array[i] == k){
                count++;
                if(i+1>=array.length || array[i+1] != k){
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 二分查找
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK2(int [] array , int k) {
        int index = BinarySearch(array,k);
        int count = 0;
        if(index == -1)return 0;
        for(int i = index ; i < array.length ; i++){
            if(array[i] == k)count++;
            else break;
        }
        for(int i = index-1 ; i >= 0 ; i--){
            if(array[i] == k)count++;
            else break;
        }
        return count;
    }
    public int BinarySearch(int [] array , int k){
        int start = 0,end = array.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(array[mid] > k)
                end = mid-1;
            else if(array[mid] < k)
                start = mid+1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] array = {1,2,2,3,3,3,4,4,5,6};
        Test37 test37 = new Test37();
        System.out.println(test37.GetNumberOfK2(array,2));
    }
}
