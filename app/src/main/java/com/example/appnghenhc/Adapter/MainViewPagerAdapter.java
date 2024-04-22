package com.example.appnghenhc.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrayFragemt = new ArrayList<>();
    private ArrayList<String> arraytital = new ArrayList<>();
    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return arrayFragemt.get(position);
    }

    @Override
    public int getCount() {
        return arrayFragemt.size();
    }
    public void addFragemt (Fragment fragment , String title){
        arrayFragemt.add(fragment);
        arraytital.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
