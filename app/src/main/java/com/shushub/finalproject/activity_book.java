package com.shushub.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class activity_book extends AppCompatActivity {

    private boolean isListType1Selected = false; // 왼쪽 버튼이 선택되었는지 여부

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book); // activity_book 레이아웃을 설정합니다.

        // 툴바 설정
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView viewSwitchButton = findViewById(R.id.view_switch_button);
        ImageView detailButton = findViewById(R.id.detail_btn);

        // 기본 프래그먼트 설정
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new book_detail())
                .commit();

        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isListType1Selected) {
                    detailButton.setImageResource(R.drawable.list_type2); // 오른쪽 버튼 이미지 변경
                    viewSwitchButton.setImageResource(R.drawable.list_type12); // 왼쪽 버튼 이미지 변경
                    replaceFragment(new bookSimple()); // bookSimple 프래그먼트로 전환
                    isListType1Selected = true;
                }
            }
        });

        viewSwitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isListType1Selected) {
                    viewSwitchButton.setImageResource(R.drawable.list_type1); // 왼쪽 버튼 이미지 변경
                    detailButton.setImageResource(R.drawable.list_type12); // 오른쪽 버튼 이미지 변경
                    replaceFragment(new book_detail()); // book_detail 프래그먼트로 전환
                    isListType1Selected = false;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            Toast.makeText(this, "홈으로 선택됨", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // 현재 activity 종료
            return true;
        } else if (id == R.id.bookList) {
            Toast.makeText(this, "도서목록 선택됨", Toast.LENGTH_SHORT).show();
            replaceFragment(new bookSimple());
            return true;
        } else if (id == R.id.bucket) {
            Toast.makeText(this, "장바구니 선택됨", Toast.LENGTH_SHORT).show();
            // 장바구니 화면으로 이동하는 로직 추가
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
