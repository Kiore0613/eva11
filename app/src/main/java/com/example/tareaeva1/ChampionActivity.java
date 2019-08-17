package com.example.tareaeva1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.tareaeva1.objects.AdapterRecyclerViewChampion;
import com.example.tareaeva1.objects.Characters;

import java.util.ArrayList;

public class ChampionActivity extends AppCompatActivity  implements
        AdapterRecyclerViewChampion.OnItemClick,
        View.OnClickListener
{

    ImageView imageViewBack, imageViewExit;
    RecyclerView recyclerViewChampion;
    ArrayList<Characters>listChampion;

    public static final String ROL = "rol";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion);

        imageViewBack = findViewById(R.id.img_back);
        imageViewExit = findViewById(R.id.img_exit);
        recyclerViewChampion = findViewById(R.id.rv_champion);
        listChampion = new ArrayList<>();
        setTitle("Roles");

        ArrayList<Characters> characters = getIntent().getExtras().getParcelableArrayList(ROL);

        recyclerViewChampion.setLayoutManager(new LinearLayoutManager(this));

        AdapterRecyclerViewChampion adapter = new AdapterRecyclerViewChampion(characters, this);
        recyclerViewChampion.setAdapter(adapter);
        recyclerViewChampion.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        imgButton();

    }

    public void imgButton() {
        imageViewBack.setOnClickListener(this);
        imageViewExit.setOnClickListener(this);

    }

    @Override
    public void onClick(Characters listChampion) {
        Intent intent = new Intent(getApplicationContext(), DescriptionActivity.class);

        startActivity(intent);
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

