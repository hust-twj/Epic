package com.twj.epic.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.twj.epic.hook.MyThread;
import com.twj.epic.R;

/**
 * Description ：
 * Created by Wenjing.Tang on 2020/4/11.
 */
public class ThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_thread);

        new MyThread().start();
    }
}
