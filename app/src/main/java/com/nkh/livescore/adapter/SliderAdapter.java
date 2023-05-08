package com.nkh.livescore.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nkh.livescore.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder> {

    Context context;

    List<Integer> images;
    public SliderAdapter(Context context, List<Integer> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner, null);
        return new SliderAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, final int position) {

        viewHolder.imageViewBackground.setBackgroundResource(images.get(position));
//        viewHolder.imageViewBackground.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch (position){
//                    case 1:
//
//                }
//            }
//        });
    }

    @Override
    public int getCount() {
        Log.e("hung9", "getCount: "+ images.size() );
        return images.size();
    }

    static class SliderAdapterViewHolder extends ViewHolder {
        View itemView;
        ImageView imageViewBackground;
        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.image_banner);
            this.itemView = itemView;
        }
    }
}

