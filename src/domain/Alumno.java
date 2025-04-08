package domain;

public class Alumno {
    private int legajo;
    private String nombre;
    private Materia[] materiasAprobadas;

    public Alumno(int legajo, String nombre, Materia[] materiasAprobadas) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.materiasAprobadas = materiasAprobadas;
    }

    public Materia[] getMateriasAprobadas() {
        return this.materiasAprobadas;
    }

    public boolean tieneMateriasAprobadas() {
        return materiasAprobadas != null && materiasAprobadas.length > 0;
    }
}
