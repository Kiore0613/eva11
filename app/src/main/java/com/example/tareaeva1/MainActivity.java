package com.example.tareaeva1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.tareaeva1.objects.AdapterRecyclerViewPhoto;
import com.example.tareaeva1.objects.Photo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        AdapterRecyclerViewPhoto.OnItemClick,
        View.OnClickListener

{
    RecyclerView recyclerViewPhoto;
    ArrayList<Photo> listPhoto;

    ImageView imageViewExit, imageViewBack, imageViewPhoto;

     final static String IMG = "image";
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPhoto = findViewById(R.id.rv_photo);
        imageViewBack = findViewById(R.id.img_back);
        imageViewExit = findViewById(R.id.img_exit);
        imageViewPhoto = findViewById(R.id.img_make_photo);

        listPhoto = new ArrayList<>();

        recyclerViewPhoto.setLayoutManager(new LinearLayoutManager(this));
        AdapterRecyclerViewPhoto adapter = new AdapterRecyclerViewPhoto(listPhoto, this);
        recyclerViewPhoto.setAdapter(adapter);
        recyclerViewPhoto.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter.notifyDataSetChanged();
        imgButton();
    }


    @Override
    public void onClickListener(Photo photo) {
        Intent intent = new Intent(getApplicationContext(), PhotoActivity.class);
        intent.putExtra(IMG, photo.getPhoto());
        startActivity(intent);
    }
    public void imgButton() {
        imageViewBack.setOnClickListener(this);
        imageViewExit.setOnClickListener(this);
        imageViewPhoto.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_exit:
                finishAffinity();
                break;
            case R.id.img_back:
               finish();
               break;
            case R.id.img_make_photo:
                Intent takePhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePhoto.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePhoto, REQUEST_IMAGE_CAPTURE);
                }
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            listPhoto.add(new Photo(imageBitmap));

        }
    }
}

