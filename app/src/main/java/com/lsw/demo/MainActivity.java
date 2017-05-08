package com.lsw.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //二分法查找测试
//        int[] a = {1,3,5,8,11,19};
//        Log.i(TAG, "onCreate: " + Algorithm.binarySearch(a, 19));

        //冒泡排序测试
        /*int[] bubbleArray = {4,5,7,1,21,3};
        int[] bubbleSortArray = Algorithm.bubbleSort(bubbleArray);
        for (int i = 0; i < bubbleSortArray.length; i++) {
            Log.i(TAG, "onCreate: " +bubbleSortArray[i]);
        }*/

        //插入排序测试
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        int[] insertSortArray = Algorithm.insertSort(a);
        for (int i = 0; i < insertSortArray.length; i++) {
            Log.i(TAG, "onCreate: " +insertSortArray[i]);
        }
    }
}
