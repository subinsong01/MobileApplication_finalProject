package com.shushub.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class customer_service extends AppCompatActivity {

    private EditText queryEditText;
    private LinearLayout textContainer;
    private List<TextView> textViewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerservice);

        // Toolbar 설정
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        queryEditText = findViewById(R.id.query_edit_text);
        Button submitButton = findViewById(R.id.submit_button);
        Button removeButton = findViewById(R.id.remove_button);
        textContainer = findViewById(R.id.text_container);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addQueryToContainer();
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLastQueryFromContainer();
            }
        });
    }


    private void addQueryToContainer() {
        String query = queryEditText.getText().toString();
        if (query.isEmpty()) {
            Toast.makeText(customer_service.this, "문의사항을 입력해주세요", Toast.LENGTH_SHORT).show();
        } else {
            // 새로운 TextView 생성 및 설정
            TextView textView = new TextView(this);
            textView.setText(query);
            textView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            textView.setPadding(16, 16, 16, 16);

            // textContainer에 TextView 추가
            textContainer.addView(textView);
            textViewList.add(textView);

            // EditText 초기화
            queryEditText.setText("");
        }
    }

    private void removeLastQueryFromContainer() {
        if (!textViewList.isEmpty()) {
            // 마지막 TextView를 리스트와 레이아웃에서 제거
            TextView lastTextView = textViewList.remove(textViewList.size() - 1);
            textContainer.removeView(lastTextView);
        } else {
            Toast.makeText(customer_service.this, "삭제할 문의사항이 없습니다", Toast.LENGTH_SHORT).show();
        }
    }
}
