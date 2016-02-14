package com.example.sony.samplekakaotalk;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */

public class PersonListFragment extends Fragment {

    PersonListAdapter mAdapter;
    ExpandableListView listView;
    SearchView searchView;
    public PersonListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_person_list, container, false);

        listView = (ExpandableListView)view.findViewById(R.id.expandableListView);
        searchView = new SearchView(getContext());
        mAdapter = new PersonListAdapter();
        listView.addHeaderView(searchView);
        listView.setAdapter(mAdapter);
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                v.setBackgroundColor(Color.TRANSPARENT);
                return true;
            }
        });
        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                listView.expandGroup(groupPosition);
            }
        });

        initData();
        for(int i =0;i< mAdapter.getGroupCount();i++) {
            listView.expandGroup(i);
        }
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            getActivity().setTitle("친구");
        }
    }
    public void initData(){
        PersonData personData; SectionData sectionData;
        sectionData = new SectionData();
        sectionData.title = "내 프로필";
        personData = new PersonData();
        personData.name = "이지훈";
        personData.iconId = R.drawable.personicon_default;
        mAdapter.put(sectionData,personData);

        sectionData = new SectionData();
        sectionData.title = "그룹";
        personData = new PersonData();
        personData.name = "플러스친구";
        personData.iconId = R.drawable.plusfriend;
        mAdapter.put(sectionData,personData);

        Random r = new Random();
        for(int i=0;i<10;i++){
            sectionData = new SectionData();
            sectionData.title = "section"+ i;
            int childCount = 2+ r.nextInt(4);
            for(int j = 0 ; j < childCount ; j++){
                personData = new PersonData();
                personData.iconId = R.drawable.personicon_default;
                personData.name = "name "+j;
                mAdapter.put(sectionData,personData);
            }
        }
    }

}
