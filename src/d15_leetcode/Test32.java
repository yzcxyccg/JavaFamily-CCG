package d15_leetcode;

import java.util.ArrayList;

/**
 * pascals-triangle-ii
 * 给出一个索引k，返回杨辉三角的第k行,例如，k=3，返回[1,3,3,1].
 * 备注：你能将你的算法优化到只使用O(k)的额外空间吗?
 */
public class Test32 {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>();
        if(rowIndex < 0)return result;
        result.add(1);
        if(rowIndex == 0)return result;
        result.add(1);
        if(rowIndex == 1)return result;
        for(int i = 2 ; i <= rowIndex ; i++){
            for(int j = i-1 ; j > 0 ; j--){
                result.set(j,result.get(j-1)+result.get(j));
            }
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args) {
        Test32 test32 = new Test32();
        System.out.println(test32.getRow(3));
    }
}
