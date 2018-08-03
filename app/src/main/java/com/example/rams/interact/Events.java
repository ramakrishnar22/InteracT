package com.example.rams.interact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class Events extends AppCompatActivity {
    List<EventModel> list;
    LinearLayoutManager llm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseFirestore ff;
        llm = new LinearLayoutManager(getApplicationContext());
        ((RecyclerView)findViewById(R.id.eventrecycle)).setLayoutManager(llm);
        ff = FirebaseFirestore.getInstance();
        list = new ArrayList<>();
        ff.collection("Events").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if(e==null) {
                    Log.i("Event","inside onEvent");
                    List<DocumentChange> docs;
                    docs = documentSnapshots.getDocumentChanges();
                    for (DocumentChange doc : documentSnapshots.getDocumentChanges()) {
                        if (doc.getType() == DocumentChange.Type.ADDED) {
                            Log.i("Event","inside the Loop");
                            Map<String, Object> result = doc.getDocument().getData();
                            list.add(new EventModel(String.valueOf(result.get("eventtitle")),String.valueOf(result.get("eventdes")),String.valueOf(result.get("eventdate")),String.valueOf(result.get("location")),String.valueOf(result.get("organisers"))));
                        }
                    }
                    Log.i("Event","Outside Loop");
                    EventAdapter ca = new EventAdapter(getApplicationContext(), list);
                    ((RecyclerView)findViewById(R.id.eventrecycle)).setAdapter(ca);
                    ((RecyclerView)findViewById(R.id.eventrecycle)).setLayoutManager(llm);
                    Log.i("Event","After Adapters");
                }
            }
        });
    }
}
