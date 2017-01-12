package com.example.joseantonio.proyecto2.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.joseantonio.proyecto2.R;
import com.squareup.picasso.Picasso;

public class FragmentAlarma2 extends Fragment {
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_alarma2, container, false);
        ImageView back_image = (ImageView) rootView.findViewById(R.id.back_image);
        Picasso.with(getActivity()).load(R.drawable.wallpaper_login).fit().centerCrop().into(back_image);
        return rootView;
    }
}