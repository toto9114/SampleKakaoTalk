package com.example.sony.samplekakaotalk;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by sony on 2016-02-11.
 */
public class TabAdditionalCustomView extends FrameLayout {
    public TabAdditionalCustomView(Context context) {
        super(context);
        init();
    }
    ImageView tabView;
    private void init(){
        inflate(getContext(),R.layout.view_tab_additional,this);
        tabView = (ImageView)findViewById(R.id.image_tab_additional);
    }
}
