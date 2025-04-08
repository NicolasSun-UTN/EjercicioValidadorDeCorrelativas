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
            if (nuevaMateria.tieneCorrelativas()) {
                if (!this.alumno.tieneMateriasAprobadas()) {
                    return false;
                }

                for (var correlativa : nuevaMateria.getCorrelativas()) {
                    var cumple = false;
                    for (var materiaAprobada : this.alumno.getMateriasAprobadas()) {
                        if (Objects.equals(correlativa, materiaAprobada) || Objects.equals(nuevaMateria, materiaAprobada)) {
                            cumple = true;
                        }
                    }

                    if (!cumple) {
                        return false;
                    }
                }
                aprobada = true;
            } else {
                aprobada = true;
            }
        }

        return aprobada;
    }
}
