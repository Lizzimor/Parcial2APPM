package com.example.parcial2;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUser, edtPassword;
    Button btnStart;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static final String dataUser = "dataUser";
    private static final int modoPrivate = Context.MODE_PRIVATE;
    String dato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);
        btnStart = findViewById(R.id.btnStart);

        sharedPreferences = getSharedPreferences(dataUser, modoPrivate);
        editor = sharedPreferences.edit();
        dato = getApplicationContext().getSharedPreferences(dataUser, modoPrivate).getString("user", "0");
        if(!dato.equalsIgnoreCase("0")){
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(i);
            finish();
        }
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User = edtUser.getText().toString();
                String Password = edtPassword.getText().toString();
                if (User.equals("") || Password.equals(""))
                    Toast.makeText(MainActivity.this, "Rellena los campos ", Toast.LENGTH_SHORT).show();
                else {
                    editor.putString("user", User);
                    editor.commit();
                    Intent i = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(i);
                    finish();}
            }
        });
    }
}