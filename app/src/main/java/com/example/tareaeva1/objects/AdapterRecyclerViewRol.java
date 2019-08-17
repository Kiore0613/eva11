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

public class AdapterRecyclerViewRol extends RecyclerView.Adapter<AdapterRecyclerViewRol.ViewHolderRol> {

    ArrayList<Rol> listRol;
    OnItemClick callback;

    public AdapterRecyclerViewRol(ArrayList<Rol> listRol, OnItemClick callback) {
        this.listRol = listRol;
        this.callback = callback;
    }

    public interface OnItemClick {
        void onClick(Rol imageCharacter);
    }
    @NonNull
    @Override
    public AdapterRecyclerViewRol.ViewHolderRol onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview_main_activity, parent, false);

        return new ViewHolderRol(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderRol holder, final int position) {
        holder.imageViewRol.setImageResource(listRol.get(position).getRol());
        holder.textViewRol.setText(listRol.get(position).getRolName());


        holder.imageViewRol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClick(listRol.get(position));
            }
        });

    }
    @Override
    public int getItemCount() {
        return listRol.size();

    }

    public class ViewHolderRol extends RecyclerView.ViewHolder {

        ImageView imageViewRol;
        TextView textViewRol;

        public ViewHolderRol(View itemView) {
            super(itemView);

            imageViewRol = itemView.findViewById(R.id.img_rol);
            textViewRol = itemView.findViewById(R.id.tv_rol_name);

        }
    }

}
