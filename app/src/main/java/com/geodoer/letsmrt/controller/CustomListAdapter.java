package com.geodoer.letsmrt.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.geodoer.letsmrt.R;
import com.geodoer.letsmrt.mMRTInfo.MRTArrivalTime;

import java.util.ArrayList;

/**
 * Created by fud on 2015/4/23.
 */
public class CustomListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    ArrayList<MRTArrivalTime> mList;

    public CustomListAdapter(LayoutInflater inflater,ArrayList<MRTArrivalTime> mList) {
        this.inflater = inflater;
        this.mList = mList;
    }

    public void reFresh(ArrayList<MRTArrivalTime> mList){
        this.mList =mList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList.size();
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
        textView.setText(mList.get(position).mrt.MRT_CN_STATION_NAME);
        return textView;
    }
}
