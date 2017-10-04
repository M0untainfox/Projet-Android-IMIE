package com.example.mbp.projetandroidimie.model;

import android.content.Intent;

/**
 * Created by mbp on 04/10/2017.
 */

public class Case {

    private boolean color;
    private int img;

    public Case(Boolean c, int v){
        color = c;
        img = v;
    }

    public boolean getColor(){
        return color;
    }

    public int getImg(){
        return img;
    }


}
