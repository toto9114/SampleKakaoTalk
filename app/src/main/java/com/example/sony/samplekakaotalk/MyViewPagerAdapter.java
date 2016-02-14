package com.example.sony.samplekakaotalk;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sony on 2016-01-30.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> items = new ArrayList<Fragment>();
    private static final int TAB1 = 0;
    private static final int TAB2 = 1;
    private static final int TAB3 = 2;
    private static final int TAB4 = 3;

    private static final int PAGE_COUNT =4;
    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragmnet(Fragment f){
        items.add(f);
        notifyDataSetChanged();
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case TAB1:
                return new PersonListFragment();
            case TAB2:
                return new ChatListFragment();
            case TAB3:
                return new NewsFeedFragment();
            case TAB4:
                return new AdditionalFragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
