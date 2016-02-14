package com.example.sony.samplekakaotalk;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by sony on 2016-01-30.
 */
public class SectionView extends FrameLayout {
    public SectionView(Context context) {
        super(context);
        init();
    }
    TextView titleView;
    SectionData data;
    private void init(){
        inflate(getContext(),R.layout.view_section,this);
        titleView = (TextView)findViewById(R.id.text_title);
    }

    public void setTitle(SectionData data){
        this.data = data;
        titleView.setText(data.title);
    }
}
