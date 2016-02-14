package com.example.sony.samplekakaotalk;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sony on 2016-01-29.
 */
public class PersonListAdapter extends BaseExpandableListAdapter {
    List<SectionData> items = new ArrayList<SectionData>();


    public void put(SectionData section, PersonData person) {
        SectionData match = null;
        for (SectionData s : items) {
            if (s.title.equals(section.title)) {
                match = s;
                break;
            }
        }
        if (match == null) {
            match = new SectionData();
            match.title = section.title;
            items.add(match);
        }
        if (!TextUtils.isEmpty(person.name)) {
            if (person.iconId != -1) {
                PersonData personData = new PersonData();
                personData.iconId = person.iconId;
                personData.name = person.name;
                match.children.add(personData);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return items.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return items.get(groupPosition).children.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return items.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return items.get(groupPosition).children.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return ((long) groupPosition) << 32 | 0xFFFFFFFF;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return ((long) groupPosition) << 32 | childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        SectionView view;
        if (convertView == null) {
            view = new SectionView(parent.getContext());
        } else {
            view = (SectionView) convertView;
        }
        view.setTitle(items.get(groupPosition));
        return view;
    }

    public int getTotalChildCount(){
        int count=0;
        if(items != null) {
            for (int i = 0; i < getGroupCount(); i++) {
                count += getChildrenCount(i);
            }
        }
        return count;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        PersonView view;
        if (convertView == null) {
            view = new PersonView(parent.getContext());
        } else {
            view = (PersonView) convertView;
        }
        view.setData(items.get(groupPosition).children.get(childPosition));
        return view;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
