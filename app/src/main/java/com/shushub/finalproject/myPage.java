package com.shushub.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class myPage extends AppCompatActivity {

    private EditText nicknameEditText;
    private EditText passwordEditText;
    private EditText phoneNumberEditText;
    private EditText recipientNameEditText;
    private EditText addressEditText;
    private Button saveNicknameButton;
    private Button savePasswordButton;
    private Button savePhoneNumberButton;
    private Button saveRecipientButton;
    private Button saveAddressButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nicknameEditText = findViewById(R.id.nickname_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        phoneNumberEditText = findViewById(R.id.phone_number_edit_text);
        recipientNameEditText = findViewById(R.id.recipient_name_edit_text);
        addressEditText = findViewById(R.id.address_edit_text);
        saveNicknameButton = findViewById(R.id.save_nickname_button);
        savePasswordButton = findViewById(R.id.save_password_button);
        savePhoneNumberButton = findViewById(R.id.save_number_button);
        saveRecipientButton = findViewById(R.id.save_recipient_button);
        saveAddressButton = findViewById(R.id.save_address_button);

        TextView editInfoTextView = findViewById(R.id.edit_info_text_view);
        editInfoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNicknameButton.setVisibility(View.VISIBLE);
                savePasswordButton.setVisibility(View.VISIBLE);
                savePhoneNumberButton.setVisibility(View.VISIBLE);
            }
        });

        TextView changeAddressTextView = findViewById(R.id.change_address_text_view);
        changeAddressTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRecipientButton.setVisibility(View.VISIBLE);
                saveAddressButton.setVisibility(View.VISIBLE);
            }
        });

        saveNicknameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNickname();
            }
        });

        savePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePassword();
            }
        });

        savePhoneNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePhoneNumber();
            }
        });

        saveRecipientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRecipientInfo();
            }
        });

        saveAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAddress();
            }
        });
    }

    private void saveNickname() {
        String newNickname = nicknameEditText.getText().toString();
        if (newNickname.isEmpty()) {
            Toast.makeText(myPage.this, "닉네임을 입력해주세요", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(myPage.this, "닉네임이 변경되었습니다: " + newNickname, Toast.LENGTH_SHORT).show();
        }
    }

    private void savePassword() {
        String newPassword = passwordEditText.getText().toString();
        if (newPassword.isEmpty()) {
            Toast.makeText(myPage.this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(myPage.this, "비밀번호가 변경되었습니다", Toast.LENGTH_SHORT).show();
        }
    }

    private void savePhoneNumber() {
        String newPhoneNumber = phoneNumberEditText.getText().toString();
        if (newPhoneNumber.isEmpty()) {
            Toast.makeText(myPage.this, "연락처를 입력해주세요", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(myPage.this, "연락처가 변경되었습니다: " + newPhoneNumber, Toast.LENGTH_SHORT).show();
        }
    }

    private void saveRecipientInfo() {
        String newRecipientName = recipientNameEditText.getText().toString();
        if (newRecipientName.isEmpty()) {
            Toast.makeText(myPage.this, "수신인을 입력해주세요", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(myPage.this, "수신인이 변경되었습니다: " + newRecipientName, Toast.LENGTH_SHORT).show();
        }
    }

    private void saveAddress() {
        String newAddress = addressEditText.getText().toString();
        if (newAddress.isEmpty()) {
            Toast.makeText(myPage.this, "주소를 입력해주세요", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(myPage.this, "주소가 변경되었습니다: " + newAddress, Toast.LENGTH_SHORT).show();
        }
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
            Intent intent = new Intent(this, activity_book.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true;
        } else if (id == R.id.bucket) {
            Toast.makeText(this, "장바구니 선택됨", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, cartPage.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
