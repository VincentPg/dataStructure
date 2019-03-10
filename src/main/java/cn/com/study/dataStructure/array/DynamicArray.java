package cn.com.study.dataStructure.array;

import java.util.Arrays;

/**
 * 动态扩容数组：
 *  1、扩容机制:添加元素的时候进行扩容。
 *
 * 参考：java.util.ArrayList<E>
 * @param <E>
 */
public class DynamicArray<E> {
    /**
     * 数组默认初始容量
     */
    private static final int DEFAULT_CAPACITY=10;
    /**
     * 数组中元素的个数
     */
    private int size;
    /**
     * 数组
     */
    Object[] elementData;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private static final Object[] EMPTY_ELEMENTDATA = {};

    // 构建空的动态数组：1、以默认容量初始化；2、指定容量初始化。
    /**
     *
     */
    public DynamicArray() {
        this.elementData= DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
    /**
     * 以指定的容量构建动态数组
     * @param initialCapacity  指定容量
     */
    public DynamicArray(int initialCapacity) {
        if (initialCapacity>0) {
            this.elementData = new Object[initialCapacity];
        }else if(initialCapacity==0) {
            this.elementData = EMPTY_ELEMENTDATA;
        }else {
            throw new IllegalArgumentException("Illegal Capacity:"+initialCapacity);
        }
    }

    //扩容方式：1、默认追加元素；2、指定下表索引扩容
    /**
     * 追加元素
     * @param e 元素
     * @return
     */
    public boolean add(E e) {
        int maxCapaity = 0;
        //先扩容
        if (elementData ==DEFAULTCAPACITY_EMPTY_ELEMENTDATA ) {
            //比较新加元素下标和容量的大小
            maxCapaity = Math.max(DEFAULT_CAPACITY, size+1);
            //计算新的容量
            int oldCapacity = elementData.length;
            // new = old*1.5
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            // 待扩容的容量小于新加元素下标，则容量使用新加元素的下标。
            if(newCapacity-maxCapaity<0) {
                newCapacity = maxCapaity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }

        //然后追加元素，size修改
        elementData[size++]=e;
        return true;
    }

    public void add(int index,E element) {
        //范围判断，防止动态数组的元素断断续续。
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("");
        int maxCapaity = 0;
        if (elementData ==DEFAULTCAPACITY_EMPTY_ELEMENTDATA ) {
            //比较新加元素下标和容量的大小
            maxCapaity = Math.max(DEFAULT_CAPACITY, size+1);
            //计算新的容量
            int oldCapacity = elementData.length;
            // new = old*1.5
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            // 待扩容的容量小于新加元素下标，则容量使用新加元素的下标。
            if(newCapacity-maxCapaity<0) {
                newCapacity = maxCapaity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        //
        System.arraycopy(elementData, index, elementData, index+1,size-index);
        elementData[index] = element;
        size++;

    }

    public int size() {
        return size;
    }

}
