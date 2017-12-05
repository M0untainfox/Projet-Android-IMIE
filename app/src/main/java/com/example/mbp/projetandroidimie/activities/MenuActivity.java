package com.example.mbp.projetandroidimie.activities;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.widget.GridView;
import android.widget.Toast;

import com.example.mbp.projetandroidimie.MesConstantes;
import com.example.mbp.projetandroidimie.R;
import com.example.mbp.projetandroidimie.adapters.adapters;
import com.example.mbp.projetandroidimie.listeners.GridViewListener;
import com.example.mbp.projetandroidimie.model.Jeux;

/**
 * Created by mbp on 02/10/2017.
 */


public class MenuActivity extends AppCompatActivity {

    String[] mes_jeux;
    GridView gv;
    Jeux[] tab_jeux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu_activity);

         mes_jeux = getResources().getStringArray(R.array.ar_jeux);

        initGridView();
    }

    protected void initGridView(){
        gv = (GridView)findViewById(R.id.grid_view);



        tab_jeux = new Jeux[mes_jeux.length+1];

        tab_jeux[0] = new Jeux(mes_jeux[0],R.drawable.dames,new Intent(this, Dames.class));
        tab_jeux[1] = new Jeux(mes_jeux[1],R.drawable.sudoku,new Intent(this, Sudoku.class));
        tab_jeux[2] = new Jeux(mes_jeux[2],R.drawable.p4,new Intent(this, P4.class));
        tab_jeux[3] = new Jeux(mes_jeux[3],R.drawable.chevaux,new Intent(this, Horses.class));
        tab_jeux[4] = new Jeux(mes_jeux[4],R.drawable.bn,new Intent(this, Battleship.class));
        tab_jeux[5] = new Jeux(mes_jeux[5],R.drawable.echecs,new Intent(this, Chess.class));

        tab_jeux[6] = new Jeux("SQL",R.drawable.echecs,new Intent(this, Sql.class));

        gv.setOnItemClickListener(new GridViewListener(this));
        gv.setAdapter(new adapters(this,R.layout.mes_jeux_element,tab_jeux));

        /*if(MesConstantes.RQC_battleship==999 && MesConstantes.RC_battleship==998){
            onActivityResult(MesConstantes.RQC_battleship,MesConstantes.RC_battleship,);
        }*/


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==MesConstantes.RQC_battleship && resultCode==MesConstantes.RC_battleship){
           // Toast.makeText(this,data.getStringExtra("result"), Toast.LENGTH_LONG).show();
        }
    }
}
