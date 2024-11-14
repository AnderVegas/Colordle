package com.ander.colordle.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ander.colordle.R;

import java.util.List;

public class AdapterJuego extends RecyclerView.Adapter<AdapterJuego.ViewHolder>{


    private List<String> items;

    // Constructor
    public AdapterJuego(List<String> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutjuego, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Asignar los datos al ViewHolder
        holder.textView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        // Limitar la cantidad de elementos a 5
        return Math.min(5, items.size()); // Devuelve el mínimo entre 5 y el tamaño de la lista
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView); // Asume que en tu layout 'layoutjuego' tienes un TextView con ID 'textView'
        }
    }
}
