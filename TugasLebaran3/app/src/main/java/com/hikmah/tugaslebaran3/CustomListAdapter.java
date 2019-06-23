package com.hikmah.tugaslebaran3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {

    private Context context;
    private String[] namaBuah;
    private  int[] gambarBuah;

    //membuat konstrakter
    public CustomListAdapter(Context context1, String[] namaBuah, int[] gambarBuah) {
        super(context1, R.layout.item_buah, namaBuah);
        this.context = context1;
        this.namaBuah = namaBuah;
        this.gambarBuah = gambarBuah;
    }

    //getView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //atur layout item, findViewById perkomponen, set data
        LayoutInflater layoutInflater;
        View view = LayoutInflater.from(context).inflate(R.layout.item_buah, parent, false);

        TextView tvNamaBuah = view.findViewById(R.id.tv_item_nama);
        ImageView ivGambarBuah = view.findViewById(R.id.iv_item_gambar);

        tvNamaBuah.setText(namaBuah[position]);
        ivGambarBuah.setImageResource(gambarBuah[position]);

        return view;
    }
}
