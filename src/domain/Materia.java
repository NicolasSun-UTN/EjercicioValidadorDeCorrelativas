package domain;

import java.util.Objects;

public class Materia {
    private String nombre;
    private Materia[] correlativas;

    public Materia(String nombre, Materia[] correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public Materia[] getCorrelativas() {
        return this.correlativas;
    }

    public boolean tieneCorrelativas() {
        if (this.correlativas == null) {
            return false;
        }
        return this.correlativas.length != 0;
    }
}
