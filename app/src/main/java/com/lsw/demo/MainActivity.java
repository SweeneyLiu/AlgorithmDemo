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

        //冒泡排序2
        /*int[] bubbleArray = {4,5,7,1,21,3};
        int[] bubbleSortArray = Algorithm.bubbleSort2(bubbleArray);
        for (int i = 0; i < bubbleSortArray.length; i++) {
            Log.i(TAG, "onCreate: " +bubbleSortArray[i]);
        }*/

        //冒泡排序3
        int[] bubbleArray = {4,5,7,1,8,9,10,11,12,13};
        int[] bubbleSortArray = Algorithm.bubbleSort3(bubbleArray);
        for (int i = 0; i < bubbleSortArray.length; i++) {
            Log.i(TAG, "onCreate: " +bubbleSortArray[i]);
        }

        //插入排序测试
        /*int[] a={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        int[] insertSortArray = Algorithm.insertSort(a);
        for (int i = 0; i < insertSortArray.length; i++) {
            Log.i(TAG, "onCreate: " +insertSortArray[i]);
        }*/

        //希尔排序测试
        /*int[] a={49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
        int[] hillSortArray = Algorithm.hillSort(a);
        for (int i = 0; i < hillSortArray.length; i++) {
            Log.i(TAG, "onCreate: " +hillSortArray[i]);
        }*/

        //直接选择排序
        /*int[] a={49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
        int[] selectSortArray = Algorithm.Selectsort(a);
        for (int i = 0; i < selectSortArray.length; i++) {
            Log.i(TAG, "onCreate: " +selectSortArray[i]);
        }*/

        //快速排序
        /*int[] a={49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
        int[] quickSortArray = Algorithm.quickSort(a,0,a.length-1);
        for (int i = 0; i < quickSortArray.length; i++) {
            Log.i(TAG, "onCreate: " +quickSortArray[i]);
        }*/

        CycleDecimal.isCycleDecimal(1,3);
        CycleDecimal.isCycleDecimal(1234,9999);
        CycleDecimal.isCycleDecimal(1233,9990);
        CycleDecimal.isCycleDecimal(130,20);

        //剑指offer调用
//        int[][] arr = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        Log.i("lsw--剑指offer1--",PointToOffer.getPointToOffer().find(7,arr)+"");
//        Log.i("lsw--剑指offer2--",PointToOffer.getPointToOffer().replaceSpace(new StringBuffer("We Are Happy"));
//        Log.i("lsw--剑指offer3--",PointToOffer.getPointToOffer().printListFromTailToHead();

    }
}
