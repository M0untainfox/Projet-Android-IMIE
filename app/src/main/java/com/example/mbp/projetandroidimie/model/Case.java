package com.example.mbp.projetandroidimie.model;

import android.content.Intent;

/**
 * Created by mbp on 04/10/2017.
 */

public class Case {

    private boolean color;
    private int img;
    private int state;

    public Case(Boolean c, int v, int s){
        color = c;
        img = v;
        state = s;
    }

    public boolean getColor(){
        return color;
    }

    public int getImg(){
        return img;
    }

    public int getState(){
        return state;
    }

    public void setState(int s){
        state = s;
    }


}
