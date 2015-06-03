package com.example.mateobadillo.ingesoft.objetoperdidoendpoint;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mateobadillo.ingesoft.R;
import com.example.mateobadillo.ingesoft.objetoperdidoendpoint.model.ObjetoPerdido;
import com.example.mateobadillo.ingesoft.registraruendpoint.RegistrarseActivity;
import com.example.mateobadillo.ingesoft.registraruendpoint.Registraruendpoint;
import com.example.mateobadillo.ingesoft.registraruendpoint.model.RegistrarU;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mateobadillo on 4/22/15.
 */
public class RegistrarObjeto_Fragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    View rootview;
    private Spinner spinnerLugar, spinnerCategoria;
    private EditText Tdescripcion, Tpregunta1, Tpregunta2, Tpregunta3, Trespuesta1, Trespuesta2, Trespuesta3,Temail;
    private Button BcrearOb;
    private String usuario;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.registrarobjeto_layout,container, false);
        usuario = getArguments().getString("key");


        spinnerLugar = (Spinner) rootview.findViewById(R.id.Slocalizacion);
        spinnerCategoria = (Spinner) rootview.findViewById(R.id.Scategoria);

        BcrearOb = (Button) rootview.findViewById(R.id.BcrearOb);

        Tdescripcion = (EditText) rootview.findViewById(R.id.Tdescripcion);
        Tpregunta1 = (EditText) rootview.findViewById(R.id.Tpregunta1);
        Tpregunta2 = (EditText) rootview.findViewById(R.id.Tpregunta2);
        Tpregunta3 = (EditText) rootview.findViewById(R.id.Tpregunta3);
        Trespuesta1 = (EditText) rootview.findViewById(R.id.Trespuesta1);
        Trespuesta2 = (EditText) rootview.findViewById(R.id.Trespuesta2);
        Trespuesta3 = (EditText) rootview.findViewById(R.id.Trespuesta3);
        Temail = (EditText) rootview.findViewById(R.id.Temail);

        this.listener();
        this.llenarCategoria();
        this.llenarLugar();




        return rootview;
    }

    public void listener()

    {
        BcrearOb.setOnClickListener(this);
    }

    public void llenarLugar()
    {
        /*
        *Llenar el spinner de lugar
        *
        * */
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

    public void llenarCategoria()
    {
        /*
        *Llenar el spinner de categoria
        *
        * */
        List<String> toSpin = new ArrayList<String>();
        toSpin.add("Ropa");
        toSpin.add("Electronicos");
        toSpin.add("Accesorios");

        ArrayAdapter<String> LTRadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, toSpin);
        LTRadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerCategoria.setAdapter(LTRadapter);
    }

    public boolean validar()
    {
        boolean valido = false;

        if(spinnerLugar.getSelectedItem().toString().equals("") || spinnerCategoria.getSelectedItem().toString().equals("")
                || Tdescripcion.getText().toString().equals("") || Tpregunta1.getText().toString().equals("") || Tpregunta2.getText().toString().equals("") || Tpregunta3.getText().toString().equals("")
                || Trespuesta1.getText().toString().equals("")|| Trespuesta2.getText().toString().equals("") || Trespuesta3.getText().toString().equals("") || Temail.getText().toString().equals(""))
        {


            Toast.makeText(getActivity(),"Tiene que llenar todos los campos!",Toast.LENGTH_SHORT).show();

            valido = false;
        }
        else
        {
            valido = true;
        }

        return valido;
    }


    @Override
    public void onClick(View v)
    {


        if (BcrearOb.isPressed()) {

                if(this.validar() == true)
                {
                    Log.d("Test", "onClickListener ist gestartet");
                    Toast.makeText(getActivity().getApplicationContext(), "Test",        Toast.LENGTH_LONG).show();


                    String lugar = spinnerLugar.getSelectedItem().toString();
                    String categoria = spinnerCategoria.getSelectedItem().toString();
                    String descripcion = Tdescripcion.getText().toString();
                    String p1 = Tpregunta1.getText().toString();
                    String p2 = Tpregunta2.getText().toString();
                    String p3 = Tpregunta3.getText().toString();
                    String r1 = Trespuesta1.getText().toString();
                    String r2 = Trespuesta2.getText().toString();
                    String r3 = Trespuesta3.getText().toString();
                    String email = Temail.getText().toString();

                    String[] params = {lugar,categoria,descripcion,p1,p2,p3,r1,r2,r3,email};
                    new AddRegistrarOAsyncTask(rootview.getContext()).execute(params);
                }

        }

    }



    private class AddRegistrarOAsyncTask extends AsyncTask<String, Void, ObjetoPerdido>
    {
        Context context;
        private ProgressDialog pd;

        public AddRegistrarOAsyncTask(Context context)
        {

            this.context = context;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            pd = new ProgressDialog(context);
            pd.setMessage("Guardando...");
            pd.show();
        }

        protected ObjetoPerdido doInBackground(String... params)
        {
            ObjetoPerdido response = null;
            try
            {
                Objetoperdidoendpoint.Builder builder = new Objetoperdidoendpoint.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
                Objetoperdidoendpoint service =  builder.build();
                ObjetoPerdido objeto = new ObjetoPerdido();
                objeto.setLugar(params[0]);
                objeto.setCategorias(params[1]);
                objeto.setDescripcion(params[2]);
                objeto.setPregunta1(params[3]);
                objeto.setPregunta2(params[4]);
                objeto.setPregunta3(params[5]);
                objeto.setRespuesta1(params[6]);
                objeto.setRespuesta2(params[7]);
                objeto.setRespuesta3(params[8]);
                objeto.setEmail(params[9]);
                objeto.setEstado(0);
                objeto.setCodigoUsuario(usuario);

                response = service.insertObjetoPerdido(objeto).execute();
            }
            catch (Exception e)
            {
                android.util.Log.d("No se pudo adicionar", e.getMessage(), e);
            }
            return response;
        }

        protected void onPostExecute(ObjetoPerdido objeto)
        {
            //Clear the progress dialog and the fields
            pd.dismiss();
            if(objeto != null)
                System.out.println("SE GUARDO--------------");
            //Display success message to user
            Toast.makeText(getActivity().getApplicationContext(), "Se almaceno correctamente", Toast.LENGTH_SHORT).show();
        }
    }
}
