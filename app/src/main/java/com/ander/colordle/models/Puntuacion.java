package com.ander.colordle.models;

import com.ander.colordle.app.MyApplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Puntuacion extends RealmObject {

    @PrimaryKey
    private int id;
    private String nombre;
    //private int intentos;
    //private Integer imagen; // Pueden ser null
    //private Integer color;  // Pueden ser null
    // private int puesto;

    public Puntuacion() {
    }

    public Puntuacion(String nombre
            //, int intentos, Integer imagen, Integer color
    ) {
        this.id = MyApplication.cardID.incrementAndGet();
        this.nombre = nombre;
        //this.intentos = intentos;
        //this.imagen = imagen;
        //this.color = color;
        //this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //public int getIntentos() {
    //    return intentos;
    //}
//
    //public void setIntentos(int intentos) {
    //    this.intentos = intentos;
    //}
//
    //public Integer getImagen() {
    //    return imagen;
    //}
//
    //public void setImagen(Integer imagen) {
    //    this.imagen = imagen;
    //}
//
    //public Integer getColor() {
    //    return color;
    //}
//
    //public void setColor(Integer color) {
    //    this.color = color;
    //}

    //public int getPuesto() {
    //    return puesto;
    //}
//
    //public void setPuesto(int puesto) {
    //    this.puesto = puesto;
    //}
}
