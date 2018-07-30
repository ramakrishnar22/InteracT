package com.example.rams.interact;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rams.interact.utils.FontChanger;


/**
 * A simple {@link Fragment} subclass.
 */
public class home extends Fragment {


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
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        return rootView;
    }
}
