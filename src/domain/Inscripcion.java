package domain;

import java.util.Objects;

public class Inscripcion {
    Alumno alumno;
    Materia[] nuevaMaterias;

    public Inscripcion(Alumno alumno, Materia[] materias) {
        this.alumno = alumno;
        this.nuevaMaterias = materias;
    }

    public boolean aprobada() {
        var aprobada = false;
        for (Materia nuevaMateria : this.nuevaMaterias) {
            aprobada = materiaAprobada(nuevaMateria);
            if (!aprobada) {
                return false;
            }
        }

        return aprobada;
    }

    public boolean materiaAprobada(Materia nuevaMateria) {
        if (nuevaMateria.tieneCorrelativas()) {
            if (!this.alumno.tieneMateriasAprobadas()) {
                return false;
            }

            for (var correlativa : nuevaMateria.getCorrelativas()) {
                if (!materiaAprobada(correlativa)) {
                    return false;
                }
                var cumple = false;
                for (var materiaAprobada : this.alumno.getMateriasAprobadas()) {
                    if (Objects.equals(correlativa, materiaAprobada)) {
                        cumple = true;
                    }
                }

                if (!cumple) {
                    return false;
                }
            }
        }
        return true;
    }
}
