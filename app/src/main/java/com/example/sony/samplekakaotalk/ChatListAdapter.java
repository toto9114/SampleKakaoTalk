package com.example.sony.samplekakaotalk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sony on 2016-01-30.
 */
public class ChatListAdapter extends BaseAdapter {
    List<PersonData> items = new ArrayList<PersonData>();

    public void addChat(PersonData data) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonView view;
        if (convertView == null) {
            view = new PersonView(parent.getContext());
        } else {
            view = (PersonView) convertView;
        }
        view.setData(items.get(position));

        return view;
    }
}
