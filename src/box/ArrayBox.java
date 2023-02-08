package box;

public class ArrayBox<T> {
    /**
     * 底层代码设计一个类似数组存取的盒子。
     * 设计一个数组容器解决数组长度不可变的，使用户可以看起来是长度可变的
     * <p>
     * 使用真实空间存数据---数组；---属性
     */
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementDate;
    //设计一个属性来记录位置
    //设计一个属性来记录个数
    private int size = 0;

    //提供一个构造方法创建数组内存
    public ArrayBox() {

        elementDate = new Object[DEFAULT_CAPACITY];
    }

    //设计一个方法添加元素
    /**
     * 是否提供某些元素-------参数 存取的数据
     * 是否有返回值-----告知添加成功
     */
    public boolean add(T element) {
        //做一个判断来看是否存满
        this.ensureCapacityInternal(size+1);
        elementDate[size] = element;
        size++;
        return true;
    }

    //设计一个方法可以删除元素
    /**
     * 判断数组索引是否合理
     *参数---是否会有给予数据---传入数组
     * 返回值---删除是否成功
     *
     *      10;20;30;40;50;0 0 0 0 0  删除就是找到删除的元素的索引后面的数据前移并且去掉一个size并且删去size位置的数据
     *      删去30
     *      10；20；40；50；50 0 0 0 0 0
     *
     */
    public T remove(int index){
        this.RangeCheck(index);
        T oldValue=(T)elementDate[index];
        for (int i=index;i<size-1;i++) {
            elementDate[i] = elementDate[i+1];
        }
        size--;
        elementDate[size]=0;
        return oldValue;
    }

    private int length(){
        return elementDate.length;
    }

    public int getSize(){
        return size;
    }
    //设计方法可以获取元素
    /**
     *参数-----位置索引
     * 返回值----获取的元素
     */
    public T get(int index){
        //做一个判断来看索引是否越界
        this.RangeCheck(index);
        return (T)elementDate[index];
    }


    //当前请求的的最少数组容积minCapacity
    private void ensureCapacityInternal(int minCapacity) {
        if (elementDate.length < minCapacity) {
            //做一个扩容操作
            this.grow(minCapacity);
        }
    }

    //做一个为ensureCapacityInternal方法服务的扩容服务
    private void grow(int minCapacity) {
        int oldCapacity = elementDate.length;
        int newCapacity = (oldCapacity >> 1) + oldCapacity;
        //如果不则够用则再加一个判断
        if (minCapacity - newCapacity > 0) {
            newCapacity=minCapacity;
        }
        //开始创建数组
        elementDate=this.copyOf(elementDate,newCapacity);
    }

    //此方法创建新数组并保留旧的数组元素
    //参数------新数组值，旧数组
    //返回值-------一个全新数组
    private Object[] copyOf(Object[] oldArray, int newCapacity) {
        //将计算的数组长度赋值给新数组newArray
        Object[] newArray = new Object[newCapacity];
        //将旧数组元素放在新数组里面
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    //此方法为检查索引是否合法
    //参数-----index
    //返回值-----void
    private void RangeCheck(int index){
        if (index<0||index>=size){
            throw new BoxIndexOutOfBoundException("index:"+index+",size:"+size);
        }
    }
}










