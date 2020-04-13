package com.twj.epic.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.taobao.android.dexposed.DexposedBridge;
import com.twj.epic.R;
import com.twj.epic.hook.ImageHook;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Description ：
 * Created by Wenjing.Tang on 2020/4/11.
 */
public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image);

        ImageView imageView = findViewById(R.id.iv);
        imageView.setImageResource(R.drawable.image);

        final String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";


//
//        Glide.with(this)
//                .load(url)
//                .into(imageView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = getBitmap(url);

                Log.e("twj124", "bitmap 111 ：" + bitmap.getWidth() + "  " +bitmap.getHeight());

            }
        }).start();

    }

    /**通过图片url生成Bitmap对象
     * @param urlpath
     * @return Bitmap
     * 根据图片url获取图片对象
     */
    public static Bitmap getBitmap(String urlpath) {
        Bitmap map = null;
        try {
            URL url = new URL(urlpath);
            URLConnection conn = url.openConnection();
            conn.connect();
            InputStream in;
            in = conn.getInputStream();
            map = BitmapFactory.decodeStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
