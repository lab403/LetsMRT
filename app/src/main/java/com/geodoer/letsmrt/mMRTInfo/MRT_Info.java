package com.geodoer.letsmrt.mMRTInfo;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by fud on 2015/4/18.
 */
public class MRT_Info {
    public MRT[] mrt =new MRT[38];

    public MRT_Info(){
        mrt[0]=new MRT(101,"R3","小港","Siaogang",new LatLng(22.56481191, 120.3538521));
        mrt[1]=new MRT(102,"R4","高雄國際機場","Kaohsiung International Airport",new LatLng(22.57011232, 120.3421469));
        mrt[2]=new MRT(103,"R4A","草衙","Caoya",new LatLng(22.58035095, 120.3284408));
        mrt[3]=new MRT(104,"R5","前鎮高中","Cianjhen Senior High School",new LatLng(22.58853833, 120.3219713));
        mrt[4]=new MRT(105,"R6","凱旋","Kaisyuan",new LatLng(22.59683914, 120.3151478));
        mrt[5]=new MRT(106,"R7","獅甲","Shihjia",new LatLng(22.60583276, 120.307702));
        mrt[6]=new MRT(107,"R8","三多商圈","Sanduo Shopping District",new LatLng(22.61383541, 120.3046764));
        mrt[7]=new MRT(108,"R9","中央公園","Central Park",new LatLng(22.6245709, 120.3006424));
        mrt[8]=new MRT(109,"R10","美麗島","Formosa Boulevard",new LatLng(22.631386, 120.301951));
        mrt[9]=new MRT(110,"R11","高雄車站","Kaohsiung Main Station",new LatLng(22.63966255, 120.3027023));
        mrt[10]=new MRT(111,"R12","後驛","Houyi",new LatLng(22.64829692, 120.3033675));
        mrt[11]=new MRT(112,"R13","凹子底","Aozaidi",new LatLng(22.65718817, 120.3030886));
        mrt[12]=new MRT(113,"R14","巨蛋","Kaohsiung Arena",new LatLng(22.66657386, 120.3028955));
        mrt[13]=new MRT(114,"R15","生態園區","Ecological District",new LatLng(22.67681026, 120.3066935));
        mrt[14]=new MRT(115,"R16","左營","Zuoying",new LatLng(22.68801596, 120.3095473));
        mrt[15]=new MRT(116,"R17","世運","World Games",new LatLng(22.70217026, 120.3025307));
        mrt[16]=new MRT(117,"R18","油廠國小","Oil Refinery Elementary School",new LatLng(22.70848479, 120.3023161));
        mrt[17]=new MRT(118,"R19","楠梓加工區","Nanzih Export Processing Zone",new LatLng(22.71863888, 120.3072728));
        mrt[18]=new MRT(119,"R20","後勁","Houjing",new LatLng(22.72291407, 120.3163923));
        mrt[19]=new MRT(120,"R21","都會公園","Metropolitan Park",new LatLng(22.72932659, 120.3210486));
        mrt[20]=new MRT(121,"R22","青埔","Cingpu",new LatLng(22.74466397, 120.3177012));
        mrt[21]=new MRT(122,"R22A","橋頭糖廠","Ciaotou Sugar Refinery",new LatLng(22.75339067, 120.3146113));
        mrt[22]=new MRT(123,"R23","橋頭火車站","Ciaotou Station",new LatLng(22.76045473, 120.310985));
        mrt[23]=new MRT(124,"R24","南岡山","Gangshan South",new LatLng(22.78058, 120.30165));
        mrt[24]=new MRT(201,"O1","西子灣","Sizihwan",new LatLng(22.62154049, 120.2745284));
        mrt[25]=new MRT(202,"O2","鹽埕埔","Yanchengpu",new LatLng(22.62350135, 120.2837767));
        mrt[26]=new MRT(203,"O4","市議會","City Council",new LatLng(22.62898766, 120.2949347));
        mrt[27]=new MRT(204,"O5","美麗島(橘線)","Formosa Boulevard",new LatLng(22.631386, 120.301951));
        mrt[28]=new MRT(205,"O6","信義國小","Sinyi Elementary School",new LatLng(22.63073055, 120.3116502));
        mrt[29]=new MRT(206,"O7","文化中心","Cultual Center",new LatLng(22.63039386, 120.3174438));
        mrt[30]=new MRT(207,"O8","五塊厝","Wukuaicuo",new LatLng(22.62952241, 120.3277005));
        mrt[31]=new MRT(208,"O9","技擊館","Martial Arts Stadium",new LatLng(22.62722493,  120.3346313));
        mrt[32]=new MRT(209,"O10","衛武營","Weiwuying",new LatLng(22.62508586, 120.3410901));
        mrt[33]=new MRT(210,"O11","鳳山西站","Fongshan West",new LatLng(22.62530373, 120.3483428));
        mrt[34]=new MRT(211,"O12","鳳山","Fongshan",new LatLng(22.62597715, 120.3553595));
        mrt[35]=new MRT(212,"O13","大東","Dadong",new LatLng(22.62538296, 120.3632344));
        mrt[36]=new MRT(213,"O14","鳳山國中","Fongshan Junior High School",new LatLng(22.6248878, 120.3724827));
        mrt[37]=new MRT(214,"OT1","大寮","Daliao",new LatLng(22.62239218, 120.389799));
//        mrt[38]=new MRT(999,"O5/R10","美麗島(橘線)","Formosa Boulevard",new LatLng(22.631386, 120.301951));
    }

    public MRT getMRT(int num) {
        return mrt[num];
    }
}


