package com.example.tatliuygulamasi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Tatli> tatliListesi;

    public CustomAdapter(Context context, ArrayList<Tatli> tatliListesi) {
        this.context = context;
        this.tatliListesi = tatliListesi;
    }

    @Override
    public int getCount() {
        return tatliListesi.size();
    }

    @Override
    public Object getItem(int position) {
        return tatliListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.tatli_item, parent, false);

        ImageView imageViewTatliResim = convertView.findViewById(R.id.imageViewTatliResim);
        TextView textViewTatliIsim = convertView.findViewById(R.id.textViewTatliIsim);
        TextView textViewTatliAciklama = convertView.findViewById(R.id.textViewTatliAciklama);


        Tatli tatli = tatliListesi.get(position);
        imageViewTatliResim.setImageResource(tatli.getResim());
        textViewTatliIsim.setText(tatli.getIsim());
        textViewTatliAciklama.setText(tatli.getAciklama());



        Picasso.get()
                .load("https://images.dedocloud.com/images/firmalar/firma_392/album/X/50602_2_392_firma-album_X.jpg")
                .resize(900, 950)
                .centerCrop()
                .into(imageViewTatliResim);


        return convertView;
    }
}
