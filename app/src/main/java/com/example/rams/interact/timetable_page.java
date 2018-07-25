package com.example.rams.interact;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class timetable_page extends AppCompatActivity {

        private Button ita2;
    private Button ita3;
   private Button ita4;
    private Button itb2;
    private Button itb3;
    private Button itb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable_page);


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
                ImageView img=(ImageView)findViewById(R.id.image1);
                img.setBackgroundResource(R.drawable.ita2);



            }
        });

        ita3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextView tt=(TextView)findViewById(R.id.tt);
                tt.setText("IT A - III YEAR");
                ImageView img=(ImageView)findViewById(R.id.image1);
                img.setBackgroundResource(R.drawable.it3a);

            }
        });

        ita4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView tt=(TextView)findViewById(R.id.tt);
                tt.setText("IT A - IV YEAR");
                ImageView img=(ImageView)findViewById(R.id.image1);
                img.setBackgroundResource(R.drawable.ita4);

            }
        });

        itb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextView tt=(TextView)findViewById(R.id.tt);
                tt.setText("IT B - II YEAR");
                ImageView img=(ImageView)findViewById(R.id.image1);
                img.setBackgroundResource(R.drawable.ita2);

            }
        });
        itb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView tt=(TextView)findViewById(R.id.tt);
                tt.setText("IT B - III YEAR");
                ImageView img=(ImageView)findViewById(R.id.image1);
                img.setBackgroundResource(R.drawable.it3b);

            }
        });
        itb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tt=(TextView)findViewById(R.id.tt);
                tt.setText("IT B - IV YEAR");
                ImageView img=(ImageView)findViewById(R.id.image1);
                img.setBackgroundResource(R.drawable.itb4);

            }
        });



    }
}


