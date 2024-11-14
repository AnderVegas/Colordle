package com.ander.colordle.models;

public class ColorJuego {

    private String caracter1;
    private String caracter2;
    private String caracter3;
    private String caracter4;
    private String caracter5;
    private String caracter6;

    public ColorJuego(String caracter1, String caracter2, String caracter3, String caracter4, String caracter5, String caracter6) {
        this.caracter1 = caracter1;
        this.caracter2 = caracter2;
        this.caracter3 = caracter3;
        this.caracter4 = caracter4;
        this.caracter5 = caracter5;
        this.caracter6 = caracter6;
    }

    public String getCaracter1() {
        return caracter1;
    }

    public String getCaracter2() {
        return caracter2;
    }

    public String getCaracter3() {
        return caracter3;
    }

    public String getCaracter4() {
        return caracter4;
    }

    public String getCaracter5() {
        return caracter5;
    }

    public String getCaracter6() {
        return caracter6;
    }
}
