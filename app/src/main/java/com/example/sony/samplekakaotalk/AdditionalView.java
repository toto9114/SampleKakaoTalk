package com.example.sony.samplekakaotalk;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sony on 2016-02-08.
 */
public class AdditionalView extends FrameLayout {
    public AdditionalView(Context context) {
        super(context);
        init();
    }
    ImageView iconView;
    TextView messageView;
    AdditionalData data;
    private void init(){
        inflate(getContext(),R.layout.view_additional,this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        messageView = (TextView)findViewById(R.id.text_message);
    }
    public void setAdditionalData(AdditionalData data){
        this.data = data;
        iconView.setImageResource(data.iconId);
        messageView.setText(data.message);
    }
}
