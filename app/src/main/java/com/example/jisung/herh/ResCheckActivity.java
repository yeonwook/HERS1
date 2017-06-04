package com.example.jisung.herh;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import java.util.ArrayList;

public class ResCheckActivity extends AppCompatActivity {

    CalendarView c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_check);
        c1 = (CalendarView)findViewById(R.id.calendarView);
        c1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Intent intent =new Intent(ResCheckActivity.this,ReserveActivity.class);
                startActivity(intent);

            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                }
        });
    }
    //sdkjfhskjdfh
}
