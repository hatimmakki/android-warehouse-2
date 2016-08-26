package com.maxwell.androidwarehouse2.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.adapters.TabsAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;


public class TabsDemo extends AppCompatActivity {
    @Bind(R.id.buttonsContainer)
    LinearLayout buttonsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs_layout);
        ButterKnife.bind(this);

        buttonsContainer.setVisibility(View.GONE);

        ViewPager viewPager = (ViewPager) findViewById(R.id.customViewPager);
        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabsAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.designTabLayout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setupWithViewPager(viewPager);
    }
}
