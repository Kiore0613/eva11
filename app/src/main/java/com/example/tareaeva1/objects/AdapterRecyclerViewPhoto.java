package com.example.tareaeva1.objects;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.tareaeva1.R;
import java.util.ArrayList;

public class AdapterRecyclerViewPhoto extends RecyclerView.Adapter<AdapterRecyclerViewPhoto.ViewHolderRol> {

    ArrayList<Photo> listPhoto;
    OnItemClick callback;

    public AdapterRecyclerViewPhoto(ArrayList<Photo> listPhoto, OnItemClick callback) {
        this.listPhoto = listPhoto;
        this.callback = callback;
    }

    public interface OnItemClick {
        void onClickListener(Photo photo);
    }
    @NonNull
    @Override
    public AdapterRecyclerViewPhoto.ViewHolderRol onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview_main_activity, parent, false);

        return new ViewHolderRol(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderRol holder, final int position) {
        holder.imageViewPhoto.setImageBitmap(listPhoto.get(position).getPhoto());

        holder.imageViewPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClickListener(listPhoto.get(position));
            }
        });

    }
    @Override
    public int getItemCount() {
        return listPhoto.size();

    }

    public class ViewHolderRol extends RecyclerView.ViewHolder {

        ImageView imageViewPhoto;

        public ViewHolderRol(View itemView) {
            super(itemView);

            imageViewPhoto = itemView.findViewById(R.id.img_photo);


        }
    }

}
