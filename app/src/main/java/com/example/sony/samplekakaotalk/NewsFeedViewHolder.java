package com.example.sony.samplekakaotalk;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sony on 2016-01-30.
 */
public class NewsFeedViewHolder extends RecyclerView.ViewHolder {
    ImageView pictureView;
    TextView titleView;
    NewsFeedData data;
    public NewsFeedViewHolder(View itemView) {
        super(itemView);
        pictureView = (ImageView)itemView.findViewById(R.id.image_picture);
        titleView = (TextView)itemView.findViewById(R.id.text_title);
    }

    public void setPicture(NewsFeedData data){
        this.data = data;
        titleView.setText(data.message);
        if(data.pictureId != -1) {
            pictureView.setImageResource(data.pictureId);
        }
    }

}
