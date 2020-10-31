package d8_队列;

public class CycleSequenceQueue implements Queue {
    static final int defaultSize = 10;//默认队列长度
    int front;//队头
    int rear;//队尾
    int count;//统计元素个数的计数器
    int maxSize;//队的最大长度
    Object[] queue;//元素数组

    public CycleSequenceQueue() {
        init(defaultSize);
    }

    public CycleSequenceQueue(int maxSize) {
        init(maxSize);
    }

    /**
     * 初始化函数
     *
     * @param maxSize 给定最大长度
     */
    public void init(int maxSize) {
        this.maxSize = maxSize;
        front = rear = 0;
        count = 0;
        queue = new Object[maxSize];
    }

    @Override
    public void append(Object object) {
        if (count > 0 && front == rear) {
            throw new RuntimeException("队列已满！");
        }
        queue[rear] = object;
        rear = (rear + 1) % maxSize;
        count++;
    }

    @Override
    public Object delete() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不可删除！");
        }
        Object object = queue[front];
        front = (front + 1) % maxSize;
        count--;
        return object;
    }

    @Override
    public Object getFront() {
        if (isEmpty()) {
            return null;
        }
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {
        CycleSequenceQueue cycleSequenceQueue = new CycleSequenceQueue();
        cycleSequenceQueue.append("a");
        cycleSequenceQueue.append("b");
        cycleSequenceQueue.append("c");
        cycleSequenceQueue.append("d");
        cycleSequenceQueue.append("e");
        cycleSequenceQueue.append("f");
        cycleSequenceQueue.append("g");

        cycleSequenceQueue.delete();
        cycleSequenceQueue.delete();

        cycleSequenceQueue.append("h");
        while (!cycleSequenceQueue.isEmpty()) {
            System.out.println(cycleSequenceQueue.delete());
        }
    }
}
