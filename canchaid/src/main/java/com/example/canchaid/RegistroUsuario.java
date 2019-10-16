package com.example.canchaid;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class RegistroUsuario extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener{


   EditText campoEMAIL, campoNOMBRE, campoTELEFONO, campoPASS;
   Button botonregistro;
   ProgressDialog progreso;

   RequestQueue request;
   JsonObjectRequest jsonObjectRequest;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        campoEMAIL= (EditText) findViewById(R.id.campoEMAIL);
        campoNOMBRE= (EditText) findViewById(R.id.campoNOMBRE);
        campoTELEFONO= (EditText) findViewById(R.id.campoTELEFONO);
        campoPASS= (EditText) findViewById(R.id.campoPASS);

        botonregistro= (Button) findViewById(R.id.botonregistro);

        request= Volley.newRequestQueue(getApplicationContext());


        botonregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Toast.makeText(getApplicationContext(),"Usuario Registrado Con Exito", Toast.LENGTH_LONG).show();
            }
        });


    }

    private void cargarWebService() {

         progreso=new ProgressDialog(getApplicationContext());
         progreso.setMessage("Cargando...");
         progreso.show();

        String url="http://canchasid/registrar_usuario?email="+campoEMAIL.getText().toString()+
                "&nombre="+campoNOMBRE.getText().toString()+"&telefono="+campoTELEFONO.getText().toString()+"&password="+campoPASS.getText().toString();

        url=url.replace(" ", " %20");

        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add (jsonObjectRequest);


    }

    @Override
    public void onResponse(JSONObject response) {

        Toast.makeText(getApplicationContext(),"Se ha Registrado Correctamente", Toast.LENGTH_LONG).show();
        progreso.hide();
        campoEMAIL.setText(" ");
        campoNOMBRE.setText(" ");
        campoTELEFONO.setText(" ");
        campoPASS.setText( " ");
    }

    @Override
    public void onErrorResponse(VolleyError error) {

        progreso.hide();
        Toast.makeText(getApplicationContext(),"No Se ha Registrado Correctamente", Toast.LENGTH_LONG).show();
        Log.i("Error",error.toString());
    }




    public void onclick6(View view) {
            Intent miIntent = new Intent(RegistroUsuario.this, Actividad1.class);
            startActivity(miIntent);
        }


    public void onClick7(View view) {
        Toast.makeText(this, "El USUARIO SE HA REGISTRADO", Toast.LENGTH_SHORT).show();
    }
}





