package com.example.tatliuygulamasi;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class TatliListesiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tatli_listesi);


        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        ArrayList<Tatli> tatlilar = getTatliList(db);


        CustomAdapter adapter = new CustomAdapter(this, tatlilar);
        ListView listView = findViewById(R.id.listViewTatli);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(TatliListesiActivity.this, TatliDetayActivity.class);
                startActivity(intent);
            }
        });
    }

    private ArrayList<Tatli> getTatliList(SQLiteDatabase db) {

        ArrayList<Tatli> tatlilar = new ArrayList<>();
        Cursor cursor = db.query(DatabaseHelper.TABLE_TATLI, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID));
            String isim = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ISIM));
            String aciklama = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ACIKLAMA));
            String resim = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_RESIM));
            String video = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_VIDEO));
            String malzemeler = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_MALZEMELER));
            tatlilar.add(new Tatli(id, isim, aciklama, resim, video, malzemeler));
        }
        cursor.close();
        return tatlilar;
    }
}


