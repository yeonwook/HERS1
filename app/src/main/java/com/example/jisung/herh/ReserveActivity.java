package com.example.jisung.herh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ReserveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);
    }
    public void onClick(View v){
        Toast.makeText(this, "예약되었습니다.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ReserveActivity.this,ResCheckActivity.class);
        startActivity(intent);
    }
}
