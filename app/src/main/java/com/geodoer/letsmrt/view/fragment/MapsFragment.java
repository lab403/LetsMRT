package com.geodoer.letsmrt.view.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.geodoer.letsmrt.R;
import com.geodoer.letsmrt.controller.mGetNowLoc;
import com.geodoer.letsmrt.view.layout.TouchableLayout;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.melnykov.fab.FloatingActionButton;
import com.melnykov.fab.ObservableScrollView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MapsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MapsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapsFragment extends Fragment{

    //TODO:設定MAP
    public GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private static MyMapView mapView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private TouchableLayout mTW;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapsFragment newInstance(String param1, String param2) {
        MapsFragment fragment = new MapsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MapsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mTW = new TouchableLayout(getActivity());
        // Inflate the layout for this fragment
        View v =
                inflater.inflate(R.layout.fragment_map,
                        container, false);
        MapsInitializer.initialize(getActivity().getApplicationContext());

        switch (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity())) {
            case ConnectionResult.SUCCESS:
//	                 Toast.makeText(getActivity(), "SUCCESS", Toast.LENGTH_SHORT).show();
                mapView = (MyMapView) v.findViewById(R.id.map);
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

        setFaBtn(v);
        mTW.addView(v);
        return mTW;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    // set a fab
    private void setFaBtn(View v){
        // set view
        ObservableScrollView mScrollView =
                (ObservableScrollView) v.findViewById(R.id.scrollViewMap);
        // check it
        if(mScrollView!=null) {
            // faBtn
            final FloatingActionButton faBtn_add
                    = (FloatingActionButton) v.findViewById(R.id.faBtn_getMyLoc);
            faBtn_add.attachToScrollView(mScrollView);
            faBtn_add.setType(FloatingActionButton.TYPE_MINI);
            faBtn_add.setColorNormalResId(R.color.md_blue_grey_50);
            faBtn_add.setColorPressedResId(R.color.md_blue_grey_200);
            faBtn_add.setColorRipple(R.color.md_blue_grey_50);
            faBtn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mGetNowLoc nowLoc = new mGetNowLoc(getActivity(),mMap);
                    nowLoc.getNowLoc("0", 0);
                }
            });
        }
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
            mGetNowLoc nowLoc = new mGetNowLoc(getActivity(),mMap);
            nowLoc.getNowLoc("0", 1);
        }

    }
}

