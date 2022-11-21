package com.improve10x.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(this, TaskListScreenActivity.class);
            startActivity(intent);
            finish();
        },2000);
    }
}