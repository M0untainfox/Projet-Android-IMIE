package com.example.mbp.projetandroidimie.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.mbp.projetandroidimie.R;
import com.example.mbp.projetandroidimie.adapters.adapterCase;
import com.example.mbp.projetandroidimie.adapters.adapters;
import com.example.mbp.projetandroidimie.listeners.GridViewListener;
import com.example.mbp.projetandroidimie.model.Case;
import com.example.mbp.projetandroidimie.model.Jeux;

/**
 * Created by mbp on 03/10/2017.
 */

public class Dames extends AppCompatActivity{

    GridView gv;
    Case[][] tab_case;
    Jeux[] tab_jeux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dames_layout);

        initGridView();


        /*Intent newIntent = new Intent(this,MenuActivity.class);
        newIntent.putExtra("result","you win the war");
        setResult(MesConstantes.RC_battleship,newIntent);
        //finish();*/
    }


    protected void initGridView(){

        gv = (GridView)findViewById(R.id.grid_viewDame);

        tab_jeux = new Jeux[6];


        tab_jeux[0] = new Jeux("a",R.drawable.dames,new Intent(this, Dames.class));
        tab_jeux[1] = new Jeux("a",R.drawable.sudoku,new Intent(this, Sudoku.class));
        tab_jeux[2] = new Jeux("a",R.drawable.p4,new Intent(this, P4.class));
        tab_jeux[3] = new Jeux("a",R.drawable.chevaux,new Intent(this, Horses.class));
        tab_jeux[4] = new Jeux("a",R.drawable.bn,new Intent(this, Battleship.class));
        tab_jeux[5] = new Jeux("a",R.drawable.echecs,new Intent(this, Chess.class));





        tab_case = new Case[8][8];

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((i%2 == 0 && j%2 ==0) || (i%2 == 1 && j%2 ==1)){
                    if(j<3){
                        tab_case[i][j] = new Case(true,R.drawable.p1);
                    }
                    else if(j>4){
                        tab_case[i][j] = new Case(true,R.drawable.p2);
                    }
                    else tab_case[i][j] = new Case(true,0);

                }
                else tab_case[i][j] = new Case(false,0);
            }
        }


        Case[] tabCaseFinal = new Case[64];

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                tabCaseFinal[j+8*i] = tab_case[j][i];
            }
        }

        gv.setAdapter(new adapterCase(this,R.layout.case_element,tabCaseFinal));


    }
}
