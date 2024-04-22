package com.example.appnghenhc.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.appnghenhc.Adapter.MainViewPagerAdapter;
import com.example.appnghenhc.Fragment.Fragemt_Tim_Kiem;
import com.example.appnghenhc.Fragment.Fragemt_Trang_Chu;
import com.example.appnghenhc.R;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
    }
    private void init(){
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragemt(new Fragemt_Trang_Chu(),"Trang Chu");
        mainViewPagerAdapter.addFragemt(new Fragemt_Tim_Kiem(),"Tim Kiem");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.icontimkiem);
    }

    private void anhxa(){
        tabLayout = findViewById(R.id.myTablayout);
        viewPager = findViewById(R.id.myViewPager);
    }
}