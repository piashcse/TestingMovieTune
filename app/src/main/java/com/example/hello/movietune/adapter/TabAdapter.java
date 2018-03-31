package com.example.hello.movietune.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.hello.movietune.fragment.NewMovieFragment;
import com.example.hello.movietune.fragment.RecentMovieFragment;

/**
 * Created by hello on 10/3/18.
 */

public class TabAdapter extends FragmentStatePagerAdapter {
    private String tabTitles[] = new String[] { "New Release", "Top Rated"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0){
            return  new NewMovieFragment();

        }else if (position == 1){
            return  new RecentMovieFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
