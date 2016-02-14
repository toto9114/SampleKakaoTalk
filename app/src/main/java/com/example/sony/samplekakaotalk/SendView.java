package com.example.sony.samplekakaotalk;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sony on 2016-01-16.
 */
public class SendView extends FrameLayout {
    public SendView(Context context) {
        super(context);
        init();
    }

    ImageView iconView;
    TextView message;
    TextView date;
    SendData data;
    public void init(){
        inflate(getContext(), R.layout.view_send,this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        message = (TextView)findViewById(R.id.text_message);
        date = (TextView)findViewById(R.id.text_date);
    }
    public void setData(SendData data){
        this.data = data;
        iconView.setImageResource(R.mipmap.ic_launcher);
        message.setText(data.message);
        date.setText(data.date);
    }
}
