package d1_线性表和顺序表;

public class SequenceList implements List {
    //默认的顺序表的最大长度
    final int defaultSize = 10;
    //最大长度
    int maxSize;
    //当前长度
    int size;
    //对象数组
    Object[] listArray;

    public SequenceList() {
        init(defaultSize);
    }

    public SequenceList(int maxSize) {
        init(maxSize);
    }

    /**
     * 顺序表的初始化方法
     *
     * @param maxSize 初始化长度
     */
    private void init(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        listArray = new Object[maxSize];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(int index, Object object) {
        //如果当前的线性表已满，就不允许再插入数据
        if (size == maxSize) {
            throw new RuntimeException("顺序表已满，不允许插入");
        }
        //判断位置编号是否合法
        if (index < 0 || index > size) {
            throw new RuntimeException("参数错误");
        }

        for (int i = size - 1; i >= index; i--) {
            listArray[i + 1] = listArray[i];
        }
        listArray[index] = object;//将新的数据赋值到index
        size++;
    }

    @Override
    public void delete(int index) {
        //先判断顺序表是否为空
        if (isEmpty()) {
            throw new RuntimeException("顺序表为空，无法删除");
        }
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("参数错误");
        }
        //移动元素
        for (int i = index; i < size - 1; i++) {
            listArray[i] = listArray[i + 1];
        }
        size--;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("参数错误");
        }
        return listArray[index];
    }

    public static void main(String[] args) {
        SequenceList sequenceList = new SequenceList(20);

        sequenceList.insert(0, 100);
        sequenceList.insert(0, 50);
        sequenceList.insert(1, 20);
        for (int i = 0; i < sequenceList.size; i++) {
            System.out.println("第" + i + "个数为：" + sequenceList.get(i));
        }
    }
}
