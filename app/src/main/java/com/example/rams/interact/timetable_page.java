package com.example.rams.interact;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rams.interact.utils.FontChanger;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

public class timetable_page extends AppCompatActivity {

    Button ita2;
    Button ita3;
    Button ita4;
    Button itb2;
    Button itb3;
    Button itb4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable_page);
        FontChanger fontChanger = new FontChanger(getAssets(),"font/sourceSansProSemiBold.ttf");
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));
        ita2=(Button)findViewById(R.id.ita2);
        ita3=(Button)findViewById(R.id.ita3);
        ita4=(Button)findViewById(R.id.ita4);
        itb2=(Button)findViewById(R.id.itb2);
        itb3=(Button)findViewById(R.id.itb3);
        itb4=(Button)findViewById(R.id.itb4);




        ita2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextView tt=(TextView)findViewById(R.id.tt);
                tt.setText("IT A - II YEAR");
                PhotoView photoView = (PhotoView) findViewById(R.id.image1);
                photoView.setImageResource(R.drawable.ita2);

            //   img.setBackgroundResource(R.drawable.ita2);




            }
        });

        ita3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextView tt=(TextView)findViewById(R.id.tt);
                tt.setText("IT A - III YEAR");
               // ImageView img=(ImageView)findViewById(R.id.image1);
                PhotoView photoView = (PhotoView) findViewById(R.id.image1);
                photoView.setImageResource(R.drawable.ita3);
               // mAttacher= new PhotoViewAttacher(img);
                //img.setBackgroundResource(R.drawable.it3a);
               // mAttacher.update();

            }
        });

        ita4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView tt=(TextView)findViewById(R.id.tt);
               tt.setText("IT A - IV YEAR");

                PhotoView photoView = (PhotoView) findViewById(R.id.image1);
                photoView.setImageResource(R.drawable.ita4);
               //    ImageView img=(ImageView)findViewById(R.id.image1);
             //   mAttacher= new PhotoViewAttacher(img);
              //  img.setBackgroundResource(R.drawable.ita4);
               // mAttacher.update();


            }
        });

        itb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextView tt=(TextView)findViewById(R.id.tt);
                tt.setText("IT B - II YEAR");

                PhotoView photoView = (PhotoView) findViewById(R.id.image1);
                photoView.setImageResource(R.drawable.itb2);
          //      ImageView img=(ImageView)findViewById(R.id.image1);
           //     mAttacher= new PhotoViewAttacher(img);

             //   img.setBackgroundResource(R.drawable.ita2);
               // mAttacher.update();

            }
        });
        itb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView tt=(TextView)findViewById(R.id.tt);
                tt.setText("IT B - III YEAR");
                PhotoView photoView = (PhotoView) findViewById(R.id.image1);
                photoView.setImageResource(R.drawable.itb3);

              //  ImageView img=(ImageView)findViewById(R.id.image1);
                //mAttacher= new PhotoViewAttacher(img);

               // img.setBackgroundResource(R.drawable.it3b);
               // mAttacher.update();

            }
        });
        itb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tt=(TextView)findViewById(R.id.tt);
                tt.setText("IT B - IV YEAR");
                PhotoView photoView = (PhotoView) findViewById(R.id.image1);
                photoView.setImageResource(R.drawable.itb4);

             //   ImageView img=(ImageView)findViewById(R.id.image1);
              //  mAttacher= new PhotoViewAttacher(img);

                //img.setBackgroundResource(R.drawable.itb4);
               // mAttacher.update();

            }
        });



    }
}

