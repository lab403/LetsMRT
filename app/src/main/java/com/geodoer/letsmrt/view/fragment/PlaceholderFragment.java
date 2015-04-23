package com.geodoer.letsmrt.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;
import android.widget.Toast;

import com.geodoer.letsmrt.R;
import com.geodoer.letsmrt.controller.CustomListAdapter;
import com.geodoer.letsmrt.view.MainActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.nirhart.parallaxscroll.views.ParallaxListView;
import com.yalantis.taurus.PullToRefreshView;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment
{
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    PullToRefreshView mPullToRefreshView;
    public GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private static MyMapView mapView;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceholderFragment() {
    }


    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list_main, container, false);
        mPullToRefreshView = (PullToRefreshView) rootView.findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshView.setRefreshing(false);
                    }
                }, 4000);
            }
        });
        ParallaxListView listView = (ParallaxListView) rootView.findViewById(R.id.list_view);
        CustomListAdapter adapter = new CustomListAdapter(LayoutInflater.from(getActivity()));


        MapsInitializer.initialize(getActivity().getApplicationContext());

        switch (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity())) {
            case ConnectionResult.SUCCESS:
//	                 Toast.makeText(getActivity(), "SUCCESS", Toast.LENGTH_SHORT).show();
                mapView = new MyMapView(getActivity());
//                mapView.setLayoutParams(new MapView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,320));
                AbsListView.LayoutParams a = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,700);
                mapView.setLayoutParams(a);
                mapView.onCreate(savedInstanceState);
                if (mapView != null) {
                    mapView.onResume();
                    setUpMapIfNeeded();
                }
                break;
            case ConnectionResult.SERVICE_MISSING:
//	                 Toast.makeText(getActivity(), "SERVICE MISSING", Toast.LENGTH_SHORT).show();
                break;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:
//	                 Toast.makeText(getActivity(), "UPDATE REQUIRED", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getActivity(), GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()), Toast.LENGTH_SHORT).show();
        }

//        TextView v = new TextView(getActivity());
//        v.setText("PARALLAXED");
//        v.setGravity(Gravity.CENTER);
//        v.setTextSize(40);
//        v.setHeight(200);

        listView.setDivider(null);
        listView.addParallaxedHeaderView(mapView);
        listView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));

    }

    private void setUpMapIfNeeded() {
        mMap = mapView.getMap();
        if (mMap == null) {
            Log.d("", "googleMap is null !!!!!!!!!!!!!!!");
        } else {
//            map gps不會停止Bug使用自幹的GPS成
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(false);
            mMap.getUiSettings().setZoomControlsEnabled(true);
            LatLng nowLoacation;
            nowLoacation = new LatLng(22.631386, 120.301951);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nowLoacation,
                    mMap.getMaxZoomLevel() - 8));
//            getNowLoc("0",1);
        }

    }

}