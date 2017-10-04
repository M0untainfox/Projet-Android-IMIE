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
import com.example.mbp.projetandroidimie.model.Jeux;

import java.util.zip.Inflater;

/**
 * Created by mbp on 02/10/2017.
 */

public class adapters extends ArrayAdapter {

    public Context ctx;
    public Jeux[] jeux;
    int monLayout;

    public adapters(@NonNull Context context, @LayoutRes int resource, @NonNull Jeux[] objects) {
        super(context, resource, objects);
        ctx = context;
        monLayout=resource;
        jeux = objects;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Jeux jx = jeux[position];
        ViewHolderPattern vhp;
        if(convertView==null){
            convertView = (LinearLayout) LayoutInflater.from(ctx).inflate(monLayout,null);
            ImageView imgv = (ImageView) convertView.findViewById(R.id.imgViewJeux);
            TextView txtv =(TextView) convertView.findViewById(R.id.txtViewJeux);
            txtv.setText(jx.getNom());
            imgv.setImageResource(jx.getImg());

            vhp = new ViewHolderPattern(imgv,txtv);

            convertView.setTag(vhp);
        }
        else{
           vhp = (ViewHolderPattern) convertView.getTag();
        }
        vhp.tx.setText((jx.getNom()));
        vhp.im.setImageResource(jx.getImg());
        //Log.e("debug", "getView: ",null);
        return convertView;


    }

    public class ViewHolderPattern {
        public ImageView im;
        public TextView tx;

        public ViewHolderPattern(ImageView im,TextView tx){
            this.tx = tx;
            this.im = im;
        }

    }


}
