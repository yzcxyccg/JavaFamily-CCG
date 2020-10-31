package d14_剑指offer.b1_数组;

/**
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*
 * A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... *
 * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */
public class Test51 {
    public int[] multiply1(int[] A) {
        int len = A.length;
        int result[] = new int[len];
        for(int i = 0 ; i < len ; i ++){
            result[i] = 1;
            for(int j = 0 ; j < len ; j++){
                if(j == i)continue;
                result[i] *= A[j];
            }
        }
        return result;
    }

    /**
     * 可以把B[i]=A[0]A[1]....A[i-1]A[i+1]....A[n-1]。看成A[0]A[1].....A[i-1]和A[i+1].....A[n-2]A[n-1]两部分的乘积
     * 对角三角形
     * @param A
     * @return
     */
    public int[] multiply2(int[] A) {
        int len = A.length;
        if(A == null || len <= 1)return null;
        int result[] = new int[len];
        //先计算下三角
        result[0] = 1;
        for(int i = 1 ; i < len ; i++){
            result[i] = result[i-1]*A[i-1];
        }

        int temp = 1;
        for(int i = len-1 ; i >=0 ; i--){
            result[i] = temp*result[i];
            temp *= A[i];
        }
        return result;
    }
}
