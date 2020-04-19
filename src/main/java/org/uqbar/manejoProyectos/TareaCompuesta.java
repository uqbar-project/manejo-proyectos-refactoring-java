package org.uqbar.manejoProyectos;

import java.util.ArrayList;

public class TareaCompuesta extends Tarea {

    ArrayList<Tarea> subtareas = new ArrayList<Tarea>();

    public double getCosto() {
        if (this.complejidad == 1) {
            costo = this.tiempo * 25;
        }
        if (this.complejidad == 2) {
            costo = this.tiempo * 25 * 1.05;
        }
        if (this.complejidad == 3) {
            int dias1 = this.tiempo - 10;
            int dias2 = dias1 > 0 ? dias1 : 0;
            costo = this.tiempo * 25 * 1.07 + (10 * dias2);
        }
        double costoImpositivo = 0;
        for (int i = 0; i < impuestos.length; i++) {
            costoImpositivo = costoImpositivo + (impuestos[i] * costo);
        }
        costo += costoImpositivo;
        if (this.subtareas.size() > 3) {
            costo = costo * 1.04;
        }
        return costo;
    }

    public void agregarSubtarea(Tarea tarea) {
        this.subtareas.add(tarea);
    }
}
