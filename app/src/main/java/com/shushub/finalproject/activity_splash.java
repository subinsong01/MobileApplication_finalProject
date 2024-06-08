package com.shushub.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class activity_splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 일정 시간 지연 이후 실행하기 위한 코드
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 일정 시간이 지나면 MainActivity로 이동
                Intent intent = new Intent(activity_splash.this, MainActivity.class);
                startActivity(intent);

                // 이전 키를 눌렀을 때 스플래시 스크린 화면으로 이동을 방지하기 위해
                // 이동한 다음 사용안함으로 finish 처리
                finish();
            }
        }, 2000); // 시간 2초 이후 실행
    }
}
