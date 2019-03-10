package cn.com.study.dataStructure.array.test;

import cn.com.study.dataStructure.array.DynamicArray;

import java.util.ArrayList;
import java.util.List;

public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray<Integer> ad = new DynamicArray<Integer>();
        System.out.println("元素个数："+ad.size());
        ad.add(1);
        System.out.println("元素个数2："+ad.size());
    }
}
