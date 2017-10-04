package com.example.mbp.projetandroidimie.model;

import android.content.Intent;

/**
 * Created by mbp on 02/10/2017.
 */

public class Jeux {

    private String nom;
    private int image;
    private Intent game;

    public Jeux(String n, int i){
        nom = n;
        image = i;
    }

    public Jeux(String n, int i,Intent g){
        nom = n;
        image = i;
        game = g;
    }

    public int getImg(){
        return image;
    }

    public String getNom(){
        return nom;
    }

    public Intent getIntent(){
        return game;
    }

}
