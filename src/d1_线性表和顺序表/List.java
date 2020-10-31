package d1_线性表和顺序表;

public interface List {
    //    1.获取线性表的长度
    int size();

    //    2.判断线性表是否为空
    boolean isEmpty();

    //    3.插入元素
    void insert(int index, Object object);

    //    4.删除元素
    void delete(int index);

    //    5.获取指定位置的元素
    Object get(int index);
}
