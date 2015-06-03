package com.example.mateobadillo.ingesoft.objetoperdidoendpoint;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mateobadillo.ingesoft.R;
import com.example.mateobadillo.ingesoft.objetoperdidoendpoint.model.CollectionResponseObjetoPerdido;
import com.example.mateobadillo.ingesoft.objetoperdidoendpoint.model.ObjetoPerdido;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mateobadillo on 4/22/15.
 */
public class Eliminar_Fragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    View rootview;
    private Button Beliminar;
    private String usuario;
    private Spinner SObjetosUsuario;
    private ArrayList<ObjetoPerdido> objetos;
    private int eliminar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.eliminar_layout, container, false);
        usuario = getArguments().getString("key");

        SObjetosUsuario = (Spinner) rootview.findViewById(R.id.SObjetosUsuario);
        Beliminar = (Button) rootview.findViewById(R.id.BeliminarObjeto);
        objetos = new ArrayList<ObjetoPerdido>();

        new ListObjetosAsyncTask(rootview.getContext()).execute();

        List<String> toSpinL = new ArrayList<String>();
        for (int i = 0; i < objetos.size(); i++)
        {
            toSpinL.add(objetos.get(i).getNombre().toString());
        }
        ArrayAdapter<String> LTRadapterL = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, toSpinL);
        LTRadapterL.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        SObjetosUsuario.setAdapter(LTRadapterL);

        this.listener();

        return rootview;


    }

    public void listener()
    {
        Beliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {

        if(Beliminar.isPressed()) {

            String objeto = SObjetosUsuario.getSelectedItem().toString();
            eliminar = SObjetosUsuario.getSelectedItemPosition();
            String[] params = {objeto};
            new DeleteObjetoPerdidoAsyncTask(rootview.getContext()).execute(params);
            new ListObjetosAsyncTask(rootview.getContext()).execute();

            List<String> toSpinL = new ArrayList<String>();
            for (int i = 0; i < objetos.size(); i++)
            {
                toSpinL.add(objetos.get(i).getNombre().toString());
            }

            ArrayAdapter<String> LTRadapterL = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item,toSpinL);
            LTRadapterL.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            SObjetosUsuario.setAdapter(LTRadapterL);
        }
    }


    private class DeleteObjetoPerdidoAsyncTask extends AsyncTask<String, Void, ObjetoPerdido>
    {
        Context context;
        private ProgressDialog pd;

        public DeleteObjetoPerdidoAsyncTask(Context context)
        {
            this.context = context;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            pd = new ProgressDialog(context);
            pd.setMessage("Eliminando objeto...");
            pd.show();
        }
//--------------------
        protected ObjetoPerdido doInBackground(String... params)
        {
            ObjetoPerdido response = null;
            try
            {
                Objetoperdidoendpoint.Builder builder = new Objetoperdidoendpoint.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
                Objetoperdidoendpoint service =  builder.build();
                //service.removeObjetoPerdido(params[0],usuario).execute();// aqui mandar solo el nombre del objeto no el id que desconozco
            }
            catch (Exception e)
            {
                Log.d("No se pudo eliminar", e.getMessage(), e);
            }
            return response;
        }

        protected void onPostExecute(ObjetoPerdido asignatura)
        {
            //Clear the progress dialog and the fields
            pd.dismiss();
            objetos.remove(eliminar);
            Toast.makeText(getActivity().getApplicationContext(), "Asignatura eliminda", Toast.LENGTH_SHORT).show();
        }
    }


    private class ListObjetosAsyncTask extends AsyncTask<Void, Void, CollectionResponseObjetoPerdido>
    {
        Context context;
        private ProgressDialog pd;

        public ListObjetosAsyncTask(Context context)
        {
            this.context = context;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            pd = new ProgressDialog(context);
            pd.setMessage("Inicializando...");
            pd.show();
        }

        protected CollectionResponseObjetoPerdido doInBackground(Void... unused)
        {
            CollectionResponseObjetoPerdido objetos = null;
            try
            {
                Objetoperdidoendpoint.Builder builder = new Objetoperdidoendpoint.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
                Objetoperdidoendpoint service =  builder.build();
                objetos = service.listObjetoPerdido().execute();
            }
            catch (Exception e)
            {
                Log.d("No se logro inicializar", e.getMessage(), e);
            }
            return objetos;
        }

        protected void onPostExecute(CollectionResponseObjetoPerdido objetos)
        {
            pd.dismiss();
            // Do something with the result.
            if(!objetos.isEmpty())
            {
                List<ObjetoPerdido> _list = objetos.getItems();
                if(_list != null)
                {
                    for (ObjetoPerdido carr : _list)
                    {
                        ObjetoPerdido car = new ObjetoPerdido();
                        car.setNombre(carr.getNombre());

                        Eliminar_Fragment.this.objetos.add(car);
                    }
                }

                List<String> toSpinL = new ArrayList<String>();
                for (int i = 0; i < objetos.size(); i++)
                {
                    toSpinL.add( Eliminar_Fragment.this.objetos.get(i).getNombre().toString());
                }

                ArrayAdapter<String> LTRadapterL = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item,toSpinL);
                LTRadapterL.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                SObjetosUsuario.setAdapter(LTRadapterL);
            }
        }
    }
}
