package com.example.sony.samplekakaotalk;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sony on 2016-02-07.
 */
public class NewsFeedSectionViewHolder extends RecyclerView.ViewHolder {
    TextView messageView;

    public OnItemClickListener itemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener){
        itemClickListener = listener;
    }

    public NewsFeedSectionViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClickListener != null){
                    itemClickListener.onItemClick(v,getAdapterPosition());
                }
            }
        });
        init();
    }
    private void init(){
        messageView = (TextView)itemView.findViewById(R.id.text_more);
    }

    public void setTitle(String title){
        messageView.setText(title);
    }
}
