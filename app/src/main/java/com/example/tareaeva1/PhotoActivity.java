package com.example.tareaeva1;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tareaeva1.objects.Photo;

public class PhotoActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageViewPhoto,imageViewBack, imageViewExit;
    Bitmap photoImg;
    public static final String IMG = "image";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        imageViewBack = findViewById(R.id.img_back);
        imageViewExit = findViewById(R.id.img_exit);
        imageViewPhoto = findViewById(R.id.image_view_photo);
        setTitle("Photo");

        Photo photo = (getIntent().getExtras()).getParcelable(IMG);

        photoImg = photo.getPhoto();

        imageViewPhoto.setImageBitmap(photoImg);

        imgButton();
    }
    public void imgButton() {
        imageViewBack.setOnClickListener(this);
        imageViewExit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.img_exit:
                finishAffinity();
                break;
        }

    }
}