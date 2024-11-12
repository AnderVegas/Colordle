package com.ander.colordle.adapters;

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
        holder.assignData(cardList.get(position).getNombre()
                //,cardList.get(position).getIntentos(), cardList.get(position).getImagen(), cardList.get(position).getColor(),position
                , listener);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {
        //private ImageView imagen;
        private TextView nombre;
        //private TextView intentos;
        //private TextView puesto;
        public DataHolder(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView)itemView.findViewById(R.id.textViewNombre);
            //intentos = (TextView)itemView.findViewById(R.id.textViewIntentos);
            //imagen = (ImageView)itemView.findViewById(R.id.imageView);
            //puesto = (TextView)itemView.findViewById(R.id.textViewPuesto);
        }

        public void assignData(String name
                               //, int intento, Integer img, Integer color, int puest
                               , OnItemClickListener listener) {
            nombre.setText(name);
            //imagen.setImageResource(img);
            //puesto.setText(puest);
            //intentos.setText(intento);

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
