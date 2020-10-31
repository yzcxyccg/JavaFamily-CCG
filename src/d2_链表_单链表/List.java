package d2_链表_单链表;

public interface List {
    //获取线性表长度
    int size();

    //判断线性表是否为空
    boolean isEmpty();

    //插入元素
    void insert(int index, Object object);

    //删除元素
    void delete(int index);

    //获取指定位置的元素
    Object get(int index);
}
