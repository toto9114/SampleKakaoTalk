package com.example.sony.samplekakaotalk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sony on 2016-01-16.
 */
public class ChattingAdapter extends BaseAdapter{
    List<ChattingData> items = new ArrayList<ChattingData>();

    private static final int IDS_VIEWTYPE_COUNT = 2;

    private static final int TYPE_RECIEVE = 0;
    private static final int TYPE_SEND = 1;

    public void add(ChattingData data){
        items.add(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return IDS_VIEWTYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        ChattingData data = items.get(position);
        if(data instanceof RecieveData){
            return TYPE_RECIEVE;
        }
        else
        {
            return TYPE_SEND;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)){
            case TYPE_RECIEVE:{
                RecieveView view;
                if(convertView != null && convertView instanceof RecieveView){
                    view = (RecieveView)convertView;
                }
                else {
                    view = new RecieveView(parent.getContext());
                }
                view.setData((RecieveData)items.get(position));
                return view;
            }

            case TYPE_SEND:
            default:{
                SendView view;
                if(convertView!=null && convertView instanceof SendView){
                    view = (SendView)convertView;
                }
                else{
                    view = new SendView(parent.getContext());
                }
                view.setData((SendData)items.get(position));
                return view;
            }
        }
    }
}
