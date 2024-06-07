package com.shushub.finalproject;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean isCover01 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeCover(View view) { //cover 버튼 누르면 색상 변경
        ImageView imageView = findViewById(R.id.coverbtn);
        if (isCover01) {
            imageView.setImageResource(R.drawable.cover02);
        } else {
            imageView.setImageResource(R.drawable.cover01);
        }
        isCover01 = !isCover01;
    }
    public void showCustomerServiceMessage(View view) {
        // 고객센터 버튼 클릭 시 토스트 메시지 표시
        Toast.makeText(this, "고객센터버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
    }

    public void showMyPageMessage(View view) {
        // 마이페이지 버튼 클릭 시 토스트 메시지 표시
        Toast.makeText(this, "마이페이지버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
    }
    }
