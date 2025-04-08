package domain;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AlumnoTest {

    @Test
    public void tieneMateriasAprobadas() {
        var want = true;
        var materia1 = new Materia("materia1", null);
        var materia2 = new Materia("materia2", null);
        var materia3 = new Materia("materia3", new Materia[]{materia1});
        var alumno = new Alumno(12345, "nicolas", new Materia[]{materia1, materia2, materia3});

        var got = alumno.tieneMateriasAprobadas();

        Assertions.assertEquals(want, got);
    }

    @Test
    public void noTieneMateriasAprobadas() {
        var want = false;
        var alumno = new Alumno(12345, "nicolas", null);

        var got = alumno.tieneMateriasAprobadas();

        Assertions.assertEquals(want, got);
    }
}