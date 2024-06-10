package com.shushub.finalproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
public class activity_book extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book); // activity_book 레이아웃을 설정합니다.

        ImageView descriptionBookButton = findViewById(R.id.description_book);
        ImageView priceBookButton = findViewById(R.id.price_book);

        // 기본 프래그먼트 설정
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new bookSimple())
                .commit();

        descriptionBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new bookSimple())
                        .commit();
            }
        });

        priceBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new book_detail())
                        .commit();
            }
        });
    }
}
