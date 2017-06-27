package com.example.jisung.herh;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;

import java.util.ArrayList;

public class ResCheckActivity extends AppCompatActivity {

    CalendarView c1;
    Button resBtn,reqBtn;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_check);
        init();
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
    void init(){
        resBtn = (Button)findViewById(R.id.resBtn);
        reqBtn = (Button)findViewById(R.id.reqBtn);
        list = (ListView)findViewById(R.id.list1);
    }
    public void onClick(View v){
        if(v.getId()==R.id.resBtn){
            resBtn.setBackgroundResource(R.color.loginBtnOn);
            reqBtn.setBackgroundResource(R.color.loginButton);
            c1.setVisibility(View.VISIBLE);
            list.setVisibility(View.GONE);
        }
        else if(v.getId()==R.id.reqBtn){
            reqBtn.setBackgroundResource(R.color.loginBtnOn);
            resBtn.setBackgroundResource(R.color.loginButton);
            list.setVisibility(View.VISIBLE);
            c1.setVisibility(View.GONE);
        }
    }
    //sdkjfhskjdfh
}
