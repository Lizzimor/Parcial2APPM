package com.example.parcial2.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2.R;
import com.example.parcial2.clases.Actor;
import com.example.parcial2.clases.Actor;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.ViewHolder> {

    private List<Actor> datos;
    public UsuarioAdaptador(List<Actor> datos){
        this.datos = datos;
    }
    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adaptador,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Actor dato = datos.get(position);
        holder.bind(dato);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(dato);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_name, txt_programa;
        ImageView img_Actor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_programa = itemView.findViewById(R.id.txt_programa);
            img_Actor = itemView.findViewById(R.id.img_Actor);
        }
        public void bind (Actor dato){
            txt_name.setText(dato.getNombre());
            txt_programa.setText(dato.getPrograma());
            // imagen libreria
            Picasso.get().load(dato.getImagen()).into(img_Actor);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(Actor actor);
    }

}
