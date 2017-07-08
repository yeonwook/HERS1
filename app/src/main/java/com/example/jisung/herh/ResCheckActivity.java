package com.example.jisung.herh;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ResCheckActivity extends AppCompatActivity {

    String myJSON;

    ArrayList<Menu> alist;
    MenuAdapter m_adapter;

    CalendarView c1;
    Button resBtn,reqBtn;
    ListView listview,list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_check);
        init();

        c1 = (CalendarView)findViewById(R.id.calendarView);
        c1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                View r_view = View.inflate(view.getContext(), R.layout.r_list, null);
//                getDbData("http://jisung0920.cafe24.com/hers_reserve.php");
                final AlertDialog.Builder dialog = new AlertDialog.Builder(view.getContext());
                dialog.setView(r_view);
                listview = (ListView) r_view.findViewById(R.id.list_item);
                TextView s_date = (TextView)r_view.findViewById(R.id.textView2);
                s_date.setText(year + " . " + (month+1) + " . " + dayOfMonth);
                Button button = (Button)r_view.findViewById(R.id.button);
                button.setVisibility(View.GONE);
                m_adapter = new MenuAdapter(r_view.getContext(), alist);
                alist.add(new Menu("test","test","test"));
                listview.setAdapter(m_adapter);
                dialog.show();
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
        alist = new ArrayList<Menu>();

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
