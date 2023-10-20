package com.example.myfactura;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculadoraFacturaTest {
    @Test
    public void testCalcularTotalNeto() {
        CalculadoraFactura calculadora = new CalculadoraFactura();
        double totalNeto = calculadora.calcularTotalNeto(10, 25000.0);
        assertEquals(250000.0, totalNeto, 0.01); // Verifica si el resultado es igual a 250000.0 con una tolerancia de 0.01
    }

    @Test
    public void testCalcularTotalConImpuestos() {
        CalculadoraFactura calculadora = new CalculadoraFactura();
        double totalConImpuestos = calculadora.calcularTotalConImpuestos(250000.0, 0.19);
        assertEquals(297500.0, totalConImpuestos, 0.01); // Verifica si el resultado es igual a 297500.0 con una tolerancia de 0.01
    }
}
