package com.example.appnghenhc.Service;

import com.example.appnghenhc.Model.Album;
import com.example.appnghenhc.Model.Baihat;
import com.example.appnghenhc.Model.ChuDe;
import com.example.appnghenhc.Model.Playlist;
import com.example.appnghenhc.Model.Quangcao;
import com.example.appnghenhc.Model.TheLoai;
import com.example.appnghenhc.Model.Theloaitrongngay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {

    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistforcurrentday.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();

    @GET("chudevatheloaitrongngay.php")
    Call<Theloaitrongngay> GetCategoryMusic();

    @GET("albumhot.php")
    Call<List<Album>> GetAlbumHot();

    @GET("baihatduocthich.php")
    Call<List<Baihat>> GetBaiHatHot();

    @POST("danhsachbaihat.php")
    @FormUrlEncoded
    Call<List<Baihat>> GetDanhsachbaihattheoquangcao(@Field("idquangcao") String idquangcao);

    @POST("danhsachbaihat.php")
    @FormUrlEncoded
    Call<List<Baihat>> GetDanhsachbaihattheoplaylist(@Field("idplaylist") String idplaylist);

    @GET("danhsachcacplaylist.php")
    Call<List<Playlist>> GetDanhsachcacplaylist();

    @POST("danhsachbaihat.php")
    @FormUrlEncoded
    Call<List<Baihat>> GetDanhsachbaihattheotheloai(@Field("idtheloai") String idtheloai);

    @GET("tatcachude.php")
    Call<List<ChuDe>> GetAllChuDe();

    @POST("theloaitheochude.php")
    @FormUrlEncoded
    Call<List<TheLoai>> GetTheloaitheochude(@Field("idchude") String idchude);

    @POST("tatcaalbum.php")
    Call<List<Album>> GetAllAlbum();

    @POST("danhsachbaihat.php")
    @FormUrlEncoded
    Call<List<Baihat>> GetDanhsachbaihattheoalbum(@Field("idalbum") String idalbum);

    @POST("updateluotthich.php")
    @FormUrlEncoded
    Call<String> UpdateLuotThich(@Field("luotthich") String luotthich, @Field("idbaihat") String idbaihat);
}
