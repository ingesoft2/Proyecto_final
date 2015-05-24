package com.example.mateobadillo.ingesoft;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by mateobadillo on 4/22/15.
 */
public class Eliminar_Fragment extends android.support.v4.app.Fragment {

    View rootview;
    private Button Beliminar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.eliminar_layout, container, false);

        Beliminar = (Button) rootview.findViewById(R.id.BeliminarObjeto);
        Beliminar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
            }
        });


        return rootview;


    }


}
