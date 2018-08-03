package com.example.rams.interact;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rams.interact.utils.FontChanger;


/**
 * A simple {@link Fragment} subclass.
 */
public class identity extends Fragment  implements View.OnClickListener{


    private Button btn1,btn2,btn3,btn4;
    public identity() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FontChanger fontChanger = new FontChanger(getActivity().getAssets(),"font/sourceSansProSemiBold.ttf");
        fontChanger.replaceFonts((ViewGroup)this.getView());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_identity, container, false);
        View rootView = inflater.inflate(R.layout.fragment_identity, container, false);
        btn1= rootView.findViewById(R.id.btn1);
        btn2= rootView.findViewById(R.id.btn2);
        btn3= rootView.findViewById(R.id.btn3);
        btn4= rootView.findViewById(R.id.btn4);

        //Listeners

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        return rootView;

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn1:
                String doc ="https://drive.google.com/open?id=1guOogw0UIEUUj2idDm_eTqcCOluk4DIt";
                Intent pdfintent=new Intent(Intent.ACTION_VIEW, Uri.parse(doc));
                startActivity(pdfintent);
                break;
            case R.id.btn2:
                String doc1 ="https://drive.google.com/open?id=1vwCHbD3dVMaOlTlZwZrNFRI_g-YvuJ3E";
                Intent pdfintent1=new Intent(Intent.ACTION_VIEW, Uri.parse(doc1));
                startActivity(pdfintent1);
                break;
            case R.id.btn3:
                String doc2 ="https://drive.google.com/open?id=16gweUqkDLyMecL6_NRQubPgPElkU6g6U";
                Intent pdfintent2=new Intent(Intent.ACTION_VIEW, Uri.parse(doc2));
                startActivity(pdfintent2);
                break;
            case R.id.btn4:
                String doc3 ="https://drive.google.com/open?id=1bus7OjEf4nZDNi236qRYlhoO85CejQEN";
                Intent pdfintent3=new Intent(Intent.ACTION_VIEW, Uri.parse(doc3));
                startActivity(pdfintent3);
                break;
        }
    }
}
