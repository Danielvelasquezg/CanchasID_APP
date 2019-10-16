package com.example.canchaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

public class Actividad2 extends AppCompatActivity implements Response.Listener<JSONObject>,
        Response.ErrorListener{

    private EditText emailadmin;
    private EditText passadmin;
    private Button loginadmin;
    private Button regresar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);


        emailadmin = (EditText) findViewById(R.id.emailadmin);
        passadmin = (EditText) findViewById(R.id.passadmin);
        loginadmin = (Button) findViewById(R.id.loginadmin);
        regresar2 = (Button) findViewById(R.id.regresar2);
    }



    public void onClick(View view) {

        Intent miIntent= new Intent (Actividad2.this, Actividad1.class);
        startActivity(miIntent);
    }

    public void onClick11(View view) {

        Intent miIntent = new Intent(Actividad2.this, Editadministrador.class);
        startActivity(miIntent);

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
