package com.ander.colordle.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ander.colordle.R;
import com.ander.colordle.adapters.DataAdapterPuntuacion;
import com.ander.colordle.models.Puntuacion;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class ActivityPuntuacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.puntuacion_view);

        // Variables necesarias
        RecyclerView recyclerView;
        ArrayList<Puntuacion> list = new ArrayList<>();
        RealmResults<Puntuacion> listRealm;
        Realm realm = Realm.getDefaultInstance();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerViewPuntuacionId);

        // Comenzamos la Transaccion
        realm.beginTransaction();

        // Añadimos elementos a la lista
        list.add(new Puntuacion("Alberto"
                //, 33, null, null
        ));
        list.add(new Puntuacion("Juan"
                //, 33, null, null
        ));
        list.add(new Puntuacion("gergeerjop"
                //, 33, null, null
        ));
        list.add(new Puntuacion("Albegregerto"
                //, 33, null, null
        ));
        list.add(new Puntuacion("gr5ege5ge5"
                //, 33, null, null
        ));
        list.add(new Puntuacion("geegheg"
                //, 33, null, null
        ));

        // ItemCard card = new ItemCard("Imagenes", "476   607.11MB", R.drawable.imagenes);
        // realm.copyToRealm(card);
        realm.copyToRealmOrUpdate(list);
        realm.commitTransaction();

        // Pasamos los resultados de la consulta a una lista "RealmResults"
        listRealm = realm.where(Puntuacion.class).findAll();

        // Inicializamos los dos DataAdapters para tener las dos posibles vistas(Las cuales se cambian con
        // el switch) y pasamos los datos de la BD de Realm
        DataAdapterPuntuacion recyclerData = new DataAdapterPuntuacion(listRealm, new DataAdapterPuntuacion.OnItemClickListener() {
            @Override
            public void onItemClick(String string, int position) {
                Toast.makeText(ActivityPuntuacion.this, string, Toast.LENGTH_SHORT).show();
            }
        });

        // Pasamos los datos DataAdapters al recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(recyclerData);

    }


}
