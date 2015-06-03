package com.example.mateobadillo.ingesoft;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mateobadillo.ingesoft.registraruendpoint.RegistrarseActivity;


public class Log extends ActionBarActivity implements View.OnClickListener {

    private Button Blogin, Bregistro;
    private EditText TUsuario, TContraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);


        Blogin = (Button)findViewById(R.id.Blogin);
        Bregistro = (Button)findViewById(R.id.Bregistrarse);

        TUsuario = (EditText)findViewById(R.id.Tusuario);
        TContraseña = (EditText)findViewById(R.id.Tcontraseña);

        listener();

    }

    public void listener()
    {
        Blogin.setOnClickListener(this);
        Bregistro.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log, menu);
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

    @Override
    public void onClick(View v)
    {
        if(Blogin.isPressed())
        {
            Intent intent = (new Intent(this, MenuNavegacion.class));
            Bundle b = new Bundle();
            String usuario = this.TUsuario.getText().toString();
            b.putString("key", usuario); //Your id
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }

        if(Bregistro.isPressed())
        {
            startActivity(new Intent(this, RegistrarseActivity.class));
            finish();
        }

    }
}
