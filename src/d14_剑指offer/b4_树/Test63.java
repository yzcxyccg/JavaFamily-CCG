package d14_剑指offer.b4_树;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数
 * 个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用
 * GetMedian()方法获取当前读取数据的中位数。
 */
public class Test63 {
    int ant = 0;
    PriorityQueue<Integer> low = new PriorityQueue<>();
    PriorityQueue<Integer> high = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
    public void Insert(Integer num) {
        ant++;
        if((ant&1) == 1){
            if(!low.isEmpty() && num>low.peek()){
                low.offer(num);
                num = low.poll();
            }
            high.offer(num);
        }else{
            if(!high.isEmpty() && num < high.peek()){
                high.offer(num);
                num = high.poll();
            }
            low.offer(num);
        }
    }

    public Double GetMedian() {// 表明是偶数
        return (ant&1) == 1 ? (double)high.peek():(high.peek()+low.peek())/2.0;
    }

    public static void main(String[] args) {
        Test63 test63 = new Test63();
        test63.Insert(1);
        test63.Insert(2);
        test63.Insert(3);
        test63.Insert(4);
        test63.Insert(6);
        test63.Insert(5);
        //test63.Insert(0);
        System.out.println(test63.GetMedian());
    }
}
