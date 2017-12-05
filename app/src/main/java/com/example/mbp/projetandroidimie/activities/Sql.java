package com.example.mbp.projetandroidimie.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.example.mbp.projetandroidimie.SQLite.*;

import com.example.mbp.projetandroidimie.MesConstantes;
import com.example.mbp.projetandroidimie.R;
import com.example.mbp.projetandroidimie.adapters.MyCursorAdapter;

/**
 * Created by mbp on 03/10/2017.
 */

public class Sql extends AppCompatActivity {
    Personne_Manager pm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sql);

        final Button buttonInsert = (Button) findViewById(R.id.btn_sql);
        final Button buttonRead = (Button) findViewById(R.id.btn_readSql);
        final EditText txtName = (EditText) findViewById(R.id.input_name);
        final EditText txtSurname = (EditText) findViewById(R.id.input_surname);
        final EditText txtNumber = (EditText) findViewById(R.id.input_surname);

        pm = new Personne_Manager(Sql.this);
        pm.open();

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Personne p = new Personne(txtName.getText().toString(),txtSurname.getText().toString(),txtNumber.getText().toString());
                pm.insertPersonne(p);


                Toast.makeText(Sql.this, "insert" , Toast.LENGTH_SHORT).show();
            }
        });

        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor c = pm.getAll();
                MyCursorAdapter mc = new MyCursorAdapter(Sql.this,c,0);
                ListView lv = (ListView) findViewById(R.id.ListView_SQL);

                lv.setAdapter(mc);

                Toast.makeText(Sql.this, "Read" , Toast.LENGTH_SHORT).show();
            }
        });


    }
}