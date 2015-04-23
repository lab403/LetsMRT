package com.geodoer.letsmrt.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.geodoer.letsmrt.R;

/**
 * Created by fud on 2015/4/23.
 */
public class CustomListAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    public CustomListAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void reFresh(){

    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) convertView;
        if (textView == null){
            textView = (TextView) inflater.inflate(R.layout.list_item, null);
            textView.setHeight(500);
            switch (position%3) {
                case 0:
                    textView.setBackgroundResource(R.color.color1);
                    break;
                case 1:
                    textView.setBackgroundResource(R.color.color2);
                    break;
                case 2:
                    textView.setBackgroundResource(R.color.color3);
                    break;
            }
        }
        textView.setText("Item " + position);
        return textView;
    }
}
