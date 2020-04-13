package com.twj.epic.hook;

import android.util.Log;

/**
 * Description ：
 * Created by Wenjing.Tang on 2020/4/11.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        Log.e("twj124", "thread run: " + Thread.currentThread().getName());
    }
}