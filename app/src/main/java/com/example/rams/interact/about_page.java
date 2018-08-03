package com.example.rams.interact;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rams.interact.utils.FontChanger;

public class about_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);
        View syed = (View)findViewById(R.id.syed);
        View sai = (View)findViewById(R.id.sai);
        View rama = (View)findViewById(R.id.rama);
        View sangeeth = (View)findViewById(R.id.sangeeth);
        FontChanger fontChanger = new FontChanger(getAssets(),"font/sourceSansProLight.ttf");
        fontChanger.replaceFonts((ViewGroup)findViewById(android.R.id.content));
        Typeface bold = Typeface.createFromAsset(getAssets(),"font/sourceSansProSemiBold.ttf");
        ((TextView)findViewById(R.id.about)).setTypeface(bold);
        ((TextView)syed.findViewById(R.id.devname)).setText("Syed Shahinsha");
        ((TextView)syed.findViewById(R.id.devname)).setTypeface(bold);
        ((TextView)sai.findViewById(R.id.devname)).setText("Sairam Harikrishnan");
        ((TextView)sai.findViewById(R.id.devname)).setTypeface(bold);
        ((TextView)rama.findViewById(R.id.devname)).setText("Ramakrishnar Mutthaiah");
        ((TextView)rama.findViewById(R.id.devname)).setTypeface(bold);
        ((TextView)sangeeth.findViewById(R.id.devname)).setText("Sangeeth Shravan");
        ((TextView)sangeeth.findViewById(R.id.devname)).setTypeface(bold);
        ((TextView)syed.findViewById(R.id.mail)).setText("syedshahinsha@gmail.com");
        ((TextView)syed.findViewById(R.id.phno)).setText("+919500308703");
        ((TextView)sai.findViewById(R.id.mail)).setText("sairamhari98@gmail.com");
        ((TextView)sai.findViewById(R.id.phno)).setText("+919789917857");
        ((TextView)rama.findViewById(R.id.mail)).setText("ramaaravind22@gmail.com");
        ((TextView)rama.findViewById(R.id.phno)).setText("+919629567070");
        ((TextView)sangeeth.findViewById(R.id.mail)).setText("sangeeth209@gmail.com");
        ((TextView)sangeeth.findViewById(R.id.phno)).setText("+919597398745");
        ((ImageView)sangeeth.findViewById(R.id.devdp)).setImageResource(R.drawable.sange);
        ((ImageView)sangeeth.findViewById(R.id.devdp)).setImageResource(R.drawable.sange);
        ((ImageView)sai.findViewById(R.id.devdp)).setImageResource(R.drawable.sai);
    }
}
