package com.miislyk.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionbar);
        setSupportActionBar(actionBar);

        listaContactos = (RecyclerView) findViewById(R.id.recyclerViewContactos);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(linearLayoutManager);

        inicializarListaContactos();
        inicializarAdaptador();


        /*ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto: contactos) {
            nombresContacto.add(contacto.getNombre());
        }*/

      /*  ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));
        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pNombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.pTelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pEmail), contactos.get(position).getEmail());
                startActivity(intent);
                finish();
            }
        });*/


    }

    public void inicializarAdaptador(){

        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);

    }

    public void inicializarListaContactos(){

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.gohanadolescentessj, "Luis Gallegos", "99999999", "algo@email"));
        contactos.add(new Contacto(R.drawable.gohanssjdbzfin, "Viridiana Macias", "99999999", "algo@email"));
        contactos.add(new Contacto(R.drawable.gokussj, "Porfi1", "99999999", "algo@email"));
        contactos.add(new Contacto(R.drawable.gokussj3, "Porfi2", "99999999", "algo@email"));
        contactos.add(new Contacto(R.drawable.gotenssj2, "Ma luisa", "99999999", "algo@email"));

    }
}
