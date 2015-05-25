package com.example.mateobadillo.ingesoft;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mateobadillo on 4/22/15.
 */
public class Registrar_Fragment extends android.support.v4.app.Fragment {

    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.registrar_layout,container, false);
        return rootview;
    }
}
