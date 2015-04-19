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
    Context context;

    public MRTApi(Context context,int site,MRT mrt) {
        this.context = context;
        this.site = site;
        this.mrt = mrt;
        this.getUrl = url+site;
    }


    public MRTArrivalTime jsonDecode(JsonObject result){
        JsonArray allTime = result.getAsJsonArray("MRT");
        MRTArrivalTime time = new MRTArrivalTime();

        time.setToR24ArrTime(allTime.get(0).getAsJsonObject().get("arrival").getAsInt());
        time.setNextToR24ArrTime(allTime.get(0).getAsJsonObject().get("next_arrival").getAsInt());

        time.setToR3ArrTime(allTime.get(1).getAsJsonObject().get("arrival").getAsInt());
        time.setNextToR3ArrTime(allTime.get(1).getAsJsonObject().get("next_arrival").getAsInt());

        return time;
    }

}
