package com.geodoer.letsmrt.mMRTInfo;

import com.google.android.gms.maps.model.LatLng;

public class MRT{
    public int SITE_CODE;
    public String MRT_ID;
    public String MRT_CN_STATION_NAME;
    public String MRT_EN_STATION_NAME;
    public LatLng LATLNG;

    public MRT(int SITE_CODE, String MRT_ID, String MRT_CN_STATION_NAME, String MRT_EN_STATION_NAME, LatLng LATLNG) {
        this.SITE_CODE = SITE_CODE;
        this.MRT_ID = MRT_ID;
        this.MRT_CN_STATION_NAME = MRT_CN_STATION_NAME;
        this.MRT_EN_STATION_NAME = MRT_EN_STATION_NAME;
        this.LATLNG = LATLNG;
    }
}
