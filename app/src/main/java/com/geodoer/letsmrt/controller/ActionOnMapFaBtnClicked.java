package com.geodoer.letsmrt.controller;

import android.view.View;
import android.widget.Toast;

/**
 * Created by Kent on 2015/4/19.
 */
public class ActionOnMapFaBtnClicked implements View.OnClickListener{

    public ActionOnMapFaBtnClicked() {
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        //TODO:漂浮按鈕內容
        Toast.makeText(v.getContext()
                , "定位中....",
                Toast.LENGTH_SHORT).show();
    }
}
