package com.example.canchaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Add_canchas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_canchas);
    }

    public void onClick20(View view) {
 {
            Toast.makeText(this, "SE HA REGISTRADO LA CANCHA", Toast.LENGTH_SHORT).show();
        }

    }

    public void onClick21(View view) {
        Intent miIntent = new Intent(Add_canchas.this, Editadministrador.class);
        startActivity(miIntent);

    }
}
