package d14_剑指offer.b7_递归和循环;

/**
 * 矩形覆盖
 * 题目描述：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Test10 {
    public int RectCover(int target) {
        if(target <= 2)return target;
        int a = 1,b = 2;
        for(int i = 3 ; i <= target ; i++){
            b = a + b;
            a = b - a;
        }
        return b;
    }
}
