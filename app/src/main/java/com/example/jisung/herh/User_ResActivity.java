package com.example.jisung.herh;


import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CalendarView;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class User_ResActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_res);


        CalendarView calendar = (CalendarView) findViewById(R.id.calendarView3);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth){
                Dialog builder = new Dialog(User_ResActivity.this);
                builder.setContentView(R.layout.r_list);
                WindowManager.LayoutParams params = builder.getWindow().getAttributes();
                params.width=1100;
                params.height=1300;
                builder.getWindow().setAttributes(params);
                builder.show();

            }}
        );
    }
}