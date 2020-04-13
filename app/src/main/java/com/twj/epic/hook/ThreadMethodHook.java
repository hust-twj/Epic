package com.twj.epic.hook;

import android.util.Log;

import com.taobao.android.dexposed.XC_MethodHook;

/**
 * Description ：
 * Created by Wenjing.Tang on 2020/4/11.
 */
public class ThreadMethodHook extends XC_MethodHook {

    private static final String TAG = "twj124 ThreadMethodHook";

    @Override
    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        super.beforeHookedMethod(param);
        Thread t = (Thread) param.thisObject;
        Log.e(TAG, "beforeHookedMethod  thread:" + t + ", started..");
    }

    @Override
    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        super.afterHookedMethod(param);
        Thread t = (Thread) param.thisObject;
        Log.e(TAG, " afterHookedMethod thread:" + t + ", exit..");
    }

}
