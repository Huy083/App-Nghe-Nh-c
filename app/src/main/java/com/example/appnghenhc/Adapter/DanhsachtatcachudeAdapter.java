package com.example.appnghenhc.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.appnghenhc.Model.ChuDe;
import com.example.appnghenhc.R;
import com.example.appnghenhc.activity.DanhsachtheloaitheochudeActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachtatcachudeAdapter extends RecyclerView.Adapter<DanhsachtatcachudeAdapter.ViewHolder>{

    Context context;
    ArrayList<ChuDe>mangchude;

    public DanhsachtatcachudeAdapter(Context context, ArrayList<ChuDe> mangchude) {
        this.context = context;
        this.mangchude = mangchude;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_cac_chu_de,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChuDe chuDe = mangchude.get(position);
        Picasso.with(context).load(chuDe.getHinhChuDe()).into(holder.imgchude);
    }

    @Override
    public int getItemCount() {
        return mangchude.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgchude;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgchude = itemView.findViewById(R.id.imageviewdongcacchucde);
            imgchude.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DanhsachtheloaitheochudeActivity.class);
                    intent.putExtra("chude",mangchude.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
