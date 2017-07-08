package com.example.jisung.herh;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by namhyein on 2017. 5. 31..
 */

public class MenuAdapter extends BaseAdapter{
    Context context;
    ArrayList<Menu> alist;

    public MenuAdapter(Context context, ArrayList<Menu> alist) {
        this.context = context;
        this.alist = alist;
    }


    @Override
    public int getCount() {
        return alist.size();
    }

    @Override
    public Object getItem(int position) {
        return alist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("check","call");
        LayoutInflater inflater = LayoutInflater.from(context);
        Log.d("check","inflater");
        if(convertView == null)
            convertView = inflater.inflate(R.layout.r_list_item,null);
        Log.d("check","convert");
        TextView txtview = (TextView)convertView.findViewById(R.id.txt);
        txtview.setText(alist.get(position).getName());

        return convertView;
    }
}
