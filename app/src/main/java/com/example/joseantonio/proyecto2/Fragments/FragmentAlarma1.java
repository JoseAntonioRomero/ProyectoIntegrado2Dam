package com.example.joseantonio.proyecto2.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.joseantonio.proyecto2.R;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

public class FragmentAlarma1 extends Fragment {
    View rootView;
    Button calen;
    EditText tema;
    EditText sitio;
    String tem;
    String lugar;
    String des;
    EditText descrip;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_alarma1, container, false);
        ImageView back_image = (ImageView) rootView.findViewById(R.id.back_image);
        Picasso.with(getActivity()).load(R.drawable.wallpaper_login).fit().centerCrop().into(back_image);
        calen = (Button) rootView.findViewById(R.id.calen);
        tema = (EditText) rootView.findViewById(R.id.tema);
        sitio = (EditText) rootView.findViewById(R.id.sitio);
        descrip = (EditText) rootView.findViewById(R.id.descripCalen);
        tem = tema.getText().toString();
        lugar = sitio.getText().toString();
        des=descrip.getText().toString();

        calen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(2017, 0, 19, 7, 30);
                Calendar endTime = Calendar.getInstance();
                endTime.set(2017, 0, 19, 8, 30);
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                        .putExtra(CalendarContract.Events.TITLE, tem)
                        .putExtra(CalendarContract.Events.DESCRIPTION, des)
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, lugar)
                        .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                        .putExtra(Intent.EXTRA_EMAIL, "rowan@example.com,trevor@example.com");
                startActivity(intent);

            }

        });

        return rootView;
    }
}