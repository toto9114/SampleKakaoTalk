package com.example.sony.samplekakaotalk;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager pager;
    MyViewPagerAdapter mAdapter;

    private static final int[] TAB_ICONS = {R.drawable.friend_selector,R.drawable.friend_select, R.drawable.friend_default};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        pager = (ViewPager)findViewById(R.id.pager);
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager());

        pager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(pager);
        tabLayout.setTabsFromPagerAdapter(mAdapter);
        tabLayout.removeAllTabs();


        tabLayout.addTab(tabLayout.newTab().setCustomView(new TabFriendsCustomView(MainActivity.this)));
        tabLayout.addTab(tabLayout.newTab().setCustomView(new TabChatCustomView(MainActivity.this)));
        tabLayout.addTab(tabLayout.newTab().setCustomView(new TabChannelCustomView(MainActivity.this)));
        tabLayout.addTab(tabLayout.newTab().setCustomView(new TabAdditionalCustomView(MainActivity.this)));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
