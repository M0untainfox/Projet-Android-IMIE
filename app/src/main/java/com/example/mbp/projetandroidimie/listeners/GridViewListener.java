package com.example.mbp.projetandroidimie.listeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mbp.projetandroidimie.MesConstantes;
import com.example.mbp.projetandroidimie.R;
import com.example.mbp.projetandroidimie.activities.Battleship;
import com.example.mbp.projetandroidimie.activities.MenuActivity;
import com.example.mbp.projetandroidimie.model.Jeux;

import static android.support.v4.app.ActivityCompat.startActivityForResult;
import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by mbp on 03/10/2017.
 */


public class GridViewListener implements AdapterView.OnItemClickListener {

    Activity act;
    public GridViewListener(Activity activi){
        this.act = activi;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Jeux jx = (Jeux) parent.getAdapter().getItem(position);
        Toast.makeText(view.getContext(),jx.getNom(), LENGTH_LONG).show();

        view.getContext().startActivity(jx.getIntent());
    }
}
