package com.cruz.sportify.Main.Feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cruz.sportify.Models.Feed;
import com.cruz.sportify.R;

import java.util.ArrayList;

/**
 * Created by Acer on 03/07/2017.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Feed> feeds;

    public FeedAdapter(Context context, ArrayList<Feed> feeds){
        this.context = context;
        this.feeds = feeds;
    }

    @Override
    public FeedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_card_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FeedAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(feeds.get(position).getPicHolder()).into(holder.picHolder);
        holder.nameHolder.setText(feeds.get(position).getNameHolder());
        holder.timeHolder.setText(feeds.get(position).getTimeHolder());
        Glide.with(context).load(feeds.get(position).getButtonType()).into(holder.extraBtn);
        holder.textContent.setText(feeds.get(position).getTextContent());
        Glide.with(context).load(feeds.get(position).getImageContent()).into(holder.imageContent);
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView picHolder, extraBtn, imageContent;
        TextView nameHolder, timeHolder, textContent;

        public ViewHolder(View itemView) {
            super(itemView);

            picHolder = itemView.findViewById(R.id.imageHolder);
            extraBtn = itemView.findViewById(R.id.extraBtn);
            imageContent = itemView.findViewById(R.id.imageContent);
            nameHolder = itemView.findViewById(R.id.nameHolder);
            timeHolder = itemView.findViewById(R.id.timeHolder);
            textContent = itemView.findViewById(R.id.textContent);
        }
    }
}
