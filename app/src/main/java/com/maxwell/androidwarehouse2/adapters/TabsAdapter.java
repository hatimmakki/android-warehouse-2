package com.maxwell.androidwarehouse2.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.maxwell.androidwarehouse2.fragments.ArticleFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbais on 25/06/2015.
 */
public class TabsAdapter extends FragmentPagerAdapter {

    private List<Fragment> mListPages;

    private String[] titles = new String[]{
            "Social",
            "Multimedia",
            "Devs",
            "User Interface",
            "Animations",
            "Location",
            "Storage"
    };

    public TabsAdapter(FragmentManager fm) {
        super(fm);

        mListPages = new ArrayList<>();

        for (int indice = 0; indice < 7; indice++) {
            ArticleFragment articleFragment = new ArticleFragment();

            mListPages.add(articleFragment);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mListPages.get(position);
    }

    @Override
    public int getCount() {
        return mListPages.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
