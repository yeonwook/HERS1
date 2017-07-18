package com.example.jisung.herh;


import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class User_ResActivity extends AppCompatActivity {
    String myJSON;

    ArrayList<Menu> alist;
    ListView listView;
    MenuAdapter m_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_res);
        alist = new ArrayList<Menu>();
        Intent getintent = getIntent();
        final String store = getintent.getStringExtra("store");

        CalendarView calendar = (CalendarView) findViewById(R.id.calendarView3);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                View r_view = View.inflate(view.getContext(), R.layout.r_list, null);
                getDbData("http://jisung0920.cafe24.com/hers_reserve.php");
                final AlertDialog.Builder dialog = new AlertDialog.Builder(view.getContext());
                dialog.setView(r_view);
                listView = (ListView) r_view.findViewById(R.id.list_item);
                TextView s_date = (TextView)r_view.findViewById(R.id.textView2);
                final String dateText =year + " . " + (month + 1) + " . " + dayOfMonth;
                s_date.setText(dateText);
                Button button = (Button)r_view.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent =new Intent(User_ResActivity.this,ReserveActivity.class);
                        intent.putExtra("date",dateText);
                        intent.putExtra("store",store);
                        startActivity(intent);
                    }
                });

                m_adapter = new MenuAdapter(r_view.getContext(), alist);
                alist.add(new Menu("test","test","test"));
                listView.setAdapter(m_adapter);
                dialog.show();

            }

        });
    }
    private void getDbData(String string){
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params){

                String uri = params[0];
                BufferedReader bufferedReader = null;

                try{
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    Log.d("check11","2");
                    if(con != null){
                        con.setConnectTimeout(10000);
                        con.setUseCaches(false);
                        if(con.getResponseCode() == HttpURLConnection.HTTP_OK){
                            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                            String json;
                            while((json = bufferedReader.readLine())!=null){
                                sb.append(json+ "\n");
                            }
                        }
                    }
                    return sb.toString().trim();
                }catch(Exception e){
                    return new String("Exception");
                }
            }
            protected void onPostExecute(String result){
                myJSON = result;
                Log.d("check11","3");
                showList(myJSON);

            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute(string);
    }
    protected void showList(String result){
        try{
            Log.d("check11","0");
            JSONObject jsonObj = new JSONObject(result);
            JSONArray peoples  = jsonObj.getJSONArray("response");
            Log.d("check11","1");
            for(int i = 0 ; i < peoples.length() ; i++){
                JSONObject c = peoples.getJSONObject(i);
//                String time = c.getString(TAG_TIME);
                String name = c.getString("user_name");
//                String num = c.getString(TAG_NUM);
//                Menu menu = new Menu(time, name, num);
//                alist.add(menu);
                Log.d("check11",name);
            }
        }catch (JSONException e){
            Log.d("check11","00");
            e.printStackTrace();

        }
    }
}
