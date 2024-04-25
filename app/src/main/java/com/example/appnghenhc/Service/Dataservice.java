package com.example.appnghenhc.Service;

import com.example.appnghenhc.Model.Album;
import com.example.appnghenhc.Model.Playlist;
import com.example.appnghenhc.Model.Quangcao;
import com.example.appnghenhc.Model.Theloaitrongngay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {

    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistforcurrentday.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();

    @GET("chudevatheloaitrongngay.php")
    Call<Theloaitrongngay> GetCategoryMusic();

    @GET("albumhot.php")
    Call<List<Album>> GetAlbumHot();

}
