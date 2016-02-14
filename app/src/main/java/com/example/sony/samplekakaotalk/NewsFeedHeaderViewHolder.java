package com.example.sony.samplekakaotalk;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by sony on 2016-02-10.
 */
public class NewsFeedHeaderViewHolder extends RecyclerView.ViewHolder {
    ImageView textView;
    ImageView iconView;
    NewsFeedHeaderData data;
    public NewsFeedHeaderViewHolder(View itemView) {
        super(itemView);
        textView = (ImageView)itemView.findViewById(R.id.image_kakao_search);
        iconView = (ImageView)itemView.findViewById(R.id.image_search_icon);
    }
    public void setHeader(NewsFeedHeaderData data){
        this.data = data;
        textView.setImageResource(R.drawable.kakaosearch);
        iconView.setImageResource(R.drawable.search_icon);
    }
}
