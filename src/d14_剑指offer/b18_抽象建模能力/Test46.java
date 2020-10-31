package d14_剑指offer.b18_抽象建模能力;

import java.util.ArrayList;

/**
 * 孩子们的游戏(圆圈中最后剩下的数)
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列
 * 唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去
 * ....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版
 */
public class Test46 {
    /**
     * 递推法
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution1(int n, int m) {
        if(n < 1 || m < 1)return -1;
        int ant = 0;
        for(int i = 2 ; i <= n ; i++){
            ant = (ant+m)%i;
        }
        return ant;
    }
    public int LastRemaining_Solution2(int n, int m) {
        if(n < 1 || m < 1)return -1;
        ArrayList<Integer> list = new ArrayList<>();
        int cur = -1;
        for(int i = 0 ; i < n ; i++){
            list.add(i);
        }
        while(list.size() > 1){
            for(int i = 0 ; i < m ; i++){
                cur++;
                if(cur == list.size())
                    cur = 0;
            }
            list.remove(cur);
            cur--;//cur指向了下一个结点 需要后退一步
        }
        return list.get(0);
    }
}
