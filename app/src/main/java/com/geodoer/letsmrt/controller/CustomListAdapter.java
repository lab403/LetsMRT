package com.geodoer.letsmrt.controller;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
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
        this.mList = mList;
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

        View view;
        if(convertView == null) {
            view = inflater.inflate(R.layout.list_item2, parent, false);
            TextView textView = (TextView) view.findViewById(R.id.MRTName);
            TextView textView2 = (TextView) view.findViewById(R.id.MRTArrTime);
//            textView.setHeight(500);
            switch (position%2) {
                case 0:
                    textView.setBackgroundResource(R.color.color1);
                    textView2.setBackgroundResource(R.color.color1);
                    break;
                case 1:
                    textView.setBackgroundResource(R.color.color2);
                    textView2.setBackgroundResource(R.color.color2);
                    break;
//                case 2:
//                    textView.setBackgroundResource(R.color.color3);
//                    textView2.setBackgroundResource(R.color.color3);
//                    break;
            }
            textView.setText(mList.get(position).mrt.MRT_CN_STATION_NAME);
            if(mList.get(position).mrt.SITE_CODE<200){
                textView2.setText("往岡山 "+mList.get(position).toR24ArrTime+" 分鐘內到站，下一班 "+ mList.get(position).nextToR24ArrTime+" 分鐘內到站\n"+
                        "往小港 "+mList.get(position).toR3ArrTime+" 分鐘內到站，下一班 "+ mList.get(position).nextToR3ArrTime+" 分鐘內到站");
            }else{
                textView2.setText("往大寮 "+mList.get(position).toR24ArrTime+" 分鐘內到站，下一班 "+ mList.get(position).nextToR24ArrTime+" 分鐘內到站\n"+
                        "往西子灣 "+mList.get(position).toR3ArrTime+" 分鐘內到站，下一班 "+ mList.get(position).nextToR3ArrTime+" 分鐘內到站");
            }
        } else {
            view = convertView;
        }

        return view;


//        TextView textView = (TextView) convertView;
//        TextView textView2 = (TextView) convertView;
//        if (textView == null){
//            View view = inflater.inflate(R.layout.list_item2, null);
//            textView = (TextView) view.findViewById(R.id.MRTName);
//            textView2 = (TextView) view.findViewById(R.id.MRTArrTime);
//            textView.setHeight(500);
//            switch (position%3) {
//                case 0:
//                    textView.setBackgroundResource(R.color.color1);
//                    break;
//                case 1:
//                    textView.setBackgroundResource(R.color.color2);
//                    break;
//                case 2:
//                    textView.setBackgroundResource(R.color.color3);
//                    break;
//            }
//        }
//        textView.setText(mList.get(position).mrt.MRT_CN_STATION_NAME);
//        textView2.setText("往岡山"+mList.get(position).toR24ArrTime+"分鐘內到站,下一班"+ mList.get(position).nextToR24ArrTime+"分鐘內到站\n"+
//                "往小港"+mList.get(position).toR3ArrTime+"分鐘內到站,下一班"+ mList.get(position).nextToR3ArrTime+"分鐘內到站");
//        return textView;
    }
}
