package com.example.tatliuygulamasi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TatliDetayActivity extends AppCompatActivity {

     VideoView videoViewTatli;
     TextView textViewMalzemeler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tatli_detay);

        videoViewTatli = findViewById(R.id.videoViewTatli);
        textViewMalzemeler = findViewById(R.id.textViewMalzemeler);



        String videoUrl = getIntent().getStringExtra("videoUrl");
        String malzemeler = getIntent().getStringExtra("malzemeler");

        if (videoUrl != null && !videoUrl.isEmpty())
        {
            Uri videoUri = Uri.parse(videoUrl);
            videoViewTatli.setVideoURI(videoUri);
            videoViewTatli.start();
        }
        else
        {
            Log.e("TatliDetayActivity", "Geçersiz veya eksik video URL");
        }


        if (malzemeler != null && !malzemeler.isEmpty())
        {
            textViewMalzemeler.setText(malzemeler);
        }
        else
        {
            textViewMalzemeler.setText("Malzemeler bilgisi mevcut değil.");
        }
    }

}

