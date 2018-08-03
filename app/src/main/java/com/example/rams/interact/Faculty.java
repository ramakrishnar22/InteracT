package com.example.rams.interact;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rams.interact.utils.FontChanger;

public class Faculty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        FontChanger fontChanger = new FontChanger(getAssets(),"font/sourceSansProRegular.ttf");
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));
        Typeface bold = Typeface.createFromAsset(getAssets(),"font/sourceSansProSemiBold.ttf");
        ((TextView)findViewById(R.id.associatepro)).setTypeface(bold);
        ((TextView)findViewById(R.id.asstpro)).setTypeface(bold);
    }
}
