package com.geodoer.letsmrt.mGeoInfo.controller;

import android.content.Context;

import com.geodoer.letsmrt.mGeoInfo.api.DistanceCalculator;
import com.geodoer.letsmrt.mMRTInfo.MRT_Dis;
import com.geodoer.letsmrt.mMRTInfo.MRT_Info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Created by fud on 2015/4/19.
 */
public class SortDisToStation {
    Context context;

    public SortDisToStation(Context context) {
        this.context = context;
    }

    public ArrayList<MRT_Dis> sort(Double lat,Double lng){

        MRT_Info MRT =new MRT_Info();
        ArrayList<MRT_Dis> allMRT = new ArrayList<MRT_Dis>();

        for (int i = 0; i < MRT.mrt.length; i++) {
            Double dis = DistanceCalculator.haversine(lat, lng, MRT.getMRT(i).LATLNG.latitude, MRT.getMRT(i).LATLNG.longitude);
//            Log.e("MRT", MRT.getMRT(i).MRT_CN_STATION_NAME + " 距離：" + dis + "," + MRT.getMRT(i).MRT_EN_STATION_NAME + "," + MRT.getMRT(i).MRT_ID + "," + MRT.getMRT(i).LATLNG);
            allMRT.add(new MRT_Dis(dis,MRT.getMRT(i)));
        }
        Collections.sort(allMRT, new Comparator<MRT_Dis>() {
            @Override
            public int compare(MRT_Dis a, MRT_Dis b) {
                return a.dis > b.dis ? 1 : -1;
            }
        });
        return allMRT;
    }
}
