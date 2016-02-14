package com.example.sony.samplekakaotalk;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sony on 2016-01-29.
 */
public class PersonView extends FrameLayout {
    ImageView iconView;
    TextView nameView;
    PersonData data;
    public PersonView(Context context) {
        super(context);

        init();
    }
    private void init(){
        inflate(getContext(),R.layout.view_person,this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        nameView = (TextView)findViewById(R.id.text_name);
    }
    public void setData(PersonData data){
        this.data = data;
        iconView.setImageResource(data.iconId);
        nameView.setText(data.name);
    }
}
