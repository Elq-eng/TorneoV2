package com.example.torneov1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterInm extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<String> names,inmu;

    public AdapterInm(Context context, int layout, ArrayList<String> names, ArrayList<String> inmu) {
        this.context = context;
        this.layout = layout;
        this.names = names;
        this.inmu = inmu;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }


}
