package com.example.tareaeva1;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tareaeva1.objects.Character;

import java.util.Objects;

public class DescriptionActivity extends AppCompatActivity {

    final static String CHAMP = "character";
    TextView textViewName, textViewInfo;
    ImageView imageViewChampion;
    String name, info;
    int championImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        textViewName = findViewById(R.id.tv_name);
        textViewInfo = findViewById(R.id.tv_info);
        imageViewChampion = findViewById(R.id.img_champion_info);

        setTitle("Descripcion");

        Character champion =  (getIntent().getExtras()).getParcelable(CHAMP);
        name = champion.getName();
        info =champion.getInfo();
        championImage = champion.getImageChampion();

        textViewInfo.setText(info);
        textViewName.setText(name);
        imageViewChampion.setImageResource(championImage);

    }
}
