package com.geodoer.letsmrt.view.layout;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/**
 * Created by MurasakiYoru on 2015/5/9.
 * **/
 public  class TouchableLayout extends FrameLayout {
    public TouchableLayout(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //Log.wtf("HEM","!!!!!!!!!!!!!!");
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_UP:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

}