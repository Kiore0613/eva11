package com.example.tareaeva1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.tareaeva1.objects.AdapterRecyclerViewRol;
import com.example.tareaeva1.objects.Characters;
import com.example.tareaeva1.objects.Rol;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        AdapterRecyclerViewRol.OnItemClick,
        View.OnClickListener

{
    RecyclerView recyclerViewRol;
    ArrayList<Rol> listRol;
    ArrayList<Characters> rolTop;
    ArrayList<Characters> rolJg;
    ArrayList<Characters> rolMid;
    ArrayList<Characters> rolAdc;
    ArrayList<Characters> rolSupp;


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

        rolTop.add(new Characters( "camille", R.drawable.camille, getResources().getString(R.string.camille)));
        rolTop.add(new Characters( "nasus", R.drawable.nasus, getResources().getString(R.string.nasus)));
        rolTop.add(new Characters( "pantheon", R.drawable.pantheon, getResources().getString(R.string.pantheon)));
        rolTop.add(new Characters( "shen", R.drawable.shen, getResources().getString(R.string.shen)));
        rolTop.add(new Characters( "trundle", R.drawable.trundle, getResources().getString(R.string.trundle)));

        rolJg.add(new Characters("Kha'Zix", R.drawable.kha6, getResources().getString(R.string.kha6)));
        rolJg.add(new Characters("rengar", R.drawable.rengar, getResources().getString(R.string.rengar)));
        rolJg.add(new Characters("olaf", R.drawable.olaf, getResources().getString(R.string.olaf)));
        rolJg.add(new Characters("sejuani", R.drawable.sejuani, getResources().getString(R.string.sejuani)));
        rolJg.add(new Characters("elise", R.drawable.elise, getResources().getString(R.string.elise)));

        rolMid.add(new Characters("akali", R.drawable.akali, getResources().getString(R.string.akali)));
        rolMid.add(new Characters("katarina", R.drawable.katarina, getResources().getString(R.string.katarina)));
        rolMid.add(new Characters("syndra", R.drawable.syndra, getResources().getString(R.string.syndra)));
        rolMid.add(new Characters("ryze", R.drawable.ryze, getResources().getString(R.string.ryze)));
        rolMid.add(new Characters("zed", R.drawable.zed, getResources().getString(R.string.zed)));

        rolAdc.add(new Characters("ezreal", R.drawable.ezreal, getResources().getString(R.string.ezreal)));
        rolAdc.add(new Characters("lucian", R.drawable.lucian, getResources().getString(R.string.lucian)));
        rolAdc.add(new Characters("jinx", R.drawable.jinx, getResources().getString(R.string.jinx)));
        rolAdc.add(new Characters("sivir", R.drawable.sivir, getResources().getString(R.string.sivir)));
        rolAdc.add(new Characters("mf", R.drawable.mf, getResources().getString(R.string.mf)));

        rolMid.add(new Characters("sona", R.drawable.sona, getResources().getString(R.string.sona)));
        rolMid.add(new Characters("morgana", R.drawable.morgana, getResources().getString(R.string.morgana)));
        rolMid.add(new Characters("zyra", R.drawable.zyra, getResources().getString(R.string.zyra)));
        rolMid.add(new Characters("lux", R.drawable.lux, getResources().getString(R.string.lux)));
        rolMid.add(new Characters("rakan", R.drawable.rakan, getResources().getString(R.string.rakan)));



        listRol.add(new Rol(R.drawable.topline, rolTop, "Top"));
        listRol.add(new Rol(R.drawable.jungle, rolMid, "Jungle"));
        listRol.add(new Rol(R.drawable.mid, rolAdc, "Mid"));
        listRol.add(new Rol(R.drawable.adc, rolAdc, "ADC"));
        listRol.add(new Rol(R.drawable.support, rolSupp, "Support"));


    }

    public void intent() {
        Intent it = new Intent(getApplicationContext(), ChampionActivity.class);
        startActivity(it);
    }


    @Override
    public void onClick(Rol imageCharacter) {
        intent();
    }

    @Override
    public void onClick(View v) {

    }
}

