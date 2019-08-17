package com.example.tareaeva1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class ChampionActivity extends AppCompatActivity  implements View.OnClickListener{

    ImageView imageViewBack, imageViewExit;
    RecyclerView recyclerViewRoles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        imageViewBack = findViewById(R.id.img_back);
        imageViewExit = findViewById(R.id.img_exit);
        recyclerViewRoles = findViewById(R.id.rv_rol);

        setTitle("Roles");

        imgButton();
    }

    public void imgButton() {
        imageViewBack.setOnClickListener(this);
        imageViewExit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_exit:
                finishAffinity();
                break;

        }

    }
    }
