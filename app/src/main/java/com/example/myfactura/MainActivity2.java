package com.example.myfactura;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {

    private TextView totalNetoTextView;
    private TextView totalImpuestosTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        totalNetoTextView = findViewById(R.id.totalNetoTextView);
        totalImpuestosTextView = findViewById(R.id.totalImpuestosTextView);

        // Recibir los valores pasados desde la primera pantalla a través de Intent
        Intent intent = getIntent();
        double totalNeto = intent.getDoubleExtra("totalNeto", 0.0);
        double totalConImpuestos = intent.getDoubleExtra("totalConImpuestos", 0.0);

        // Formatear el totalNeto
        String totalNetoFormateado = formatearValor(totalNeto);
        String totalImpuestosFormateado = formatearValor(totalConImpuestos);

        // Mostrar los valores en los TextView correspondientes
        totalNetoTextView.setText("Total Neto: $" + totalNetoFormateado);
        totalImpuestosTextView.setText("Total con Impuestos: $" + totalImpuestosFormateado);
    }

    // Función para formatear el valor con punto para miles y coma para millones
    private String formatearValor(double valor) {
        if (valor >= 1000000) {
            DecimalFormat formatoMillones = new DecimalFormat("###,##0.000");
            return formatoMillones.format(valor);
        } else {
            DecimalFormat formatoMiles = new DecimalFormat("###.000");
            return formatoMiles.format(valor);
        }
    }
}
