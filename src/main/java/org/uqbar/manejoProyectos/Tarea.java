package org.uqbar.manejoProyectos;

// Large class
public abstract class Tarea {
    int complejidad = 1;
    int tiempo;
    double costo = 0d;
    int[] impuestos = new int[2];

    static int cantidadImpuestos = 0;

    public void agregarImpuesto(int valor) {
        impuestos[cantidadImpuestos++] = valor;
    }

    public int getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    // long method
    public double getCosto() {
        double costo = 0d;
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
            costoImpositivo = costoImpositivo + (impuestos[i] * costo / 100);
        }
        costo += costoImpositivo;
        return costo;
    }

}
