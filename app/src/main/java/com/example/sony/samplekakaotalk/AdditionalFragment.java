package com.example.sony.samplekakaotalk;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdditionalFragment extends Fragment {

    private static final int[] IDS ={R.drawable.gallery_photo_1,
            R.drawable.gallery_photo_2,
            R.drawable.gallery_photo_3,
            R.drawable.gallery_photo_4,
            R.drawable.gallery_photo_5,
            R.drawable.gallery_photo_6,
            R.drawable.gallery_photo_7,
            R.drawable.gallery_photo_8,};


    public AdditionalFragment() {
        // Required empty public constructor
    }

    GridView gridView;
    GridView kakaoAppView;
    AdditionalAdapter mAdapter;
    AdditionalAdapter mAdapter2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_additional, container, false);

        gridView = (GridView)view.findViewById(R.id.gridView);
        mAdapter = new AdditionalAdapter();
        gridView.setAdapter(mAdapter);

        kakaoAppView = (GridView)view.findViewById(R.id.grid_app_list);
        mAdapter2 =new AdditionalAdapter();
        kakaoAppView.setAdapter(mAdapter2);

        initData();
        return view;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            getActivity().setTitle("더보기");
        }
    }

    private void initData(){
        AdditionalData data;
        for(int i=0;i<16;i++){
            data = new AdditionalData();
            data.iconId = IDS[i%IDS.length];
            data.message = "message"+i;
            mAdapter.add(data);
            if(i%4==0){
                mAdapter2.add(data);
            }
        }
    }
}
