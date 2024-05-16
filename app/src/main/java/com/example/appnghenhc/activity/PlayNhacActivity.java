package com.example.appnghenhc.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appnghenhc.Adapter.ViewPagerPlaylistnhac;
import com.example.appnghenhc.Fragment.Fragemt_Dia_Nhac;
import com.example.appnghenhc.Fragment.Fragemt_Play_Danh_Sach_Cac_Bai_Hat;
import com.example.appnghenhc.Model.Baihat;
import com.example.appnghenhc.R;

import java.util.ArrayList;

public class PlayNhacActivity extends AppCompatActivity {
    Toolbar toolbarplaynhac;
    TextView txtTimesong,txtTotaltimesong;
    SeekBar sktime;
    ImageButton imgplay,imgrepeat,imgnext,imgpre,imgrandom;
    ViewPager viewPagerplaynhac;
    public static ArrayList<Baihat> mangbaihat = new ArrayList<>();
    public static ViewPagerPlaylistnhac adapternhac;
    Fragemt_Dia_Nhac fragemt_dia_nhac;
    Fragemt_Play_Danh_Sach_Cac_Bai_Hat fragemt_play_danh_sach_cac_bai_hat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac);
        init();
        GetDataFromIntent();
//        Intent intent = getIntent();
//        if(intent.hasExtra("cakhuc")){
//            Baihat baihat = intent.getParcelableExtra("cakhuc");
//            Toast.makeText(this, baihat.getTenbaihat(), Toast.LENGTH_SHORT).show();
//        }
//        if(intent.hasExtra("cacbaihat")){
//            ArrayList<Baihat> mangbaihat = intent.getParcelableArrayListExtra("cacbaihat");
//            for(int i=0;i<mangbaihat.size();i++){
//                Log.d("BBB",mangbaihat.get(i).getTenbaihat());
//            }
//        }
    }

    private void GetDataFromIntent() {
        Intent intent = getIntent();
        mangbaihat.clear();
        if(intent!=null){
            if(intent.hasExtra("cakhuc")){
                Baihat baihat = intent.getParcelableExtra("cakhuc");
                // Toast.makeText(this, baihat.getTenbaihat(), Toast.LENGTH_SHORT).show();
                mangbaihat.add(baihat);
            }
            if(intent.hasExtra("cacbaihat")){
                ArrayList<Baihat> baihatArrayList = intent.getParcelableArrayListExtra("cacbaihat");
//            for(int i=0;i<mangbaihat.size();i++){
//                Log.d("BBB",mangbaihat.get(i).getTenbaihat());
//            }
                mangbaihat = baihatArrayList;
            }
        }
    }

    private void init() {
        toolbarplaynhac = findViewById(R.id.toolbarplaynhac);
        txtTimesong = findViewById(R.id.textviewtimesong);
        txtTotaltimesong = findViewById(R.id.textviewtotaltimesong);
        sktime = findViewById(R.id.seekbarsong);
        imgplay = findViewById(R.id.imagebuttonplay);
        imgrepeat = findViewById(R.id.imagebuttonrepeat);
        imgnext = findViewById(R.id.imagebuttonnext);
        imgrandom = findViewById(R.id.imagebuttonsuffle);
        imgpre = findViewById(R.id.imagebuttonpre);
        viewPagerplaynhac = findViewById(R.id.viewpagerplaynhac);
        setSupportActionBar(toolbarplaynhac);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarplaynhac.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbarplaynhac.setTitleTextColor(Color.WHITE);
        fragemt_dia_nhac = new Fragemt_Dia_Nhac();
        fragemt_play_danh_sach_cac_bai_hat = new Fragemt_Play_Danh_Sach_Cac_Bai_Hat();
        adapternhac = new ViewPagerPlaylistnhac(getSupportFragmentManager());
        adapternhac.AddFragment(fragemt_play_danh_sach_cac_bai_hat);
        adapternhac.AddFragment(fragemt_dia_nhac);
        viewPagerplaynhac.setAdapter(adapternhac);
    }
}