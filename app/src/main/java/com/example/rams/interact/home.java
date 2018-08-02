package com.example.rams.interact;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rams.interact.utils.FontChanger;


/**
 * A simple {@link Fragment} subclass.
 */
public class home extends Fragment {

    View rootView;
    public home() {
        // Required empty public constructor
        }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FontChanger f = new FontChanger(getActivity().getAssets(),"font/sourceSansProLight.ttf");
        f.replaceFonts((ViewGroup)this.getView());
        ((TextView)rootView.findViewById(R.id.Mission)).setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/sourceSansProSemiBold.ttf"));
        ((TextView)rootView.findViewById(R.id.VisionT)).setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/sourceSansProSemiBold.ttf"));
        ((TextView)rootView.findViewById(R.id.AboutT)).setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/sourceSansProSemiBold.ttf"));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        return rootView;
    }
}
