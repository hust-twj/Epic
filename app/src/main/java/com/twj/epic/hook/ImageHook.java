package com.twj.epic.hook;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.widget.ImageView;

import com.taobao.android.dexposed.XC_MethodHook;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Description ：
 * Created by Wenjing.Tang on 2020/4/11.
 */
public class ImageHook extends XC_MethodHook {

    private static final String TAG = "twj124 ImageHook";

    @Override
    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        super.beforeHookedMethod(param);
        //  Log.e(TAG, " afterHookedMethod image:" + ", start..");
    }

    @Override
    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        super.afterHookedMethod(param);
        Log.e(TAG, " afterHookedMethod image:" + ", exit..");

        try {
            final ImageView imageView = (ImageView) param.thisObject;

            imageView.post(new Runnable() {
                @Override
                public void run() {
                    if (imageView.getWidth() > 0 && imageView.getHeight() > 0) {
                        BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();

                        Bitmap bitmaps = bitmapDrawable.getBitmap();
                        Log.e(TAG, "bitmap ：" + bitmaps.getWidth() + "  " +bitmaps.getHeight());

                        imageView.setDrawingCacheEnabled(true);
                        imageView.buildDrawingCache();
                        Bitmap bitmap = imageView.getDrawingCache();
                        if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0 &&
                                bitmap.getWidth() > 2 * 6 && bitmap.getHeight() > 2 * 6) {
                            Log.e(TAG, "bitmap图片设置过大 ：" + "控件尺寸：" + imageView.getWidth() + "--" + imageView.getHeight() +
                                    "    图片尺寸：" + bitmap.getWidth() + "--" + bitmap.getHeight());

//                            ViewParent viewParent = imageView.getParent();
//                            while (viewParent instanceof View) {
//                                Log.e(TAG, (viewParent).toString() + " \n");
//                                viewParent = ((View) viewParent).getParent();
//                            }

//                            String text = Log.getStackTraceString(new Throwable());
//                            Log.e(TAG, text);
                        }

                       // imageView.setDrawingCacheEnabled(false);
                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "ImageHook Exception ");
        }
    }


}
