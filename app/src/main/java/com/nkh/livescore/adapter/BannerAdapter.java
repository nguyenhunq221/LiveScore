package com.nkh.livescore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nkh.livescore.R;

import java.util.ArrayList;


public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder>{

    Context context;
    ArrayList<Integer> mList;

    public BannerAdapter(Context context, ArrayList<Integer> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner,parent,false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {

        Glide.with(context)
                .load(mList.get(position))
                .into(holder.imageBanner);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder{

        ImageView imageBanner;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageBanner = itemView.findViewById(R.id.image_banner);
        }
    }
}
