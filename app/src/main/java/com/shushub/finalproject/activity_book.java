package com.shushub.finalproject;

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

    private boolean isDetailView = false;

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
                detailButton.setImageResource(R.drawable.list_type12); // 이미지를 변경
                replaceFragment(new book_detail()); // book_detail 프래그먼트로 전환
                isDetailView = true;
            }
        });

        viewSwitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDetailView) {
                    viewSwitchButton.setImageResource(R.drawable.list_type22); // 클릭 시 리스트 아이콘으로 변경
                    replaceFragment(new bookSimple());
                } else {
                    viewSwitchButton.setImageResource(R.drawable.list_type2); // 클릭 시 그리드 아이콘으로 변경
                    replaceFragment(new book_detail());
                }
                isDetailView = !isDetailView;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar, menu);
        return true;
    }

/*    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.home:
                Toast.makeText(this, "홈으로 선택됨", Toast.LENGTH_SHORT).show();
                // 홈 화면으로 이동하는 로직 추가
                return true;
            case R.id.bookList:
                Toast.makeText(this, "도서목록 선택됨", Toast.LENGTH_SHORT).show();
                replaceFragment(new bookSimple());
                return true;
            case R.id.bucket:
                Toast.makeText(this, "장바구니 선택됨", Toast.LENGTH_SHORT).show();
                // 장바구니 화면으로 이동하는 로직 추가
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
