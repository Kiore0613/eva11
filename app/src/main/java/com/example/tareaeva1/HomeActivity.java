package com.example.tareaeva1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageViewExit, imageViewHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        imageViewExit = findViewById(R.id.img_exit);
        imageViewHome = findViewById(R.id.img_home);

        setTitle("Datos Personales");

        imgButton();
    }

    public void imgButton() {
        imageViewHome.setOnClickListener(this);
        imageViewExit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_exit:
                finishAffinity();
                break;
            case R.id.img_home:
                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it);
        }
    }
}
