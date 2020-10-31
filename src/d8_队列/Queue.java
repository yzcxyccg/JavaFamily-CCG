package d8_队列;

public interface Queue {
    //入队
    public void append(Object object);

    //出队
    public Object delete();

    //获得队头元素
    public Object getFront();

    // 判断队列是否为空
    public boolean isEmpty();
}
