package com.example.tareaeva1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.tareaeva1.objects.AdapterRecyclerViewRol;
import com.example.tareaeva1.objects.Character;
import com.example.tareaeva1.objects.Rol;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        AdapterRecyclerViewRol.OnItemClick,
        View.OnClickListener

{
    RecyclerView recyclerViewRol;
    ArrayList<Rol> listRol;
    ArrayList<Character> rolTop;
    ArrayList<Character> rolJg;
    ArrayList<Character> rolMid;
    ArrayList<Character> rolAdc;
    ArrayList<Character> rolSupp;

    public static final String ROL = "rol";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewRol = findViewById(R.id.rv_rol);

        listRol = new ArrayList<>();
        rolTop = new ArrayList<>();
        rolJg = new ArrayList<>();
        rolMid = new ArrayList<>();
        rolAdc = new ArrayList<>();
        rolSupp = new ArrayList<>();

        recyclerViewRol.setLayoutManager(new LinearLayoutManager(this));

        fillRecyclerView();
        AdapterRecyclerViewRol adapter = new AdapterRecyclerViewRol(listRol, this);
        recyclerViewRol.setAdapter(adapter);
        recyclerViewRol.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }

    private void fillRecyclerView(){

        rolTop.add(new Character( "camille", R.drawable.camille, getResources().getString(R.string.camille)));
        rolTop.add(new Character( "nasus", R.drawable.nasus, getResources().getString(R.string.nasus)));
        rolTop.add(new Character( "pantheon", R.drawable.pantheon, getResources().getString(R.string.pantheon)));
        rolTop.add(new Character( "shen", R.drawable.shen, getResources().getString(R.string.shen)));
        rolTop.add(new Character( "trundle", R.drawable.trundle, getResources().getString(R.string.trundle)));

        rolJg.add(new Character("Kha'Zix", R.drawable.kha6, getResources().getString(R.string.kha6)));
        rolJg.add(new Character("rengar", R.drawable.rengar, getResources().getString(R.string.rengar)));
        rolJg.add(new Character("olaf", R.drawable.olaf, getResources().getString(R.string.olaf)));
        rolJg.add(new Character("sejuani", R.drawable.sejuani, getResources().getString(R.string.sejuani)));
        rolJg.add(new Character("elise", R.drawable.elise, getResources().getString(R.string.elise)));

        rolMid.add(new Character("akali", R.drawable.akali, getResources().getString(R.string.akali)));
        rolMid.add(new Character("katarina", R.drawable.katarina, getResources().getString(R.string.katarina)));
        rolMid.add(new Character("syndra", R.drawable.syndra, getResources().getString(R.string.syndra)));
        rolMid.add(new Character("ryze", R.drawable.ryze, getResources().getString(R.string.ryze)));
        rolMid.add(new Character("zed", R.drawable.zed, getResources().getString(R.string.zed)));

        rolAdc.add(new Character("ezreal", R.drawable.ezreal, getResources().getString(R.string.ezreal)));
        rolAdc.add(new Character("lucian", R.drawable.lucian, getResources().getString(R.string.lucian)));
        rolAdc.add(new Character("jinx", R.drawable.jinx, getResources().getString(R.string.jinx)));
        rolAdc.add(new Character("sivir", R.drawable.sivir, getResources().getString(R.string.sivir)));
        rolAdc.add(new Character("mf", R.drawable.mf, getResources().getString(R.string.mf)));

        rolSupp.add(new Character("sona", R.drawable.sona, getResources().getString(R.string.sona)));
        rolSupp.add(new Character("morgana", R.drawable.morgana, getResources().getString(R.string.morgana)));
        rolSupp.add(new Character("zyra", R.drawable.zyra, getResources().getString(R.string.zyra)));
        rolSupp.add(new Character("lux", R.drawable.lux, getResources().getString(R.string.lux)));
        rolSupp.add(new Character("rakan", R.drawable.rakan, getResources().getString(R.string.rakan)));



        listRol.add(new Rol(R.drawable.topline, rolTop, "Top"));
        listRol.add(new Rol(R.drawable.jungle, rolJg, "Jungle"));
        listRol.add(new Rol(R.drawable.mid, rolMid, "Mid"));
        listRol.add(new Rol(R.drawable.adc, rolAdc, "ADC"));
        listRol.add(new Rol(R.drawable.support, rolSupp, "Support"));

    }

    @Override
    public void onClick(Rol rol) {
        Intent intent = new Intent(getApplicationContext(), ChampionActivity.class);
        intent.putParcelableArrayListExtra(ROL, rol.getCharacters());
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }
}

