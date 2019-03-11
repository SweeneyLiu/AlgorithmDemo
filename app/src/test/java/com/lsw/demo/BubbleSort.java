package com.lsw.demo;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sweeneyliu on 2019/3/11.
 */
public class BubbleSort {

    @Test
    public void test(){
        int[] arr = bubbleSort3(new int[]{4,5,7,1,8,9,10,11,12,13});
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private int[] bubbleSort3(int arr[])
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

        return arr;
    }

}
