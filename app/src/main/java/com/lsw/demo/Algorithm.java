package com.lsw.demo;

import android.util.Log;

/**
 * Created by liushuwei on 2017/4/25.
 */

public class Algorithm {


    /**
     * 数据需是有序不重复的
     * 二分法查找
     * @param array
     * @param key
     * @return
     */
    public static int binarySearch(int[] array, int key) {
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

    /**
     * 冒泡排序算法
     * @param array
     * @return
     */
    /*public static int[] bubbleSort(int[] array){
        int temp;
        int count;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    count++;
                }
            }
        }
        Log.i("lsw---", "bubbleSort: "+count);
        return array;
    }*/

    /**
     * 冒泡排序算法
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        int temp;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 插入排序算法
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {

        int temp;
        for (int i = 1; i < arr.length; i++) {
            int j;
            temp = arr[i];
            for (j = i-1; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j+1] = temp;
        }
        return arr;
    }

    /**
     * 希尔排序
     * @param arr
     * @return
     */
    public static int[] hillSort(int[] arr) {
        int i, j, gap;

        for (gap = arr.length / 2; gap > 0; gap /= 2){//步长
            for (i = 0; i < gap; i++)        //直接插入排序
            {
                for (j = i + gap; j < arr.length; j += gap)
                    if (arr[j] < arr[j - gap]) {
                        int temp = arr[j];
                        int k = j - gap;
                        while (k >= 0 && arr[k] > temp) {
                            arr[k + gap] = arr[k];
                            k -= gap;
                        }
                        arr[k + gap] = temp;
                    }
            }
        }

        return arr;
    }

}
