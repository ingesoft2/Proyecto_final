package com.example.mateobadillo.ingesoft;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.services.listaroendpoint;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;


/**
 * By: Nathalie Ayala Santana
 */

public class Buscar extends android.support.v4.app.Fragment {

    View rootview;
    private Button Bbuscar;
    public String lugar;
    public String categoria;
    Spinner spinnerLugar;
    Spinner spinnerCategoria;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.fragment_buscar, container, false);

        this.llenarspinner1();
        this.llenarspinner2();

        Bbuscar = (Button) rootview.findViewById(R.id.bfind);

        Bbuscar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                // do something

                lugar=spinnerLugar.getSelectedItem().toString();
                categoria=spinnerCategoria.getSelectedItem().toString();
                //Toast.makeText(getActivity(), "Lugar "+lugar, Toast.LENGTH_LONG ).show();
                //Toast.makeText(getActivity(), "Categoria "+categoria, Toast.LENGTH_LONG ).show();
                String respuesta=null;

                //ListaObjetosPerdidos fr = new ListaObjetosPerdidos();
                //FragmentManager fm = getFragmentManager();
                //FragmentTransaction fragmentTransaction = fm.beginTransaction();
                //fragmentTransaction.replace(, fr);
                //fragmentTransaction.commit();

                if(!lugar.isEmpty()&&!categoria.isEmpty())
                {
                    String[] params = {lugar,categoria};
                    new BuscarAsyncTask(rootview.getContext()).execute(params);
                }
                else
                {
                    Toast.makeText(getActivity(), "Por favor seleccione categoria y lugar", Toast.LENGTH_LONG ).show();
                }




            }
        });



        return rootview;
    }



    private class BuscarAsyncTask extends AsyncTask<String, Void, ListarO> {
        Context context;
        private ProgressDialog pd;

        public BuscarAsyncTask(Context context) {
            this.context = context;
        }

        protected void onPreExecute(){
            super.onPreExecute();
            pd = new ProgressDialog(context);
            pd.setMessage("Buscando Objetos Perdidos");
            pd.show();
        }

        protected ListarO doInBackground(String... params) {
            ListarO response = null;
            try {
                Listaroendpoint.Builder builder = new Listaroendpoint.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
                Listaroendpoint service =  builder.build();
                ListarO quote = new ListarO();
                quote.setLugar(params[0]);
                quote.setCategoria(params[1]);
                response = service.listListarO(quote).execute();
            } catch (Exception e) {
                Log.d("Could not Add Quote", e.getMessage(), e);
            }
            return response;
        }

        protected void onPostExecute(ListarO quote) {
            //Clear the progress dialog and the fields
            pd.dismiss();
            //editMessage.setText("");
            //editAuthorName.setText("");

            //Display success message to user
            Toast.makeText(rootview.getContext(), "La busqueda es", Toast.LENGTH_SHORT).show();
        }
    }




    public void llenarspinner1()
    {
        /*
        *Llenar el spinner de lugar
        *
        * */
        spinnerLugar = (Spinner) rootview.findViewById(R.id.SpinnerBuscarLugar);
        List<String> toSpinL = new ArrayList<String>();
        toSpinL.add("Edificio A");
        toSpinL.add("Edificio B");
        toSpinL.add("Edificio C");
        toSpinL.add("Edificio D");
        toSpinL.add("Edificio E");
        toSpinL.add("Edificio F");
        toSpinL.add("Edificio G");
        toSpinL.add("Edificio J");
        toSpinL.add("Edificio K");
        toSpinL.add("Edificio L");
        toSpinL.add("Biblioteca");
        toSpinL.add("Arena Sabana");
        toSpinL.add("Canchas");
        toSpinL.add("Plaza de los balcones");
        toSpinL.add("Capilla");
        toSpinL.add("Meson");
        toSpinL.add("Kioskos");
        toSpinL.add("Punto Verde");
        toSpinL.add("Punto Sandwich");
        toSpinL.add("Punto Pizza");
        toSpinL.add("Punto Verde");
        toSpinL.add("Embarcadero");
        toSpinL.add("Restaurante Escuela");

        ArrayAdapter<String> LTRadapterL = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, toSpinL);
        LTRadapterL.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerLugar.setAdapter(LTRadapterL);

    }

    public void llenarspinner2()
    {
        /*
        *Llenar el spinner de categoria
        *
        * */
        spinnerCategoria = (Spinner) rootview.findViewById(R.id.SpinnerBuscarCategoria);
        List<String> toSpin = new ArrayList<String>();
        toSpin.add("Ropa");
        toSpin.add("Electronicos");
        toSpin.add("Accesorios");

        ArrayAdapter<String> LTRadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, toSpin);
        LTRadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerCategoria.setAdapter(LTRadapter);
    }

}
