package com.example.mbp.projetandroidimie.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

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
    int fX;
    int fY;
    int step;
    adapterCase adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dames_layout);
        step =0;

        initGridView();

        final Button button = (Button) findViewById(R.id.btnMove);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dames.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });

        gv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                step++;

                int x = position%8;
                int y = position/8;

                Toast.makeText(Dames.this, "x = "+x+" y= "+y, Toast.LENGTH_SHORT).show();

                if(step == 1){
                    fX=x;
                    fY=y;
                    tabCaseFinal[position].setState(1);
                    adapter.notifyDataSetChanged();
                    gv.setAdapter(adapter);
                }
                else if(step ==2){
                    tabCaseFinal[8*fY+fX].setState(0);
                    move(fX,fY,x,y);
                    step = 0;
                }
            }
        });

    }


    public void move(int x,int y,int xar,int yar){

        if(tabCaseFinal[x+8*y].getImg()!=0 && tabCaseFinal[xar+8*yar].getColor() && tabCaseFinal[xar+8*yar].getImg()==0){ //case depart pleine et arrivée noir et vide
            Case tmp = tabCaseFinal[x+8*y];
            tabCaseFinal[x+8*y] = new Case(true,0,0);
            tabCaseFinal[xar+8*yar] = tmp;
            step=0;
        }
        adapter.notifyDataSetChanged();
        gv.setAdapter(adapter);
    }


    protected void initGridView(){

        gv = (GridView)findViewById(R.id.grid_viewDame);

        tab_case = new Case[8][8];

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((i%2 == 0 && j%2 ==0) || (i%2 == 1 && j%2 ==1)){
                    if(j<3){
                        tab_case[i][j] = new Case(true,R.drawable.cumlord,0);
                    }
                    else if(j>4){
                        tab_case[i][j] = new Case(true,R.drawable.gabe_noir,0);
                    }
                    else tab_case[i][j] = new Case(true,0,0);
                }
                else tab_case[i][j] = new Case(false,0,0);
            }
        }


        tabCaseFinal= new Case[64];

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                tabCaseFinal[j+8*i] = tab_case[j][i];
            }
        }

        adapter = new adapterCase(this,R.layout.case_element,tabCaseFinal);
        gv.setAdapter(adapter);


    }
}
