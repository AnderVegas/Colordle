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
import io.realm.Sort;

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

        realm.deleteAll();

        // Añadimos elementos a la lista
        list.add(new Puntuacion("Alberto"
                , 3, 23000
        ));
        // Añadimos elementos a la lista
        list.add(new Puntuacion("jfdjkfjfjkf"
                , 3, 220000
        ));
        // Añadimos elementos a la lista
        list.add(new Puntuacion("Albjrvkebikerberto"
                , 4, 100000
        ));
        // Añadimos elementos a la lista
        list.add(new Puntuacion("greer"
                , 5, 2003200
        ));
        // Añadimos elementos a la lista
        list.add(new Puntuacion("ikuyiul"
                , 5, 50000
        ));
        // Añadimos elementos a la lista
        list.add(new Puntuacion("ukyh"
                , 3, 25000
        ));
        // Añadimos elementos a la lista
        list.add(new Puntuacion("csasd"
                , 4, 80000
        ));
        // Añadimos elementos a la lista
        list.add(new Puntuacion("ukyh"
                , 5, 60000
        ));
        // Añadimos elementos a la lista
        list.add(new Puntuacion("csasd"
                , 33, 110000
        ));


        realm.copyToRealmOrUpdate(list);
        realm.commitTransaction();

        // Pasamos los resultados de la consulta a una lista "RealmResults" y ordenamos primero por 'intentos' en orden ascendente, luego por 'duracion' en orden ascendente si 'intentos' es igual
        listRealm = realm.where(Puntuacion.class)
                .sort(new String[]{"intentos", "duracion"}, new Sort[]{Sort.ASCENDING, Sort.ASCENDING})
                .findAll();


        // Inicializamos el DataAdapters
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
