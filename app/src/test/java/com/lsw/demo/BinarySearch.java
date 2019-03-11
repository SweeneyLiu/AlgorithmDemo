package com.lsw.demo;

import org.junit.Test;

/**
 * Created by sweeneyliu on 2019/3/11.
 */
public class BinarySearch {

    @Test
    public void test(){
        int[] arr = new int[]{4,5,7,1,8,9,10,11,12,13};
        System.out.print(binarySearch(arr,6));
    }

    private int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key < array[mid]) {
                high = mid - 1;
            } else if (key == array[mid]) {
                return mid;
            } else if (key > array[mid]) {
                low = mid + 1;
            }
        }
        return -1;//没找到对应的值
    }
}
