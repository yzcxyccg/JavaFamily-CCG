package d15_leetcode;

/**
 * single-number
 * 现在有一个整数类型的数组，数组中素只有一个元素只出现一次，其余的元素都出现两次。
 * 注意：
 * 你需要给出一个线性时间复杂度的算法，你能在不使用额外内存空间的情况下解决这个问题么？
 */
public class Test15 {
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0)return -1;
        int t = A[0];
        for(int i = 1 ; i < A.length ; i++){
            t ^= A[i];
        }
        return t;
    }
}
