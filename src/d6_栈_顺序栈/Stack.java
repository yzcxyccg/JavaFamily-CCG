package d6_栈_顺序栈;

public interface Stack {
    //入栈
    public void push(Object object);

    //出栈
    public Object pop();

    //获取栈顶元素
    public Object getTop();

    //判断栈是否为空
    public boolean isEmpty();
}
