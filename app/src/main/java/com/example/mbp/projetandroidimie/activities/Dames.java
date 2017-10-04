package com.example.mbp.projetandroidimie.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mbp.projetandroidimie.MesConstantes;
import com.example.mbp.projetandroidimie.R;

/**
 * Created by mbp on 03/10/2017.
 */

public class Dames extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dames_laytout);



        /*Intent newIntent = new Intent(this,MenuActivity.class);
        newIntent.putExtra("result","you win the war");
        setResult(MesConstantes.RC_battleship,newIntent);
        //finish();*/
    }
}
