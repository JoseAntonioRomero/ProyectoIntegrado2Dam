package com.example.joseantonio.proyecto2.Activitys;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.joseantonio.proyecto2.Fragments.FragmentAlarma1;
import com.example.joseantonio.proyecto2.Fragments.FragmentAlarma2;
import com.example.joseantonio.proyecto2.Fragments.FragmentPersistentes;
import com.example.joseantonio.proyecto2.R;

public class alarmas extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_alarmas);

        ActionBar actionBar = getSupportActionBar();

        /**INDICAR TITULO Y SUBTITULO**/
        actionBar.setTitle("Alarmas");
        actionBar.setSubtitle("Crea tu propia alarma");


        /**MODO TABS EN ACTIONBAR**/
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        /**CREAR TABS**/
        ActionBar.Tab tab = actionBar.newTab()
                .setText("Alarmas Persistentes")
                .setTabListener(new TabsListener(
                        this, "persistentes", FragmentPersistentes.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Fijada a una hora")
                .setTabListener(new TabsListener(
                        this, "hora", FragmentAlarma1.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Con mensaje Persistente")
                .setTabListener(new TabsListener(
                        this, "mensaje", FragmentAlarma2.class));
        actionBar.addTab(tab);


    }

    public class TabsListener  implements ActionBar.TabListener {

        private Fragment fragment;
        private final String tag;

        public TabsListener(Activity activity, String tag, Class cls) {
            this.tag = tag;
            fragment = Fragment.instantiate(activity, cls.getName());
        }

        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

            ft.replace(android.R.id.content, fragment, tag);

        }

        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.remove(fragment);

        }

        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alarmas, menu);
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
