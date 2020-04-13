package com.twj.epic.activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.twj.epic.R;

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
        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";

        Glide.with(this)
                .load(url)
                .into(imageView);

    }
}
