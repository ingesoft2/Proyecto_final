package com.example.mateobadillo.ingesoft;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mateobadillo on 4/22/15.
 */
public class Home_Fragment extends android.support.v4.app.Fragment {

    View rootview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.home_layout,container, false);
        return rootview;
    }
}
