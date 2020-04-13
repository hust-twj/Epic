package com.twj.epic;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.taobao.android.dexposed.DexposedBridge;
import com.twj.epic.hook.ImageHook;
import com.twj.epic.hook.ThreadMethodHook;

/**
 * Description ：
 * Created by Wenjing.Tang on 2020/4/11.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

       // DexposedBridge.findAndHookMethod(Thread.class, "run", new ThreadMethodHook());

        DexposedBridge.findAndHookMethod(ImageView.class, "setImageDrawable", Drawable.class ,new ImageHook());

    }
}
