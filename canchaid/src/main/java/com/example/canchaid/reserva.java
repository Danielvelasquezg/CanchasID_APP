package com.example.canchaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class reserva extends AppCompatActivity {

    Button btnreserva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);


        btnreserva= (Button) findViewById(R.id.btnreserva);
        btnreserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"SE HA RESERVADO EXITOSAMENTE", Toast.LENGTH_LONG).show();
                Intent miIntent = new Intent(reserva.this, Datos_Reserva_exitosa.class);
                startActivity(miIntent);
            }

        });
    }


    public void onClick24(View view) {

        Intent miIntent = new Intent(reserva.this, Datos_Reserva_exitosa.class);
        startActivity(miIntent);
        }
}
