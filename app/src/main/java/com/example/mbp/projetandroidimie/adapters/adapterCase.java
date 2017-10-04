package com.example.mbp.projetandroidimie.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mbp.projetandroidimie.R;
import com.example.mbp.projetandroidimie.model.Case;
import com.example.mbp.projetandroidimie.model.Jeux;

import java.util.zip.Inflater;

/**
 * Created by mbp on 02/10/2017.
 */

public class adapterCase extends ArrayAdapter {

    public Context ctx;
    public Case[] Case;
    int monLayout;

    public adapterCase(@NonNull Context context, @LayoutRes int resource, @NonNull Case[] objects) {
        super(context, resource, objects);
        ctx = context;
        monLayout=resource;
        Case = objects;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Case jx = Case[position];
        ViewHolderPattern vhp;
        if(convertView==null){
            convertView = (LinearLayout) LayoutInflater.from(ctx).inflate(monLayout,null);
            ImageView txtv =(ImageView) convertView.findViewById(R.id.txtViewCase);
            if(jx.getImg()!=0) txtv.setImageResource(jx.getImg());

            vhp = new ViewHolderPattern(txtv);

            convertView.setTag(vhp);
        }
        else{
            vhp = (ViewHolderPattern) convertView.getTag();
        }
        if(jx.getColor()){
            vhp.tx.setBackgroundResource(R.drawable.case_noir);
        }
        else vhp.tx.setBackgroundResource(R.drawable.case_blanche);
        if(jx.getImg()!=0) vhp.tx.setImageResource(jx.getImg());
        return convertView;


    }

    public class ViewHolderPattern {
        public ImageView tx;

        public ViewHolderPattern(ImageView tx){
            this.tx = tx;
        }

    }


}
