package org.uqbar.manejoProyectos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Tests de tarea simple")
class TestTareaSimple {

    @DisplayName("calcula correctamente el costo si la complejidad es máxima y tiene un tiempo largo")
    @Test
    public void testCostoComplejidadMaximaTareaLarga() {
        // arrange
        Tarea tareaSimple = new TareaSimple();
        tareaSimple.setTiempo(20);
        tareaSimple.setComplejidad(3);

        // assert
        assertEquals(635.0, tareaSimple.getCosto(), 0.01);
    }

    @Test
    @DisplayName("calcula correctamente el costo si la complejidad es máxima y tiene un tiempo corto")
    public void testCostoComplejidadMaximaTareaChica() {
        // arrange
        Tarea tareaSimple = new TareaSimple();
        tareaSimple.setComplejidad(3);
        tareaSimple.setTiempo(10);

        // assert
        assertEquals(tareaSimple.getCosto(), 267.5, 0.01);
    }

    @Test
    @DisplayName("calcula correctamente el costo si la complejidad es media")
    public void testCostoComplejidadMedia() {
        // arrange
        Tarea tareaSimple = new TareaSimple();
        tareaSimple.setComplejidad(2);
        tareaSimple.setTiempo(10);

        // assert
        assertEquals(tareaSimple.getCosto(), 262.5, 0.01);
    }

    @Test
    @DisplayName("calcula correctamente el costo si la complejidad es mínima")
    public void testCostoSimple() {
        // arrange
        Tarea tareaSimple = new TareaSimple();
        tareaSimple.setComplejidad(1);
        tareaSimple.setTiempo(20);

        // assert
        assertEquals(tareaSimple.getCosto(), 500.0, 0.01);
    }

    @DisplayName("no es válido agregar una subtarea a una tarea simple")
    @Test
    public void testAgregarSubtareaATareaSimple() {
        // arrange
        Tarea tareaSimple = new TareaSimple();
        tareaSimple.setTiempo(20);

        // assert
//        assertThrows(BusinessException, [ tareaSimple.agregarSubtarea(new TareaSimple) ], "No puede agregar subtareas")
    }

    @DisplayName("calcula correctamente el costo para una tarea simple con impuestos")
    @Test
    public void testCostoConImpuestos() {
        // arrange
        Tarea tareaSimpleConImpuestos = new TareaSimple();
        tareaSimpleConImpuestos.setComplejidad(1);
        tareaSimpleConImpuestos.setTiempo(10);
        tareaSimpleConImpuestos.agregarImpuesto(3);
        tareaSimpleConImpuestos.agregarImpuesto(5);

        // assert
        assertEquals(270, tareaSimpleConImpuestos.getCosto(), 0.01);
    }

}