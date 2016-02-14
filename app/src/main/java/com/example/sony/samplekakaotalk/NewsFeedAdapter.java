package com.example.sony.samplekakaotalk;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sony on 2016-01-30.
 */
public class NewsFeedAdapter extends RecyclerView.Adapter implements OnItemClickListener{
    List<NewsFeedData> items = new ArrayList<NewsFeedData>();
    List<NewsFeedHeaderData> headers = new ArrayList<NewsFeedHeaderData>();

    public static final int VIEW_HEADER = 0;
    public static final int VIEW_SECTION = 100;
    public static final int VIEW_ITEM = 101;

    public void add(NewsFeedData data) {
        items.add(data);
        notifyDataSetChanged();
    }


    public void addHeader(View headerView,Object data,boolean isClick){
        NewsFeedHeaderData header = new NewsFeedHeaderData();
        header.headerView = headerView;
        header.data = data;
        header.isClick =isClick;
        headers.add(header);
        notifyDataSetChanged();
    }

    public void del(int position){
        items.remove(position);
        notifyDataSetChanged();
    }
    OnItemClickListener itemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener){
        itemClickListener = listener;
    }
    @Override
    public void onItemClick(View view, int position) {
        if(itemClickListener !=null){
            itemClickListener.onItemClick(view,position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position<headers.size()) return VIEW_HEADER+position;
        else if(position<items.size()-1) {
            return VIEW_ITEM;
        }
        else {
            return VIEW_SECTION;
        }
        //return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case VIEW_ITEM:
                View view = inflater.inflate(R.layout.view_news_feed, parent, false);
                return new NewsFeedViewHolder(view);
            case VIEW_SECTION:
                View v = inflater.inflate(R.layout.view_section_header,parent,false);
                NewsFeedSectionViewHolder holder = new NewsFeedSectionViewHolder(v);
                holder.setOnItemClickListener(this);
                return holder;
            case VIEW_HEADER:
                View header = inflater.inflate(R.layout.newsfeed_header,parent,false);
                NewsFeedHeaderData headerData = headers.get(viewType);
                NewsFeedHeaderViewHolder headerViewHolder = new NewsFeedHeaderViewHolder(header);
                return  headerViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int index=position;
        if(position>=headers.size()){
            index = position-headers.size();
        }
        switch (getItemViewType(position)) {

            case VIEW_ITEM:
                ((NewsFeedViewHolder) holder).setPicture(items.get(index));
                return;
            case VIEW_SECTION:
                ((NewsFeedSectionViewHolder) holder).setTitle(items.get(index).message);
                return;
            case VIEW_HEADER:
                ((NewsFeedHeaderViewHolder)holder).setHeader(headers.get(position));
                return;
        }
    }

    @Override
    public int getItemCount() {
        return items.size()+headers.size();
    }

    public NewsFeedData getItem(int position) {
        if (position < 0 || position > getItemCount()) {
            return null;
        }
        return items.get(position);
    }
}
