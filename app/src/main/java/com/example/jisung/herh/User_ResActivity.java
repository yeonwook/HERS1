package com.example.jisung.herh;


import android.icu.util.Calendar;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.CalendarView;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class User_ResActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_res);
        CalendarView calendar = (CalendarView)findViewById(R.id.calendarView3);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth){
                Toast.makeText(User_ResActivity.this, ""+year+"/"+(month+1)+"/"+dayOfMonth,0).show();
            }
        });
    }

}