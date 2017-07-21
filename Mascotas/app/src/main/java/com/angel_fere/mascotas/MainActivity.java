package com.angel_fere.mascotas;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;
    RecyclerView listaMascotas;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(manager);
        inicializarListaMascotas();
        inicializarAdaptador();

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.estrella:
                startActivity(new Intent(MainActivity.this,Mascotas_favoritas.class));
                    break;
        }

        return super.onOptionsItemSelected(item);
    }


    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascotas>();
        mascotas.add(new Mascotas(R.drawable.gatito,"Alex",0));
        mascotas.add(new Mascotas(R.drawable.salchicha,"Benji",0));
        mascotas.add(new Mascotas(R.drawable.peque_ito,"Little",0));
        mascotas.add(new Mascotas(R.drawable.pug,"Gorila",0));
        mascotas.add(new Mascotas(R.drawable.lanudo,"Lanudo",0));
    }

    public void inicializarAdaptador(){

        mascotasAdaptador adaptador = new mascotasAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);

    }


}
