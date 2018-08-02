package com.example.rams.interact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.rams.interact.utils.FontChanger;
import com.github.chrisbanes.photoview.PhotoView;

public class utschedule_page extends AppCompatActivity {
    Button u1;
    Button u2;
    Button u3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utschedule_page);
        FontChanger fontChanger = new FontChanger(getAssets(),"font/sourceSansProSemiBold.ttf");
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));
      final   RadioButton sem3=(RadioButton)findViewById(R.id.sem3);

      final  RadioButton sem5=(RadioButton)findViewById(R.id.sem5);

       final RadioButton sem7=(RadioButton)findViewById(R.id.sem7);



        u1=(Button)findViewById(R.id.unit1);
        u2=(Button)findViewById(R.id.unit2);
        u3=(Button)findViewById(R.id.unit3);

         u1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sem3.isChecked())
                {   PhotoView photoView = (PhotoView) findViewById(R.id.image1);
                    photoView.setImageResource(R.drawable.unit1a);
                  //  ImageView  img=(ImageView)findViewById(R.id.image1);
                   // TextView tt=(TextView)findViewById(R.id.tt);
                   // tt.setText("unit-1");
                   // img.setBackgroundResource(R.drawable.unit1a);
                }
                if(sem5.isChecked())
                {
                    PhotoView photoView = (PhotoView) findViewById(R.id.image1);
                    photoView.setImageResource(R.drawable.unit1b);
                  // ImageView img1=(ImageView)findViewById(R.id.image1);
                   // TextView tt=(TextView)findViewById(R.id.tt);
                   // tt.setText("unit-1");
                   // img1.setBackgroundResource(R.drawable.unit1b);
                }
                if(sem7.isChecked())
                {

                    PhotoView photoView = (PhotoView) findViewById(R.id.image1);
                    photoView.setImageResource(R.drawable.unit1c);
                   // ImageView   img2=(ImageView)findViewById(R.id.image1);
                   // TextView tt=(TextView)findViewById(R.id.tt);
                   // tt.setText("unit-1");
                   // img2.setBackgroundResource(R.drawable.unit1c);
                }


        }});
       u2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sem3.isChecked())
                {
                    PhotoView photoView = (PhotoView) findViewById(R.id.image1);
                    photoView.setImageResource(R.drawable.unit2a);
                   // ImageView   img=(ImageView)findViewById(R.id.image1);
                   // TextView tt=(TextView)findViewById(R.id.tt);
                   // tt.setText("unit-2");
                   // img.setBackgroundResource(R.drawable.unit2a);
                }
                if(sem5.isChecked())
                {

                    PhotoView photoView = (PhotoView) findViewById(R.id.image1);
                    photoView.setImageResource(R.drawable.unit2b);
                   // ImageView  img=(ImageView)findViewById(R.id.image1);
                   // TextView tt=(TextView)findViewById(R.id.tt);
                   // tt.setText("unit-2");

                   // img.setBackgroundResource(R.drawable.unit2b);
                }
                if(sem7.isChecked())
                {
                    PhotoView photoView = (PhotoView) findViewById(R.id.image1);
                    photoView.setImageResource(R.drawable.unit2c);
                   // ImageView     img=(ImageView)findViewById(R.id.image1);
                   // TextView tt=(TextView)findViewById(R.id.tt);
                   // tt.setText("unit-2");
                   // img.setBackgroundResource(R.drawable.unit2c);
                }


            }});
       u3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sem3.isChecked())
                {
                    PhotoView photoView = (PhotoView) findViewById(R.id.image1);
                    photoView.setImageResource(R.drawable.unit3a);
                   // ImageView    img=(ImageView)findViewById(R.id.image1);
                   // TextView tt=(TextView)findViewById(R.id.tt);
                   // tt.setText("unit-3");
                   // img.setBackgroundResource(R.drawable.unit3a);
                }
                if(sem5.isChecked())
                {
                    PhotoView photoView = (PhotoView) findViewById(R.id.image1);
                    photoView.setImageResource(R.drawable.unit3b);
                  //  ImageView    img=(ImageView)findViewById(R.id.image1);
                   // TextView tt=(TextView)findViewById(R.id.tt);
                   // tt.setText("unit-3");

                   // img.setBackgroundResource(R.drawable.unit3b);
                }
                if(sem7.isChecked())
                {PhotoView photoView = (PhotoView) findViewById(R.id.image1);
                    photoView.setImageResource(R.drawable.unit3c);
                   // ImageView   img=(ImageView)findViewById(R.id.image1);
                   // TextView tt=(TextView)findViewById(R.id.tt);
                   // tt.setText("unit-3");

//                    img.setBackgroundResource(R.drawable.unit3c);
                }


        }});
    }

}


