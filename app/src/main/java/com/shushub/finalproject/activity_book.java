package com.shushub.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class activity_book extends AppCompatActivity {

    private boolean isListView = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book); // activity_book 레이아웃을 설정합니다.

        ImageView viewSwitchButton = findViewById(R.id.view_switch_button);
        ImageView viewGridButton = findViewById(R.id.view_grid_button);

        // 기본 프래그먼트 설정
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new book_detail())
                .commit();

        viewSwitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isListView) {
                    viewSwitchButton.setImageResource(R.drawable.list_type12); // 클릭 시 그리드 아이콘으로 변경
                    replaceFragment(new bookSimple());
                } else {
                    viewSwitchButton.setImageResource(R.drawable.list_type22); // 클릭 시 리스트 아이콘으로 변경
                    replaceFragment(new book_detail());
                }
                isListView = !isListView;
            }
        });

        viewGridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new bookSimple());
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
