package com.example.rams.interact;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder>{
    Context mContext;
    List<EventModel> list;

    public EventAdapter(Context mContext, List<EventModel> list) {
        this.mContext = mContext;
        this.list = list;
        Log.i("Event","Entered Adapter COnstructor");
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View v = layoutInflater.inflate(R.layout.event_cardview,null);
        return new EventAdapter.EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
            Log.i("Events","Final");
            EventModel e = list.get(position);
            holder.t1.setText(e.getEventtitle());
            holder.t2.setText(e.getEventdes());
            holder.t3.setText(e.getOrganisers());
            holder.t4.setText(e.getEventdate());
            holder.t5.setText(e.getLocation());
            Typeface normal = Typeface.createFromAsset(mContext.getAssets(),"font/sourceSansProLight.ttf");
            Typeface bold = Typeface.createFromAsset(mContext.getAssets(),"font/sourceSansProSemiBold.ttf");
            holder.t1.setTypeface(bold);
            holder.t6.setTypeface(bold);
            holder.t7.setTypeface(bold);
            holder.t8.setTypeface(bold);
            holder.t2.setTypeface(normal);
            holder.t3.setTypeface(normal);
            holder.t4.setTypeface(normal);
            holder.t5.setTypeface(normal);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder{
        TextView t1,t2,t3,t4,t5,t6,t7,t8;
        public EventViewHolder(View view) {
            super(view);
            Log.i("Events","Entering EventViewHolder Cosntructor");
            t1 = view.findViewById(R.id.eventname);
            t2 = view.findViewById(R.id.eventdes);
            t3 = view.findViewById(R.id.org);
            t4 = view.findViewById(R.id.date);
            t5 = view.findViewById(R.id.location);
            t6 = view.findViewById(R.id.orgT);
            t7 = view.findViewById(R.id.locationT);
            t8 = view.findViewById(R.id.dateT);
        }
    }
}
