package com.example.rams.interact;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder>{
    Context mContext;
    List<Messages> list;
    public ChatAdapter(Context mContext,List<Messages> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View v = layoutInflater.inflate(R.layout.layout_message,null);
        return new ChatViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        Messages m = list.get(position);
        holder.t1.setText(m.getUser());
        holder.t2.setText(m.getMsg());
        holder.t3.setText(m.getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder{
        TextView t1,t2,t3;
        public ChatViewHolder(View v) {
            super(v);
            t1 = v.findViewById(R.id.user);
            t2 = v.findViewById(R.id.msg);
            t3 = v.findViewById(R.id.time);
        }
    }
}
