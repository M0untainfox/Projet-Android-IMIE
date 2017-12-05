package com.example.mbp.projetandroidimie.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mbp.projetandroidimie.R;

/**
 * Created by mbp on 04/12/2017.
 */

public class MyCursorAdapter extends CursorAdapter {


    public MyCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // inflater inflater.from
        //parent = (LinearLayout) LayoutInflater.from(context).inflate(layout_listview,null);
        return LayoutInflater.from(context).inflate(R.layout.layout_listview,null);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tv1 = (TextView) view.findViewById(R.id.tv_lv1);
        TextView tv2 = (TextView) view.findViewById(R.id.tv_lv2);
        TextView tv3 = (TextView) view.findViewById(R.id.tv_lv3);
        // put data
        tv1.setText(cursor.getString(1));
        tv3.setText(cursor.getString(2));


    }
}
