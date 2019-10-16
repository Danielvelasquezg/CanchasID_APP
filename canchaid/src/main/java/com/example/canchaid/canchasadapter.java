package com.example.canchaid;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class canchasadapter extends RecyclerView.Adapter<canchasadapter.CanchaHolder> implements View.OnClickListener


{

    private ArrayList <cancha> listcancha;
    private View.OnClickListener listener;


    public canchasadapter(ArrayList <cancha> listcancha) {

        this.listcancha = listcancha;
    }

    @NonNull
    @Override
    public CanchaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View vista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemcanchas, viewGroup, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        vista.setOnClickListener(this);
        return new CanchaHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull CanchaHolder canchaHolder, int i) {

        if (listcancha.size() != 0) {
            canchaHolder.nombre.setText(listcancha.get(i).getNombre().toString());
            canchaHolder.direccion.setText(listcancha.get(i).getDireccion().toString());
            canchaHolder.valor_hora.setText(listcancha.get(i).getValor_hora().toString());
            canchaHolder.celular.setText(listcancha.get(i).getCelular().toString());
            canchaHolder.descripcion.setText(listcancha.get(i).getDescripcion().toString());
            canchaHolder.email_propietario.setText(listcancha.get(i).getEmail_propietario().toString());
            canchaHolder.hora_inicial.setText(listcancha.get(i).getHora_inicial().toString());
            canchaHolder.hora_final.setText(listcancha.get(i).getHora_final().toString());


        } else {

        }

    }
public void setOnClickListener(View.OnClickListener listener){this.listener = listener;}

    @Override
    public int getItemCount() {
        return listcancha.size();
    }

    @Override
    public void onClick(View v) {
if (listener != null){
    listener.onClick(v);
}
    }

    public class CanchaHolder extends RecyclerView.ViewHolder {



        TextView nombre, direccion, valor_hora, celular , descripcion , email_propietario , hora_inicial , hora_final;

        public CanchaHolder(@NonNull View itemView) {
            super(itemView);

            nombre = (TextView)itemView.findViewById(R.id.txt_nombrecancha);
            direccion = (TextView)itemView.findViewById(R.id.txt_direccioncancha);
            valor_hora = (TextView)itemView.findViewById(R.id.txt_Valor);
            celular = (TextView)itemView.findViewById(R.id.txt_celular);
            descripcion = (TextView)itemView.findViewById(R.id.txt_Descripcioncancha);
            email_propietario = (TextView)itemView.findViewById(R.id.txt_Emailcancha);
            hora_inicial = (TextView)itemView.findViewById(R.id.txt_Horaapertura);
            hora_final = (TextView)itemView.findViewById(R.id.txt_Horacierre);






        }
    }
}
