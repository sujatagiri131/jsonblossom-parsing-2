package com.android.jsontraining2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.jsontraining2.jsonpack.json;
import com.bumptech.glide.Glide;

import java.util.List;

public class Recycleviewadapter extends RecyclerView.Adapter<Recycleviewadapter.ViewHolder> {
    Context context;
    List<json>jsoninternal;

    public Recycleviewadapter(Context context,List<json>jsoninternal){
      this.context=context;
        this.jsoninternal=jsoninternal;
    }

    @Override
    public Recycleviewadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleviewers,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Recycleviewadapter.ViewHolder holder, int position) {
        final json jsonpack=jsoninternal.get(position);
        holder.id1.setText(jsonpack.getId());
        holder.username.setText(jsonpack.getUser_name());
        holder.review.setText(jsonpack.getReview());

        Glide.with(context).load(jsonpack.getImage())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.image);


    }

    @Override
    public int getItemCount() {
        return jsoninternal.size();

    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView id1,username,review;
        ImageView image;
        public ViewHolder(View itemView){
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.image);
            id1=(TextView)itemView.findViewById(R.id.identity);
            username=(TextView)itemView.findViewById(R.id.username);
            review=(TextView)itemView.findViewById(R.id.review);
        }
    }



}