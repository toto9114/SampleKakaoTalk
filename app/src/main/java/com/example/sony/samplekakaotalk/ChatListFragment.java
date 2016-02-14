package com.example.sony.samplekakaotalk;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatListFragment extends Fragment {


    public ChatListFragment() {
        // Required empty public constructor
    }

    ListView listView;
    ChatListAdapter mAdapter;
    SearchView searchView;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat_list, container, false);
        listView = (ListView)view.findViewById(R.id.chat_listView);

        searchView = new SearchView(getContext());
        searchView.searchView.setHint(getResources().getString(R.string.search_chat_hint));

        mAdapter = new ChatListAdapter();
        listView.addHeaderView(searchView);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PersonData person = (PersonData) listView.getItemAtPosition(position);
                String title = person.name;
                Intent intent = new Intent(getContext(), ChatScreenActivity.class);
                intent.putExtra(ChatScreenActivity.EXTRA_MESSAGE, title);
                startActivity(intent);
            }
        });

        initData();

        return view;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            getActivity().setTitle("채팅");
        }
    }
    private void initData(){
        PersonData person;
        for(int i=0;i<10;i++){
            person = new PersonData();
            person.name = "person "+ i;
            person.iconId = R.mipmap.ic_launcher;
            mAdapter.addChat(person);
        }
    }
}
