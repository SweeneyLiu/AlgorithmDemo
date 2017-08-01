package com.lsw.demo;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/1 0001.
 */

public class CycleDecimal {

    public static void isCycleDecimal(int a,int b){
            List t1 = new ArrayList();  //商
            List t2 = new ArrayList();  //余数

            int p = - 1;//循环节的起始位置
            while(true){

                t1.add(a/b);
                int x = a % b;
                if(x == 0) break;

                p = t2.indexOf(x);

                if(p >= 0){
                    break;
                }else{
                    t2.add(x);
                }
                a = x*10;
            }
            //System.out.println(t1.size());
            Log.i("lsw---",t1.get(0)+".");

            for(int i = 1; i < t1.size();i++){
                if(i == p + 1)Log.i("lsw---","[");
                System.out.print(t1.get(i));
            }
            if(p >= 0)
                Log.i("lsw---","]");
    }

}
