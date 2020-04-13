package com.twj.epic.hook;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.taobao.android.dexposed.XC_MethodHook;

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
        //Log.e(TAG, " afterHookedMethod image:" + ", exit..");

        try {
            final ImageView imageView = (ImageView) param.thisObject;

            imageView.post(new Runnable() {
                @Override
                public void run() {
                    if (imageView.getWidth() > 0 && imageView.getHeight() > 0) {

                        imageView.setDrawingCacheEnabled(true);
                        Bitmap bitmap = imageView.getDrawingCache();
                        if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0 &&
                                bitmap.getWidth() > 2 * imageView.getWidth() && bitmap.getHeight() > 2 * imageView.getHeight()) {
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

                        imageView.setDrawingCacheEnabled(false);
                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "ImageHook Exception ");
        }
    }
}
