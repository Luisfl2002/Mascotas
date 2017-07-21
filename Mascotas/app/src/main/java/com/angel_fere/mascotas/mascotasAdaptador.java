package com.angel_fere.mascotas;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Angel_Fere on 20/07/2017.
 */

public class mascotasAdaptador extends RecyclerView.Adapter<mascotasAdaptador.MascotasViewHolder> {

    ArrayList<Mascotas> mascotas;
    Activity activity;

    public mascotasAdaptador (ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }




    public MascotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent, false );
        return new MascotasViewHolder(v);
    }

    public int getItemCount(){

        return mascotas.size();


    }


    public void onBindViewHolder(final MascotasViewHolder mascotasViewHolder, final int position ){
        final Mascotas mascota = mascotas.get(position);
        mascotasViewHolder.imgMascota.setImageResource(mascota.getFoto());
        mascotasViewHolder.tvNombre.setText(mascota.getNombre());
        mascotasViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()));

        mascotasViewHolder.btnHuesitoLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"Like",Toast.LENGTH_SHORT).show();
                mascota.setLikes(mascota.getLikes()+1);
                mascotasViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()));
            }
        });
    }





    public static class MascotasViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgMascota;
        private TextView tvNombre;
        private TextView tvLikes;
        private ImageButton btnHuesitoLike;
        private LinearLayout fondo;

        public  MascotasViewHolder (View itemView){
            super(itemView);
            imgMascota = (ImageView)itemView.findViewById(R.id.imgMascota);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvLikes = (TextView)itemView.findViewById(R.id.tvLikes);
            btnHuesitoLike = (ImageButton)itemView.findViewById(R.id.btnHuesitoLike);
            fondo = (LinearLayout) itemView.findViewById(R.id.fondo);


        }


    }


}
