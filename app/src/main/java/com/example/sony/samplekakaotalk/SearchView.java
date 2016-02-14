package com.example.sony.samplekakaotalk;

import android.content.Context;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by sony on 2016-01-30.
 */
public class SearchView extends FrameLayout {
    public SearchView(Context context) {
        super(context);
        init();
    }
    EditText searchView;
    ImageView searchIcon;
    private void init(){
        inflate(getContext(),R.layout.view_search_header,this);
        searchView = (EditText)findViewById(R.id.edit_search);
        searchIcon = (ImageView)findViewById(R.id.image_search_icon);
    }
}
