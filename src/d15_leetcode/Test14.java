package d15_leetcode;

/**
 * single-number-ii
 * 现在有一个整数类型的数组，数组中只有一个元素只出现一次，其余元素都出现三次。你需要找出只出现一次的元素
 * 注意：
 * 你需要给出一个线性时间复杂度的算法，你能在不使用额外内存空间的情况下解决这个问题么？
 */
public class Test14 {
    public int singleNumber1(int[] A) {
        int ones = 0;//记录只出现过1次的bits
        int twos = 0;//记录只出现过2次的bits
        int threes;
        for(int t : A){
            twos |= ones&t;//要在更新ones前面更新twos
            ones ^= t;
            threes = ones&twos;//ones和twos中都为1即出现了3次
            ones ^= threes;//抹去出现了3次的bits
            twos ^= threes;
        }
        return ones;
    }

    /**
     * int 4字节32位，整个数组相加后每位模3，不是0就是1，最后得出那个数是一个
     * @param A
     * @return
     */
    public int singleNumber2(int[] A) {
        if(A == null || A.length == 0)return -1;
        int result = 0;
        for(int i = 0 ; i < 32 ; i++){
            int sum = 0;
            for(int j = 0 ; j < A.length ; j++){
                sum += (A[j]>>i)&1;
            }
            result |= (sum%3)<<i;
        }
        return result;
    }

    public static void main(String[] args) {
        Test14 test14 = new Test14();
        int[] array = {1,2,1,1,4,4,4};
        System.out.println(test14.singleNumber1(array));
    }
}
