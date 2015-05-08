package com.geodoer.letsmrt.controller;

import android.content.Context;
import android.location.Location;

import com.geodoer.letsmrt.mGeoInfo.api.CurrentLocation;
import com.geodoer.letsmrt.mGeoInfo.controller.SortDisToStation;
import com.geodoer.letsmrt.mHttpPost.api.MRTApi;
import com.geodoer.letsmrt.mMRTInfo.MRTArrivalTime;
import com.geodoer.letsmrt.mMRTInfo.MRT_Dis;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

/**
 * Created by fud on 2015/4/24.
 */
public class mGetNowLoc {

    Context context;
    GoogleMap mMap;

    public mGetNowLoc(Context context,GoogleMap mMap) {
        this.context = context;
        this.mMap = mMap;
    }


//    private onGetTimeListener status =null;
//
//    public interface onGetTimeListener{
//        public void onGetTime(MRTArrivalTime MRT);
//    }
//
//    public void setOnStatusListener(onGetTimeListener l){
//        this.status = l;
//    }

    /**
     * 獲取現在距離,先使用GPS再使用網路最後才使用上次位置，獲取後關閉GPS，達到省電的效果
     * @param acc 調整精準度"１"先使用GPS，"０"直接使用網路，"-1"直接使用上次位置
     * @param who 0 定位再使用者當前的位置,1定位再最近的捷運站
     */
    public void getNowLoc(String acc, final int who){
        CurrentLocation mNowGeo = new CurrentLocation(context);
        mNowGeo.setOnLocListenerSetGps(acc, new CurrentLocation.onDistanceListener() {
            @Override
            public void onGetLatLng(Double lat, Double lng) {

                SortDisToStation mrt = new SortDisToStation(context);
                final ArrayList<MRT_Dis> allMrt= mrt.sort(lat, lng);

                if(who==0){
                    LatLng nowLoacation;
                    nowLoacation = new LatLng(lat, lng);
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(nowLoacation,
                            mMap.getMaxZoomLevel() - 8));
                }else if(who==1){
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(allMrt.get(0).mrt.LATLNG,
                            mMap.getMaxZoomLevel() - 8));
                }

                for (int i = 0; i < 5; i++) {
                    final MRTApi mrtApt = new MRTApi(context,i,allMrt.get(i).mrt.SITE_CODE,allMrt.get(i).mrt);
                    Ion.with(context)
                            .load(mrtApt.getUrl)
                            .asJsonObject()
                            .setCallback(new FutureCallback<JsonObject>() {
                                @Override
                                public void onCompleted(Exception e, JsonObject result) {
                                    if(e==null){
                                        MRTArrivalTime time = mrtApt.jsonDecode(result);
                                        if(mrtApt.disRank==0){
                                            mMap.addMarker(new MarkerOptions()
                                                    .position(mrtApt.mrt.LATLNG)
                                                    .title( "往岡山"+time.toR24ArrTime+"分鐘後到站,"+
                                                            "往小港"+time.toR3ArrTime+"分鐘後到站"))
                                                    .showInfoWindow();
                                        }else{
                                            mMap.addMarker(new MarkerOptions()
                                                    .position(mrtApt.mrt.LATLNG)
                                                    .title( "往岡山"+time.toR24ArrTime+"分鐘後到站,"+
                                                            "往小港"+time.toR3ArrTime+"分鐘後到站"));
                                        }
//                                        status.onGetTime(time);
                                    }else{
//                                        status.onGetTime(null);
                                    }
                                }
                            });
                }
            }

            @Override
            public void onGetLatLng(final Location loc) {
                mMap.setLocationSource(new LocationSource() {
                    @Override
                    public void activate(OnLocationChangedListener onLocationChangedListener) {
                        onLocationChangedListener.onLocationChanged(loc);
                    }

                    @Override
                    public void deactivate() {

                    }
                });
            }
        });
    }

}
