package com.example.googleadmobintegration.Adapters;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.googleadmobintegration.R;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {

    ArrayList<Integer>models;

    public ImageAdapter(ArrayList<Integer> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {
            holder.Bind(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ImageHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);

        }
        public void Bind(int id)
        {
            img.setImageResource(id);
        }
    }
}
