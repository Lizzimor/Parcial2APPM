package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.time.Instant;

public class MainActivity3 extends AppCompatActivity {

    Button btnClose;
    public static final String dataUser = "dataUser";
    private static final int modoPrivate = Context.MODE_PRIVATE;
    TextView txtName, txtPrograma;
    ImageView img_Actor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btnClose = findViewById(R.id.btnClose);
        txtName = findViewById(R.id.txtName);
        img_Actor = findViewById(R.id.img_Actor);
        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("Actor_name");
            String imagen = intent.getStringExtra("Actor_name");
            txtName.setText(name);
            Picasso.get().load(imagen).into(img_Actor);
            btnClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences configuration = getApplicationContext().getSharedPreferences(dataUser, modoPrivate);
                    configuration.edit().clear().commit();
                    Intent i = new Intent(MainActivity3.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            });
        }
    }
}