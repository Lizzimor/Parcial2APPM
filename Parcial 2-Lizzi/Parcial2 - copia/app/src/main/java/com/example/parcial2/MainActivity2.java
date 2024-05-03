package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.parcial2.adaptadores.UsuarioAdaptador;
import com.example.parcial2.clases.Actor;
import com.example.parcial2.clases.Actor;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements UsuarioAdaptador.OnItemClickListener{

    public static final String dataUser = "dataUser";
    private static final int modoPrivate = Context.MODE_PRIVATE;
    TextView txtUser;
    String dato;
    RecyclerView rcv_Actores;
    List<Actor> ActorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtUser = findViewById(R.id.txtUser);
        dato = getApplicationContext().getSharedPreferences(dataUser, modoPrivate).getString("user", "0");
        if (!dato.equals("0"))
            txtUser.setText(dato);
        else
            txtUser.setText("No encontrado");

        rcv_Actores = findViewById(R.id.rcv_Actores);

        Actor per1 = new Actor("https://images.paramount.tech/path/mgid:file:gsp:entertainment-assets:/sps/shared/characters/kids/eric-cartman.png?height=165", "Eric Cartman", "South Park");
        Actor per2 = new Actor("data:image/jpeg;base64,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", "Kenny McCormick", "South Park");
        Actor per3 = new Actor("data:image/jpeg;base64,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", "Kyle Broflovski", "South Park");
        Actor per4 = new Actor("data:image/jpeg;base64,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", "Stan Marsh", "South Park");
        Actor per5 = new Actor("data:image/jpeg;base64,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", "Harvey Specter", "South Park");

        ActorList.add(per1);
        ActorList.add(per2);
        ActorList.add(per3);
        ActorList.add(per4);
        ActorList.add(per5);

        rcv_Actores.setLayoutManager(new LinearLayoutManager(this));
        rcv_Actores.setAdapter(new UsuarioAdaptador(ActorList));

        UsuarioAdaptador adaptador = new UsuarioAdaptador(ActorList);
        rcv_Actores.setAdapter(adaptador);
        adaptador.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(Actor actor) {
        Intent i = new Intent(MainActivity2.this, MainActivity3.class);
        i.putExtra("personaje_nombre", actor.getNombre());
        i.putExtra("personaje_programa", actor.getPrograma());
        i.putExtra("personaje_imagen", actor.getImagen());
        startActivity(i);
        finish();
    }
}