package com.geodoer.letsmrt.mMRTInfo;

public class MRT_Dis{
    public double dis;
    public MRT mrt;
    public int realDis=-1;
    public int disTime=-1;

    public MRT_Dis(double dis, MRT mrt) {
        this.dis = dis;
        this.mrt = mrt;
    }

    public void setRealDis(int realDis) {
        this.realDis = realDis;
    }

    public void setDisTime(int disTime) {
        this.disTime = disTime;
    }
}
