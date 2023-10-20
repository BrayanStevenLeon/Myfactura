package com.example.myfactura;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText cantidadProductosEditText;
    private EditText costoUnitarioEditText;
    private Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cantidadProductosEditText = findViewById(R.id.cantidadProductosEditText);
        costoUnitarioEditText = findViewById(R.id.costoUnitarioEditText);
        calcularButton = findViewById(R.id.calcularButton);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la cantidad de productos y el costo unitario ingresados
                int cantidad = Integer.parseInt(cantidadProductosEditText.getText().toString());
                double costoUnitario = Double.parseDouble(costoUnitarioEditText.getText().toString());

                // Calcular el total neto
                double totalNeto = cantidad * costoUnitario;

                // Calcular el total con impuestos (IVA al 16%) utilizando una función recursiva
                double totalConImpuestos = calcularTotalConImpuestos(totalNeto);

                // Crear un Intent para pasar los resultados a la segunda pantalla
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("totalNeto", totalNeto);
                intent.putExtra("totalConImpuestos", totalConImpuestos);

                // Iniciar la segunda actividad
                startActivity(intent);
            }
        });
    }

    // Función recursiva para calcular el total con impuestos (IVA)
    private double calcularTotalConImpuestos(double totalNeto) {
        if (totalNeto == 0) {
            return 0;
        }

        return totalNeto + (totalNeto * 0.19);
    }
}