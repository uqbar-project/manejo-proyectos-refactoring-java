package org.uqbar.manejoProyectos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTareaCompuesta {

    @DisplayName("al calcular el costo suma el costo por overhead correctamente")
    @Test
    public void testCostoCompuesta() {
        // arrange
        TareaCompuesta tareaCompuesta = new TareaCompuesta();
        tareaCompuesta.setTiempo(15);
        tareaCompuesta.agregarSubtarea(new TareaSimple(10));
        tareaCompuesta.agregarSubtarea(new TareaSimple(10));
        tareaCompuesta.agregarSubtarea(new TareaSimple(10));
        tareaCompuesta.agregarSubtarea(new TareaSimple(10));

        // assert
        assertEquals(390.0, tareaCompuesta.getCosto(), 0.01);
    }

}
