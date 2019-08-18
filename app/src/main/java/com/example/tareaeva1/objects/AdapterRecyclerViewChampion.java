package com.example.tareaeva1.objects;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tareaeva1.R;

import java.util.ArrayList;

public class AdapterRecyclerViewChampion extends RecyclerView.Adapter<AdapterRecyclerViewChampion.ViewHolderChampion> {

    ArrayList<Character> listChampion;
    OnItemClick callback;

    public AdapterRecyclerViewChampion(ArrayList<Character> listChampion, OnItemClick callback) {
        this.listChampion = listChampion;
        this.callback = callback;
    }

    public interface OnItemClick {
        void onClick(Character characters);
    }
    @NonNull
    @Override
    public AdapterRecyclerViewChampion.ViewHolderChampion onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview_champion_activity, parent, false);

        return new ViewHolderChampion(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderChampion holder, final int position) {
        holder.imageViewChampion.setImageResource(listChampion.get(position).getImageChampion());
        holder.textViewChampionName.setText(listChampion.get(position).getName());
        holder.textViewChampionInfo.setText(listChampion.get(position).getInfo());


        holder.imageViewChampion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClick(listChampion.get(position));
            }
        });

    }
    @Override
    public int getItemCount() {
        return listChampion.size();

    }

    public class ViewHolderChampion extends RecyclerView.ViewHolder {

        ImageView imageViewChampion;
        TextView textViewChampionName, textViewChampionInfo;

        public ViewHolderChampion(View itemView) {
            super(itemView);

            imageViewChampion = itemView.findViewById(R.id.img_champion);
            textViewChampionName = itemView.findViewById(R.id.tv_champion_name);
            textViewChampionInfo = itemView.findViewById(R.id.tv_champion_info);

        }
    }

}