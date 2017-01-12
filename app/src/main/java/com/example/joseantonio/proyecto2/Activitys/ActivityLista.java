package com.example.joseantonio.proyecto2.Activitys;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joseantonio.proyecto2.Adaptadores.Adaptador;
import com.example.joseantonio.proyecto2.R;
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

        TextView texto = (TextView) findViewById(R.id.contac);
        ImageView back_image = (ImageView) findViewById(R.id.back_image);
        Picasso.with(getApplicationContext()).load(R.drawable.back_image).fit().centerCrop().into(back_image);
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        recycler.setHasFixedSize(true);
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);
        adapter = new Adaptador(items);
        recycler.setAdapter(adapter);
        contactos();

    }

    public void contactos() {

                Cursor c = managedQuery(ContactsContract.Contacts.CONTENT_URI, new String[]{ContactsContract.Contacts.DISPLAY_NAME},
                        ContactsContract.Contacts.IN_VISIBLE_GROUP, null, ContactsContract.Contacts.DISPLAY_NAME);
                /*Cursor n = managedQuery(ContactsContract.Contacts.CONTENT_URI, new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER},
                ContactsContract.Contacts.IN_VISIBLE_GROUP, null, ContactsContract.CommonDataKinds.Phone.NUMBER);*/


        while (c.moveToNext()) {
            String contactos = c.getString(c.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
            //Integer numero=n.getInt(n.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            items.add(new Contacto(R.drawable.avatar, contactos, 658952365));

        }
    }

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
