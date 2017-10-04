package com.example.mbp.projetandroidimie.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    Case[] tabCaseFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dames_layout);

        initGridView();

        final Button button = (Button) findViewById(R.id.btnMove);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                move();
            }
        });

    }

    public void move(){

        int i = 0;
        int j = 0;


        Case tmp = tabCaseFinal[0];
        tabCaseFinal[0] = new Case(true,0);
        tabCaseFinal[25] = tmp;

        gv.setAdapter(new adapterCase(this,R.layout.case_element,tabCaseFinal));
    }


    protected void initGridView(){

        gv = (GridView)findViewById(R.id.grid_viewDame);

        tab_case = new Case[8][8];

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((i%2 == 0 && j%2 ==0) || (i%2 == 1 && j%2 ==1)){
                    if(j<3){
                        tab_case[i][j] = new Case(true,R.drawable.cumlord);
                    }
                    else if(j>4){
                        tab_case[i][j] = new Case(true,R.drawable.gabe_noir);
                    }
                    else tab_case[i][j] = new Case(true,0);

                }
                else tab_case[i][j] = new Case(false,0);
            }
        }


        tabCaseFinal= new Case[64];

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                tabCaseFinal[j+8*i] = tab_case[j][i];
            }
        }

        gv.setAdapter(new adapterCase(this,R.layout.case_element,tabCaseFinal));


    }
}
