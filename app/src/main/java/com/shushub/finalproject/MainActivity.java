package com.shushub.finalproject;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean isCover01 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView loginImage = findViewById(R.id.login_btn);
        loginImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoginDialog();
            }
        });

        ImageView showBookListButton = findViewById(R.id.showBookList);
        showBookListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBookListMessage(v);
            }
        });
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

    public void showLoginMessage(View view) {
        // 로그인 버튼 클릭 시 토스트 메시지 표시
        Toast.makeText(this, "로그인 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
    }

    public void showBookListMessage(View view) {
        // 도서 목록 버튼 클릭 시 BookActivity로 전환
        Intent intent = new Intent(MainActivity.this,activity_book.class);
        startActivity(intent);
    }

    private void showLoginDialog() {
        // 커스텀 레이아웃 인플레이트
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.activity_login, null);

        // AlertDialog 생성
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();
        dialog.show();

        // 버튼 및 EditText 참조
        EditText usernameEditText = dialogView.findViewById(R.id.username);
        EditText passwordEditText = dialogView.findViewById(R.id.password);
        Button loginButton = dialogView.findViewById(R.id.login_button);
        Button cancelButton = dialogView.findViewById(R.id.cancel_button);

        // 로그인 버튼 클릭 리스너
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 로그인 로직 구현
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                Toast.makeText(MainActivity.this, "Username: " + username + "\nPassword: " + password, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        // 취소 버튼 클릭 리스너
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
