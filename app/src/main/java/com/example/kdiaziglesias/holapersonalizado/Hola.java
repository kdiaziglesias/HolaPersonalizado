package com.example.kdiaziglesias.holapersonalizado;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.Serializable;


public class Hola extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //llamar el constructor
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola);
        //instancio el boton
        Button miboton = (Button) findViewById(R.id.bhola);
        RadioButton radio =(RadioButton) findViewById(R.id.saludoSr);
        boolean estaSelecion = radio.isChecked();
        //instancio el Checkbox
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);



        //defino el listener de onChecked

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int visibility =isChecked?View.VISIBLE:View.GONE;
                View view = findViewById(R.id.timePicker);
                view.setVisibility(visibility);
                view= findViewById(R.id.datePicker);
                view.setVisibility(visibility);
            }
        });
//defino el listener onClick
        miboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Llamo  la clase
               // MiClase persona1 = new MiClase("Jose",23);
                //Codigo a ejecutar
                EditText text = (EditText)findViewById(R.id.entry);

                if ("".equals(text.getText().toString())) {

                    String msg = getResources().getString(R.string.darnombre);

                    showToast("Error");

                    return;
                }
                String salutation="";
                String enterName = text.getText().toString();
                //obtencion de hora y fecha

                String saludo = getResources().getString(R.string.hello)+" "+enterName;
                String Fecha="";

                TextView out = (TextView)findViewById(R.id.out);
                //Hacemos un intent

                //mostra Fecha
                CheckBox timeCheckBox = (CheckBox)findViewById(R.id.checkbox);
                if (timeCheckBox.isChecked()){
                    DatePicker date = (DatePicker)findViewById(R.id.datePicker);
                    String dateToShow = date.getDayOfMonth()+"/"+(date.getMonth()+1)+"/"+date.getYear();
                    TimePicker time = (TimePicker)findViewById(R.id.timePicker);
                    dateToShow += " " + time.getCurrentHour() + ":" + time.getCurrentMinute();
                    Fecha = salutation + " " +dateToShow;


                }
                //Referencia al RadioButton
                RadioGroup radio = (RadioGroup)findViewById(R.id.Grupo1);
                if(R.id.saludoSr ==radio.getCheckedRadioButtonId()){
                    //para señor
                    salutation = getResources().getString(R.string.saludoSr).toLowerCase();

                }
                else{
                    salutation = getResources().getString(R.string.saludoSra).toLowerCase();

                }
                salutation = getResources().getString(R.string.hello)+" "+salutation+" "+ enterName+" "+Fecha;
                out.setText(salutation);

                Intent intento = new Intent(Hola.this,Salutation.class);
                intento.putExtra("salutation",salutation);
                startActivityForResult(intento,1);
                //otro metodo
                /*Bundle recipiente = new Bundle();
                recipiente.putInt("edad",35);
                recipiente.putString("nombre","Damian");
                intento.putExtras(recipiente);
                intento.putExtra("id1",persona1);*/


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
        getMenuInflater().inflate(R.menu.hola, menu);
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

    //Metodo con Serializable
    public class MiClase implements Serializable{

        private static final long serieV=1;

        String nombre;
        int edad;

       public MiClase(String nombre,int edad){
            this.nombre=nombre;
            this.edad=edad;


        }

    }

   /* public void onActivityResult(int reql, int resl,Intent data){

       String miRespusta = data.getExtras().getString("respuestas");

    }*/
}
