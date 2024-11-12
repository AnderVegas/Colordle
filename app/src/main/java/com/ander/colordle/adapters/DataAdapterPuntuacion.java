package com.ander.colordle.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ander.colordle.R;
import com.ander.colordle.models.Puntuacion;

import java.util.List;

public class DataAdapterPuntuacion extends RecyclerView.Adapter<DataAdapterPuntuacion.DataHolder> {

    private List<Puntuacion> cardList;
    private OnItemClickListener listener;

    public DataAdapterPuntuacion(List<Puntuacion> itemCard, OnItemClickListener listener) {
        this.cardList = itemCard;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DataAdapterPuntuacion.DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerpuntuacion,parent,false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapterPuntuacion.DataHolder holder, int position) {
        holder.assignData(cardList.get(position).getNombre(),cardList.get(position).getIntentos(), position, cardList.get(position).getDuracion(), listener);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {
        //private ImageView imagen;
        private TextView nombre;
        private TextView intentos;
        private TextView puesto;
        private TextView duracion;
        public DataHolder(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView)itemView.findViewById(R.id.textViewNombre);
            intentos = (TextView)itemView.findViewById(R.id.textViewIntentos);
            puesto = (TextView)itemView.findViewById(R.id.textViewPuesto);
            duracion = (TextView)itemView.findViewById(R.id.textViewTiempo);
        }

        public void assignData(String name, int intento, int puest, long tiempo, OnItemClickListener listener) {
            nombre.setText(name);
            puesto.setText(String.valueOf(puest+ 1));

            if (puest == 0) {
                puesto.setText("");
                puesto.setBackgroundResource(R.drawable.oro1);
                //puesto.setBackgroundResource(R.drawable.oro);
                //puesto.setTextColor(Color.parseColor("#FFFFFF"));
            } else if (puest == 1) {
                puesto.setText("");
                puesto.setBackgroundResource(R.drawable.plata2);
                //puesto.setBackgroundResource(R.drawable.plata);
                //puesto.setTextColor(Color.parseColor("#FFFFFF"));
            } else if (puest == 2) {
                puesto.setText("");
                puesto.setBackgroundResource(R.drawable.bronce3);
                //puesto.setBackgroundResource(R.drawable.bronce);
                //puesto.setTextColor(Color.parseColor("#FFFFFF"));
            }

            // Formatear duracion de la partida de milisegundos a segundos/minutos
            long seconds = (tiempo / 1000) % 60;
            long minutes = (tiempo / (1000 * 60)) % 60;
            String tiempoFormateado = String.format("%02d:%02d", minutes, seconds);
            duracion.setText(tiempoFormateado);

            intentos.setText(String.valueOf(intento));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(name, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(String string, int position);
    }
}
