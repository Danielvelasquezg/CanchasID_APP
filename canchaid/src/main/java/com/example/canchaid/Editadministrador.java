package com.example.canchaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Editadministrador extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_administrador);


    }


   public void onClick12(View view) {
            Intent miIntent = new Intent(Editadministrador.this, Add_canchas.class);
            startActivity(miIntent);

   }

    public void onClick22(View view) {
        Intent miIntent = new Intent(Editadministrador.this, Actividad1.class);
        startActivity(miIntent);

    }
}


