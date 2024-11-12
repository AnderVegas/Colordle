package com.ander.colordle.models;

import com.ander.colordle.app.MyApplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Puntuacion extends RealmObject {

    @PrimaryKey
    private int id;
    private String nombre;
    private int intentos;
    private long duracion; // Tiempo total en milisegundos

    public Puntuacion() {
    }

    // Constructor para inicializar con nombre, intentos y duración
    public Puntuacion(String nombre, int intentos, long duracion) {
        this.id = MyApplication.cardID.incrementAndGet();
        this.nombre = nombre;
        this.intentos = intentos;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }
}
