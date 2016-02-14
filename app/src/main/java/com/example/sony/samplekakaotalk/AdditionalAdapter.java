package com.example.sony.samplekakaotalk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sony on 2016-02-08.
 */
public class AdditionalAdapter extends BaseAdapter {
    List<AdditionalData> items = new ArrayList<AdditionalData>();

    public void add(AdditionalData data){
        items.add(data);
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
    public View getView(int position, View convertView, ViewGroup parent) {
        AdditionalView view;
        if(convertView == null){
            view = new AdditionalView(parent.getContext());
        }
        else {
            view= (AdditionalView)convertView;
        }
        view.setAdditionalData(items.get(position));
        return view;
    }
}
