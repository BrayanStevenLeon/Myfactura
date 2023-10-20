package com.example.myfactura;

public class CalculadoraFactura {
    public double calcularTotalNeto(int cantidad, double costoUnitario) {
        return cantidad * costoUnitario;
    }

    public double calcularTotalConImpuestos(double totalNeto, double tasaIVA) {
        return totalNeto * (1 + tasaIVA);
    }
}
