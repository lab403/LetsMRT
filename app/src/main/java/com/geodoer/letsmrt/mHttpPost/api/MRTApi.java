package com.geodoer.letsmrt.mHttpPost.api;

import android.content.Context;

import com.geodoer.letsmrt.mMRTInfo.MRT;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Created by fud on 2015/4/19.
 */
public class MRTApi {
    int site;
    String url = "http://data.kaohsiung.gov.tw/Opendata/MrtJsonGet.aspx?site=";
    public String getUrl;
    public MRT mrt;
    public int disRank;
    Context context;

    public MRTApi(Context context,int disRank,int site,MRT mrt) {
        this.context = context;
        this.disRank =disRank;
        this.site = site;
        this.mrt = mrt;
        this.getUrl = url+site;
    }


    public MRTArrivalTime jsonDecode(JsonObject result){
        JsonArray allTime = result.getAsJsonArray("MRT");
        MRTArrivalTime time = new MRTArrivalTime();

        try {
            time.setToR24ArrTime(Integer.parseInt(allTime.get(0).getAsJsonObject().get("arrival").getAsString()));
        }catch (Exception e){
            time.setToR24ArrTime(0);
        }

        try {
            time.setToR24ArrTime(Integer.parseInt(allTime.get(0).getAsJsonObject().get("next_arrival").getAsString()));
        }catch (Exception e){
            time.setToR24ArrTime(0);
        }


        try {
            time.setToR3ArrTime(Integer.parseInt(allTime.get(1).getAsJsonObject().get("arrival").getAsString()));
        }catch (Exception e){
            time.setToR3ArrTime(0);
        }

        try {
            time.setToR3ArrTime(Integer.parseInt(allTime.get(1).getAsJsonObject().get("next_arrival").getAsString()));
        }catch (Exception e){
            time.setToR3ArrTime(0);
        }



//        time.setNextToR24ArrTime(allTime.get(0).getAsJsonObject().get("next_arrival").getAsInt());
//        time.setToR3ArrTime(allTime.get(1).getAsJsonObject().get("arrival").getAsInt());
//        time.setNextToR3ArrTime(allTime.get(1).getAsJsonObject().get("next_arrival").getAsInt());

        return time;
    }

}
