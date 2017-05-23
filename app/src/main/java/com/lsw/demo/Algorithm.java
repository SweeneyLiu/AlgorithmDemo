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
     * 冒泡排序优化2
     * @param array
     * @return
     */
    public static int[] bubbleSort2(int[] array) {
        int temp;
        int n = array.length;
        boolean flag = false;
        for (int i = 0; i < n&&!flag; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                flag = true;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
        }
        return array;
    }

    /**
     * 冒泡排序优化3
     * 如果有100个数的数组，仅前面10个无序，后面90个都已排好序且都大于前面10个数字，
     * 那么在第一趟遍历后，最后发生交换的位置必定小于10，且这个位置之后的数据必定已经有序了，
     * 记录下这位置，第二次只要从数组头部遍历到这个位置就可以了。
     * 例：{4,5,7,1,8,9,10,11,12,13}
     * @param arr
     * @return
     */
    public static int[] bubbleSort3(int arr[])
    {
        int flag = arr.length;
        int temp;
        int n = arr.length;


        for (int i = 0; i < n && flag > 0; i++) {
            n = flag;
            flag = 0;
            for (int j = 0; j < n - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = j + 1;
                }
            }
        }

       /* while (flag > 0)
        {
            n = flag;
            flag = 0;
            for (int j = 0; j < n-1; j++)
                if (arr[j] > arr[j+1])
                {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = j+1;
                }
        }*/
        return arr;
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

    /**
     * 直接选择排序
     * @return
     */
    public static int[] Selectsort(int[] arr){
        int minIndex;
        int length = arr.length;
        for (int i = 0; i < length; i++)
        {
            int temp;
            minIndex = i; //找最小元素的位置
            for (int j = i + 1; j < length; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        return arr;
    }


    /**
     * 快速排序
     * @param arr
     */
    public static int[] quickSort(int arr[],int low,int high)
    {
        if (low < high)
        {
            int i = low, j = high, key = arr[low];
            while (i < j)
            {
                while(i < j && arr[j] >= key) // 从右向左找第一个小于key的数
                    j--;
                if(i < j)
                    arr[i++] = arr[j];

                while(i < j && arr[i] < key) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    arr[j--] = arr[i];
            }
            arr[i] = key;
            quickSort(arr, low, i - 1); // 递归调用
            quickSort(arr, i + 1, high);
        }

        return arr;
    }

}
