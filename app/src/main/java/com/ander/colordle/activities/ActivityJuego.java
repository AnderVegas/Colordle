package com.ander.colordle.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.ander.colordle.R;

import java.util.Random;

public class ActivityJuego extends AppCompatActivity {

    private int contIntentos;
    private int conLetras;
    private TextView textViewColor;
    private TextView textViewColorElegido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.juego_view);

        // Inicializar textViewColor
        textViewColor = (TextView) findViewById(R.id.textViewColor);
        contIntentos = 0;
        Button buttonEnter = (Button) findViewById(R.id.buttonEnter); 

                // Generar un color hexadecimal aleatorio completo (#RRGGBB)
        String[] hexChars = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        Random random = new Random();
        String colorHex = "#";

        // Generar dos caracteres hexadecimales para cada componente (R, G, B)
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(16); // Índice aleatorio entre 0 y 15
            colorHex += hexChars[index];
        }

        // Convertir el color hexadecimal a un entero y establecerlo como color de fondo
        textViewColor.setBackgroundColor(Color.parseColor(colorHex));

        // Mostrar el color generado en el TextView (opcional)
        textViewColor.setText(colorHex);

        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colorElegido = "#";
                TextView textView;

                textView = (TextView) findViewById(R.id.letterText1);
                colorElegido = colorElegido += textView.getText().toString();

                textView = (TextView) findViewById(R.id.letterText2);
                colorElegido = colorElegido += textView.getText().toString();

                textView = (TextView) findViewById(R.id.letterText3);
                colorElegido = colorElegido += textView.getText().toString();

                textView = (TextView) findViewById(R.id.letterText4);
                colorElegido = colorElegido += textView.getText().toString();

                textView = (TextView) findViewById(R.id.letterText5);
                colorElegido = colorElegido += textView.getText().toString();

                textView = (TextView) findViewById(R.id.letterText6);
                colorElegido = colorElegido += textView.getText().toString();

                textViewColorElegido = (TextView) findViewById(R.id.textViewColorElegido);
                textViewColorElegido.setText(colorElegido);
                textViewColorElegido.setBackgroundColor(Color.parseColor(colorElegido));
            }
        });
        
        
        
    }
}
