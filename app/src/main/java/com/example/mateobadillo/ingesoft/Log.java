package com.example.mateobadillo.ingesoft;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Log extends ActionBarActivity implements View.OnClickListener {

    private Button Blogin, Bregistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        Blogin = (Button)findViewById(R.id.Blogin);
        Bregistro = (Button)findViewById(R.id.Bregistrarse);

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
        Boolean correcto=false;


        if(Blogin.isPressed())
        {
            if(correcto==true)
            {
                startActivity(new Intent(this, MenuNavegacion.class));
                finish();
            }
            else
            {
                Toast.makeText(this, "Usuario o contrasena incorrecta", Toast.LENGTH_SHORT).show();
            }
        }

        if(Bregistro.isPressed())
        {
            startActivity(new Intent(this, Registrarse.class));
            finish();
        }

    }
}
