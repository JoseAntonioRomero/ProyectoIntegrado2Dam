package com.example.joseantonio.proyecto2;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ActivityLista extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    final List items = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ImageView back_image = (ImageView) findViewById(R.id.back_image);
        Picasso.with(getApplicationContext()).load(R.drawable.wallpaper_login).fit().centerCrop().into(back_image);
        recycler = (RecyclerView) findViewById(R.id.reciclador);

        items.add(new Contacto(R.drawable.avatar, "Juan Delgado", "bla, bla, bla...."));
        items.add(new Contacto(R.drawable.avatar, "Maria Pérez", "bla, bla, bla...."));
        items.add(new Contacto(R.drawable.avatar, "Jose Andrés ", "bla, bla, bla...."));
        items.add(new Contacto(R.drawable.avatar, "Carlos López", "bla, bla, bla...."));
        items.add(new Contacto(R.drawable.avatar, "Jorge Juan", "bla, bla, bla...."));
        items.add(new Contacto(R.drawable.avatar, "Andrés Iranzo", "bla, bla, bla...."));
        items.add(new Contacto(R.drawable.avatar, "Ivan Ferrero", "bla, bla, bla...."));


        recycler.setHasFixedSize(true);
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);
        adapter = new Adaptador(items);
        recycler.setAdapter(adapter);

    }
/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ((Adaptador.ContactoViewHolder) adapter).setOnItemClickListener(new Adaptador.ContactoViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ClipData.Item item = items[position];

                Intent intent = new Intent(getApplicationContext(), ActivityPrincipal.class);
                intent.putExtra("item", item);

                startActivity(intent);
            }
        });
    }
*/


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
