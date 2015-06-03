package com.example.mateobadillo.ingesoft;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * By: Nathalie Ayala Santana
 *
 */

public class ListaObjetosPerdidos extends android.support.v4.app.Fragment
{

    View rootview;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_buscar, container, false);

        return rootview;
    }
}

