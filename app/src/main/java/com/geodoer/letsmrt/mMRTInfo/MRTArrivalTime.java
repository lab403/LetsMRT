package com.geodoer.letsmrt.mMRTInfo;

/**
 * Created by fud on 2015/4/19.
 */
public class MRTArrivalTime {

    public int toR24ArrTime ;
    public int nextToR24ArrTime;

    public int toR3ArrTime ;
    public int nextToR3ArrTime;

    public MRT mrt;
    public int disRank;

    public MRTArrivalTime(MRT mrt, int disRank) {
        this.mrt = mrt;
        this.disRank =disRank;
    }

    public void setToR24ArrTime(int toR24ArrTime) {
        this.toR24ArrTime = toR24ArrTime;
    }

    public void setNextToR24ArrTime(int nextToR24ArrTime) {
        this.nextToR24ArrTime = nextToR24ArrTime;
    }

    public void setToR3ArrTime(int toR3ArrTime) {
        this.toR3ArrTime = toR3ArrTime;
    }

    public void setNextToR3ArrTime(int nextToR3ArrTime) {
        this.nextToR3ArrTime = nextToR3ArrTime;
    }
}
