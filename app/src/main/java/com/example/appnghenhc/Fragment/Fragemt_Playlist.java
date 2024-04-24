package com.example.appnghenhc.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.appnghenhc.Model.Playlist;
import com.example.appnghenhc.R;
import com.example.appnghenhc.Service.APIRetrofitClient;
import com.example.appnghenhc.Service.APIService;
import com.example.appnghenhc.Service.Dataservice;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragemt_Playlist extends Fragment {

    View view;
    ListView lvplaylist;
    Text txttitleplaylist,txtviewxemthemplaylist;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragemt_playlist,container,false);
        lvplaylist = view.findViewById(R.id.listviewplaylist);
        txttitleplaylist = view.findViewById((R.id.textviewtitleplaylist));
        txtviewxemthemplaylist = view.findViewById((R.id.textviewviewmoreplaylist));
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Playlist>> callback = dataservice.GetPlaylistCurrentDay();
        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                ArrayList<Playlist> mangplaylist = (ArrayList<Playlist>) response.body();
                Log.d("BBB",mangplaylist.get(0).getTen());
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });
    }

}
