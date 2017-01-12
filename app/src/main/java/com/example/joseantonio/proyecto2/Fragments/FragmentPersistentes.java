package com.example.joseantonio.proyecto2.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.joseantonio.proyecto2.R;
import com.squareup.picasso.Picasso;

public class FragmentPersistentes extends Fragment {
    View rootView;
    Button alarma;
    EditText hora;
    EditText minutos;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_persistentes, container, false);
        ImageView back_image = (ImageView) rootView.findViewById(R.id.back_image);
        alarma = (Button) rootView.findViewById(R.id.alarmaPersi);
        hora = (EditText) rootView.findViewById(R.id.hora);
        minutos = (EditText) rootView.findViewById(R.id.minutos);
        Picasso.with(getActivity()).load(R.drawable.wallpaper_login).fit().centerCrop().into(back_image);

        alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hora1 = hora.getText().toString();
                int finalHora = Integer.parseInt(hora1);
                String min = minutos.getText().toString();
                int finalmin = Integer.parseInt(min);

                Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                i.putExtra(AlarmClock.EXTRA_MESSAGE, "Alarma Nueva");
                i.putExtra(AlarmClock.EXTRA_HOUR, finalHora);
                i.putExtra(AlarmClock.EXTRA_MINUTES, finalmin);
                getActivity().startActivity(i);
            }
        });

        return rootView;
    }

}

