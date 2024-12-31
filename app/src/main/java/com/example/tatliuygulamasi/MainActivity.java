package com.example.tatliuygulamasi;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btng = findViewById(R.id.buttonGiris);
        ImageView img = findViewById(R.id.imageViewLogo);


        Animation logo = AnimationUtils.loadAnimation(this, R.anim.anim);
        img.startAnimation(logo);


        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        addInitialData(db);


        btng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git = new Intent(MainActivity.this, TatliListesiActivity.class);
                startActivity(git);
            }
        });

    }

    private void addInitialData(SQLiteDatabase db) {
        long count = db.compileStatement("SELECT COUNT(*) FROM " + DatabaseHelper.TABLE_TATLI).simpleQueryForLong();
        if (count == 0) {
            insertTatli(db, "Baklava", "Türk mutfağının eşsiz lezzeti.",
                    String.valueOf(R.drawable.baklava),
                    "https://www.youtube.com/watch?v=Ehf8igYTJVk&ab_channel=NefisYemekTarifleri",
                    "Yufka, ceviz, tereyağı, şeker, su, limon suyu");
            insertTatli(db, "Kadayıf", "İncecik tel kadayıf ve cevizle hazırlanan hafif bir lezzet.",
                    String.valueOf(R.drawable.kadayif),
                    "https://www.youtube.com/watch?v=rxDKJy1vQGw&ab_channel=NefisYemekTarifleri",
                    "Tel kadayıf, ceviz, tereyağı, şeker, su");
        }
    }

    private void insertTatli(SQLiteDatabase db, String isim, String aciklama, String resim, String video, String malzemeler) {

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ISIM, isim);
        values.put(DatabaseHelper.COLUMN_ACIKLAMA, aciklama);
        values.put(DatabaseHelper.COLUMN_RESIM, resim);
        values.put(DatabaseHelper.COLUMN_VIDEO, video);
        values.put(DatabaseHelper.COLUMN_MALZEMELER, malzemeler);
        db.insert(DatabaseHelper.TABLE_TATLI, null, values);
    }
}
