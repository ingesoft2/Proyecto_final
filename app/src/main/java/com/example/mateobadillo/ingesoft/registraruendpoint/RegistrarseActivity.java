package com.example.mateobadillo.ingesoft.registraruendpoint;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mateobadillo.ingesoft.Log;
import com.example.mateobadillo.ingesoft.R;
import com.example.mateobadillo.ingesoft.registraruendpoint.model.RegistrarU;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;

import java.util.ArrayList;
import java.util.List;


public class RegistrarseActivity extends ActionBarActivity implements View.OnClickListener {

    private Button Batras, Bregistro;
    private EditText TcrearUsuario, TcrearContraseña;
    private Boolean correcto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        Batras = (Button)findViewById(R.id.BregistroAtras);
        Bregistro = (Button)findViewById(R.id.BcrearUsuario);

        TcrearUsuario = (EditText)findViewById(R.id.TcrearUsuario);
        TcrearContraseña = (EditText)findViewById(R.id.TcrearContraseña);

        listener();

    }

    public void listener()
    {
        Batras.setOnClickListener(this);
        Bregistro.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registrarse, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public boolean validar()
    {
        correcto = false;
        String nombre = TcrearUsuario.getText().toString();
        String contraseña = TcrearContraseña.getText().toString();
        System.out.println(nombre + " " + contraseña);

        if(nombre.length() < 6 || contraseña.length() < 6)
        {
            new AlertDialog.Builder(this)
                    .setTitle("Registrarse")
                    .setMessage("Usuario o contraseña muy corta")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_dialer)
                    .show();
        }
        else
        {
            correcto = true;
        }
        
        return correcto;
    }

    @Override
    public void onClick(View v)
    {
        if(Batras.isPressed())
        {
            startActivity(new Intent(this, Log.class));
            finish();
        }

        if(Bregistro.isPressed())
        {

            if(this.validar())
            {

                /*AlertDialog registrarse = new AlertDialog.Builder(this)
                        .setTitle("Registrarse")
                        .setMessage("Se ha creado su usuario correctamente")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_dialer)
                        .show();*/


                String usuario = TcrearUsuario.getText().toString();
                String contrasena = TcrearContraseña.getText().toString();

                    String[] params = {usuario, contrasena};
                    new AddRegistrarUAsyncTask(RegistrarseActivity.this).execute(params);


                //startActivity(new Intent(this, Log.class));
                  //  finish();

            }
        }


    }


    private class AddRegistrarUAsyncTask extends AsyncTask<String, Void, RegistrarU>
    {
        Context context;
        private ProgressDialog pd;

        public AddRegistrarUAsyncTask(Context context)
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

        protected RegistrarU doInBackground(String... params)
        {
            RegistrarU response = null;
            try
            {
                Registraruendpoint.Builder builder = new Registraruendpoint.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
                Registraruendpoint service =  builder.build();
                RegistrarU registro = new RegistrarU();
                registro.setCodigo(Long.parseLong(params[1]));
                registro.setConrasena(params[0]);

                response = service.insertRegistrarU(registro).execute();
            }
            catch (Exception e)
            {
                android.util.Log.d("No se pudo adicionar", e.getMessage(), e);
            }
            return response;
        }

        protected void onPostExecute(RegistrarU registro)
        {
            //Clear the progress dialog and the fields
            pd.dismiss();
            if(registro != null)
                System.out.println("SE GUARDO--------------");
            //Display success message to user
            Toast.makeText(getBaseContext(), "Se almaceno correctamente", Toast.LENGTH_SHORT).show();
        }
    }
}
