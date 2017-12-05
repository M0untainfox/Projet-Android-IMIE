package com.example.mbp.projetandroidimie.SQLite;

/**
 * Created by mbp on 04/12/2017.
 */

public class Personne {
    private String Nom;
    private String Prenom;
    private String num;


    public Personne(String n,String p,String nb){
        Nom = n;
        Prenom = p;
        num = nb;
    }

    public String getNom(){
        return Nom;
    }

    public String getPrenom(){
        return Prenom;
    }

    public String getNum(){
        return num;
    }

}
