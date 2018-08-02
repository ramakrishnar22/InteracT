package com.example.rams.interact;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rams.interact.utils.FontChanger;


/**
 * A simple {@link Fragment} subclass.
 */
public class ait_core extends Fragment {
    View rootView;

    public ait_core() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FontChanger fontChanger = new FontChanger(getActivity().getAssets(),"font/sourceSansProLight.ttf");
        fontChanger.replaceFonts((ViewGroup)this.getView());
        ((TextView)rootView.findViewById(R.id.rahulname)).setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/sourceSansProSemiBold.ttf"));
        ((TextView)rootView.findViewById(R.id.dharshname)).setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/sourceSansProSemiBold.ttf"));
        ((TextView)rootView.findViewById(R.id.sunduname)).setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/sourceSansProSemiBold.ttf"));
        ((TextView)rootView.findViewById(R.id.seeluname)).setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/sourceSansProSemiBold.ttf"));
        ((TextView)rootView.findViewById(R.id.events)).setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/sourceSansProSemiBold.ttf"));
        ((TextView)rootView.findViewById(R.id.loganame)).setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/sourceSansProSemiBold.ttf"));
        ((TextView)rootView.findViewById(R.id.priyaname)).setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/sourceSansProSemiBold.ttf"));
        ((TextView)rootView.findViewById(R.id.raviname)).setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/sourceSansProSemiBold.ttf"));
        ((TextView)rootView.findViewById(R.id.varshname)).setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/sourceSansProSemiBold.ttf"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_ait_core, container, false);

        rootView = inflater.inflate(R.layout.fragment_ait_core, container, false);
        return rootView;

    }

}
