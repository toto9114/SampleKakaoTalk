package com.example.sony.samplekakaotalk;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends Fragment{

    private static final int[] IDS = {R.drawable.gallery_photo_1,
            R.drawable.gallery_photo_2,
            R.drawable.gallery_photo_3,
            R.drawable.gallery_photo_4,
            R.drawable.gallery_photo_5,
            R.drawable.gallery_photo_6};

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    SwipeRefreshLayout refreshLayout;
    RecyclerView newsfeedView;
    NewsFeedAdapter mAdapter;
    ImageView titleView;
    Handler mHandler = new Handler(Looper.getMainLooper());
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_news_feed, container, false);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshlayout);
        newsfeedView = (RecyclerView)view.findViewById(R.id.recycler);
        titleView = (ImageView) view.findViewById(R.id.image_search);

        mAdapter = new NewsFeedAdapter();
        newsfeedView.setAdapter(mAdapter);

        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = mAdapter.getItemViewType(position);
                if (viewType == mAdapter.VIEW_ITEM) {
                    return 1;
                } else {
                    return 2;
                }
            }
        });

        titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),SearchActivity.class));
            }
        });

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        addData();
                    }
                }, 2000);
            }
        });

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                addData();
//                layoutManager.smoothScrollToPosition(newsfeedView,null,mAdapter.getItemCount());
            }
        });

        newsfeedView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 5) {
                    titleView.setVisibility(View.GONE);
                } else if (dy < -5) {
                    titleView.setVisibility(View.VISIBLE);
                } else {
                    titleView.setVisibility(titleView.getVisibility());
                }
            }
        });

        newsfeedView.setLayoutManager(layoutManager);

        initData();

        return view;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            getActivity().setTitle("채널");
        }
    }
    private void initData(){
        for(int i = 0; i < IDS.length ; i++){
            NewsFeedData data = new NewsFeedData();
            data.pictureId = IDS[i];
            data.message = "message : " + i;
            mAdapter.add(data);
        }
        NewsFeedData more = new NewsFeedData();
        more.pictureId = -1;
        more.message = "MORE";
        mAdapter.add(more);
    }

    private void addData() {
        if (mAdapter.items != null) {
            mAdapter.del(mAdapter.getItemCount()-1);
        }
        for (int i = 0; i < IDS.length; i++) {
            NewsFeedData data = new NewsFeedData();
            data.pictureId = IDS[i];
            data.message = "message : " + i;
            mAdapter.add(data);
        }
        NewsFeedData more = new NewsFeedData();
        more.pictureId = -1;
        more.message = "MORE";
        mAdapter.add(more);
        refreshLayout.setRefreshing(false);
    }
}
