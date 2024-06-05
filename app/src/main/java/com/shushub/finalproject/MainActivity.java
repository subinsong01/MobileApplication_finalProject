package com.shushub.finalproject;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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

}
