package com.example.mbp.projetandroidimie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mbp.projetandroidimie.activities.MenuActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goCheck(View v){
        EditText v_login = (EditText)findViewById(R.id.editTextLog);
        EditText v_pwd = (EditText)findViewById(R.id.editTextPwd);

        String login_saisi = v_login.getText().toString();
        String password_saisi = v_pwd.getText().toString();

        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);

        /*
        if(login_saisi.equals(MesConstantes.MY_LOG) && password_saisi.equals(MesConstantes.MY_PWD)){
            Toast.makeText(this, "Login OK", Toast.LENGTH_LONG).show();
            Intent myIntent = new Intent(this, MenuActivity.class);
            startActivity(myIntent);
        }
        else{
            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
        }

        */

    }

    public void btnLoad(View v){
        SharedPreferences sp = v.getContext().getSharedPreferences("JEUX_PREFS",MODE_PRIVATE);

        EditText v_login = (EditText)findViewById(R.id.editTextLog);
        EditText v_pwd = (EditText)findViewById(R.id.editTextPwd);

        v_login.setText(sp.getString(MesConstantes.LOG,""));
        v_pwd.setText(sp.getString(MesConstantes.PWD,""));
    }

    public void btnSave(View v){
        SharedPreferences sp = v.getContext().getSharedPreferences("JEUX_PREFS",MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();

        EditText v_login = (EditText)findViewById(R.id.editTextLog);
        EditText v_pwd = (EditText)findViewById(R.id.editTextPwd);

        String log = v_login.getText().toString();
        String pwd = v_pwd.getText().toString();

        ed.putString(MesConstantes.LOG,log);
        ed.putString(MesConstantes.PWD,pwd);

        ed.apply();
    }

}
