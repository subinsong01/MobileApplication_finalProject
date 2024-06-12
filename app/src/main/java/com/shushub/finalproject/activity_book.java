package com.shushub.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class activity_book extends AppCompatActivity {

    private boolean isDetailView = false;
    private boolean isSimpleView = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book); // activity_book 레이아웃을 설정합니다.

        ImageView viewSwitchButton = findViewById(R.id.view_switch_button);
        ImageView detailButton = findViewById(R.id.detail_btn);

        // 기본 프래그먼트 설정
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new book_detail())
                .commit();

        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailButton.setImageResource(R.drawable.list_type1); // 이미지를 변경
                replaceFragment(new book_detail()); // book_detail 프래그먼트로 전환
                isDetailView = true;
            }
        });

        viewSwitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDetailView) {
                    viewSwitchButton.setImageResource(R.drawable.list_type22); // 클릭 시 리스트 아이콘으로 변경
                    replaceFragment(new book_detail());
                } else {
                    viewSwitchButton.setImageResource(R.drawable.list_type2); // 클릭 시 그리드 아이콘으로 변경
                    replaceFragment(new bookSimple());
                }
                isDetailView = !isDetailView;
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
