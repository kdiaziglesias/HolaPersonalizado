package com.example.kdiaziglesias.holapersonalizado;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kdiaziglesias.holapersonalizado.R;

public class Salutation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salutation);
        String salutation = getIntent().getExtras().getString("salutation");
        Button otboton = (Button) findViewById(R.id.badios);
        TextView out =(TextView)findViewById(R.id.adios);

        out.setText(salutation);

       /* Intent i = new Intent();
        i.putExtra("respuesta","Hola");
        setResult(RESULT_OK,i);
     finish();

        Bundle recogida=getIntent().getExtras();
        recogida.getString("nombre");


        Hola.MiClase obj = (Hola.MiClase) getIntent().getSerializableExtra("id1");
        String minom = obj.nombre;
        int mied= obj.edad;*/

       otboton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               EditText text = (EditText)findViewById(R.id.entry);

               if ("".equals(text.getText().toString())) {

                   String msg = getResources().getString(R.string.darnombre);

                   showToast("Error");

                   return;
               }



           }
       });

    }
    public void showToast(String msg){

        Context contexto = getApplicationContext();
        int duracion = Toast.LENGTH_SHORT;
        Toast tostada = Toast.makeText(contexto,msg,duracion);
        tostada.show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.salutation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
