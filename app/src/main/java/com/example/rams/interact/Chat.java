package com.example.rams.interact;


import android.content.Context;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.rams.interact.utils.FontChanger;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chat extends Fragment {
    View v;
    RecyclerView r;
    List<Messages> list;
    LinearLayoutManager llm;
    FirebaseFirestore fb;
    FirebaseAuth fa;
    String checkname,checkmsg;
    EditText e;
    ListenerRegistration listenerRegistration;
    boolean mobileDataEnabled;
    public Chat() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_chat, container, false);
        r = v.findViewById(R.id.recycle);
        llm = new LinearLayoutManager(getActivity());
        checkname="";
        checkmsg="";
        llm.setStackFromEnd(true);
        r.setLayoutManager(llm);
        mobileDataEnabled=false;
        fa = FirebaseAuth.getInstance();
        fb = FirebaseFirestore.getInstance();
        e = v.findViewById(R.id.sendText);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton ib = v.findViewById(R.id.sendBTN);
        final String realname=fa.getCurrentUser().getDisplayName();
        list = new ArrayList<>();
        listenerRegistration = fb.collection("Messages").orderBy("time", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if (e == null) {
                    List<DocumentChange> docs;
                    docs = documentSnapshots.getDocumentChanges();
                    for (DocumentChange doc : documentSnapshots.getDocumentChanges()) {
                        if (doc.getType() == DocumentChange.Type.ADDED) {
                            Map<String, Object> result = doc.getDocument().getData();
                            long millis = (long) result.get("time");
                            Calendar c = Calendar.getInstance();
                            c.setTimeInMillis(millis);
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM HH:mm");
                            String s = sdf.format(c.getTime());
                            String name;
                            if (String.valueOf(result.get("name")).equals(realname))
                                name = "Me";
                            else
                                name = String.valueOf(result.get("name"));
                            if (String.valueOf(result.get("name")).equals(checkname) && String.valueOf(result.get("msg")).equals(checkmsg))
                                continue;
                            else {
                                list.add(new Messages(String.valueOf(result.get("msg")), name, s));
                                checkname = String.valueOf(result.get("name"));
                                checkmsg = String.valueOf(result.get("msg"));
                            }
                        }
                        ChatAdapter ca = new ChatAdapter(getActivity(), list);
                        r.setAdapter(ca);
                        r.setLayoutManager(llm);
                    }
                }
            }
        });
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(e.getText().toString()))
                    push();
                else
                    Toast.makeText(getContext(),"Enter the message",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void push() {
        ConnectivityManager conn = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            Class mclass = Class.forName(conn.getClass().getName());
            Method meto = mclass.getDeclaredMethod("getMobileDataEnabled");
            meto.setAccessible(true);
            mobileDataEnabled = (Boolean) meto.invoke(conn);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        if (mobileDataEnabled) {
            Map<String, Object> msgSend = new HashMap<>();
            msgSend.put("name", fa.getCurrentUser().getDisplayName());
            msgSend.put("msg", e.getText().toString());
            msgSend.put("time", Calendar.getInstance().getTimeInMillis());

            fb.collection("Messages").add(msgSend).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getContext(), "Check your Internet Connectivity", Toast.LENGTH_SHORT).show();
                }
            });
            e.setText("");
        }
        else{
            Toast.makeText(getContext()," Please On Your Mobile Data!! Just Mobile Data :) ",Toast.LENGTH_SHORT).show();
            e.setText("");
        }
    }
}