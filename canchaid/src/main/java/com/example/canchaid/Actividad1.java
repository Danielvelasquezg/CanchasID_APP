package com.example.canchaid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Actividad1 extends AppCompatActivity implements Response.Listener<JSONObject>,
        Response.ErrorListener{

    private EditText usuario;
    private EditText password;
    private Button ingresar;
    private Button registro;
    private Button administrador;
    private int idusuario;
    private String nombreusuario;

    ProgressDialog progreso;
    JsonObjectRequest jsonObjectRequest;

    StringRequest stringRequest;

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);


        usuario = (EditText) findViewById(R.id.usuario);
        password = (EditText) findViewById(R.id.password);
        ingresar = (Button) findViewById(R.id.login);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarWebService1();
            }
        });
        registro = (Button) findViewById(R.id.Registro1);



    }


    public void onClick (View View) {

        Intent miIntent= new Intent (Actividad1.this, ActividadMenu.class);
        startActivity(miIntent);
        view = View;


    }

    public void onClick2(View view) {

        Intent miIntent = new Intent(Actividad1.this, RegistroUsuario.class);
        startActivity(miIntent);

    }

    public void onClick9(View view) {

        Intent miIntent = new Intent(Actividad1.this, Actividad2.class);
        startActivity(miIntent);

    }


   /* @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    } */

    private void cargarWebService1() {

      /*  progreso.setMessage("Consultando...");
        progreso.show();*/

        //int cod=Integer.parseInt(edt_codigo.getText().toString());
        String email = usuario.getText().toString();
        String password1 = password.getText().toString();

        String url_lh=Globals.url;
        // String ip = getString(R.string.ip);

        //String url = "http://192.168.0.13/" +
        String url = "http://"+url_lh+"/" +
                //"ejemploBDRemota/wsJSONConsultarUsuario.php?documento=" + campoDocumento.getText().toString();
                "canchasid/consultarusuario.php?password="+password1+"&email="+email;
        // Toast.makeText(getApplicationContext(), "Mensaje: " + cod, Toast.LENGTH_SHORT).show();
        // String url = ip+"ejemploBDRemota/wsJSONConsultarUsuarioImagen.php?documento=" + campoDocumento.getText().toString();

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        // request.add(jsonObjectRequest);
        VolleySingleton.getIntanciaVolley(getApplicationContext()).addToRequestQueue(jsonObjectRequest);//p21
    }

    @Override
    public void onErrorResponse(VolleyError error) {
     //   progreso.hide();
        Toast.makeText(getApplicationContext(), "No se ha realizado la consulta de usuario" + error.toString(), Toast.LENGTH_LONG).show();
        System.out.println("ERROR:->"+error.toString());
        //Log.i("ERROR", error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
       // progreso.hide();
        Toast.makeText(getApplicationContext(), "Mensaje: " + response.toString(), Toast.LENGTH_SHORT).show();
        System.out.println("Mensaje:----> " + response.toString());


        JSONArray json = response.optJSONArray("usuario");
        JSONObject jsonObject = null;

        try {
            jsonObject = json.getJSONObject(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // jsonObject = new JSONObject(response);

    /*    if (usuario == "administrador") {

        } else if (usuario == "docente") {*/
        usuario usuario = new usuario();
        usuario.setId(jsonObject.optInt("id"));
        usuario.setNombre(jsonObject.optString("nombre"));
        usuario.setRol(jsonObject.optString("rol"));

        String rol = usuario.getRol();
        System.out.println("rol"+rol);

        if (rol.equals("cliente") ) {


            Intent intent = new Intent(Actividad1.this, ActividadMenu.class);
            int idusuario = usuario.getId();
            String nameusuario = usuario.getNombre();
            intent.putExtra("id", idusuario);
            intent.putExtra("nombre", nombreusuario);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "cliente: " + usuario.getNombre().toString(), Toast.LENGTH_SHORT).show();
        }
      if (rol.equals("administrador")) {
            Intent intentadm = new Intent(Actividad1.this, Editadministrador.class);
            int idusuario = usuario.getId();
            String nameusuario = usuario.getNombre();
            intentadm.putExtra("id", idusuario);
            intentadm.putExtra("nombre", nombreusuario);
            startActivity(intentadm);
            Toast.makeText(getApplicationContext(), "BIENVENIDO ADMINISTRADOR: " + usuario.getNombre().toString(), Toast.LENGTH_SHORT).show();
            System.out.println("administrador: " + usuario.getNombre().toString());

        }

    }


}


