package domain;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class InscripcionTest {

    @Test
    public void aprobadaSinCorrelativas() {
        var want = true;
        var materia1 = new Materia("materia1", null);
        var ingresante = new Alumno(1234, "nicolas", null);
        var inscripcionNueva = new Inscripcion(ingresante, new Materia[]{materia1});

        var got = inscripcionNueva.aprobada();

        Assertions.assertEquals(want, got);
    }

    @Test
    public void aprobadaConCorrelativas() {
        var want = true;
        var materia1 = new Materia("materia1", null);
        var materia2 = new Materia("materia2", new Materia[]{materia1});
        var materia3 = new Materia("materia3", new Materia[]{materia2});
        var ingresante = new Alumno(1234, "nicolas", new Materia[]{materia1, materia2});
        var inscripcionNueva = new Inscripcion(ingresante, new Materia[]{materia3});

        var got = inscripcionNueva.aprobada();

        Assertions.assertEquals(want, got);
    }

    @Test
    public void noAprobadaNoTieneMateriasAprobadas() {
        var want = false;
        var materia1 = new Materia("materia1", null);
        var materia2 = new Materia("materia2", new Materia[]{materia1});
        var ingresante = new Alumno(1234, "nicolas", null);
        var inscripcionNueva = new Inscripcion(ingresante, new Materia[]{materia2});

        var got = inscripcionNueva.aprobada();

        Assertions.assertEquals(want, got);
    }

    @Test
    public void noAprobadaNoTieneSuficientesCorrelativasAprobadas() {
        var want = false;
        var materia1 = new Materia("materia1", null);
        var materia2 = new Materia("materia2", null);
        var materia3 = new Materia("materia2", new Materia[]{materia1, materia2});
        var ingresante = new Alumno(1234, "nicolas", new Materia[]{materia1});
        var inscripcionNueva = new Inscripcion(ingresante, new Materia[]{materia3});

        var got = inscripcionNueva.aprobada();

        Assertions.assertEquals(want, got);
    }

    @Test
    public void noAprobadaNoTieneCorrelativaDeLaCorrelativasAprobadas() {
        var want = false;
        var materia1 = new Materia("materia1", null);
        var materia2 = new Materia("materia2", new Materia[]{materia1});
        var materia3 = new Materia("materia2", new Materia[]{materia2});
        var ingresante = new Alumno(1234, "nicolas", new Materia[]{materia2});
        var inscripcionNueva = new Inscripcion(ingresante, new Materia[]{materia3});

        var got = inscripcionNueva.aprobada();

        Assertions.assertEquals(want, got);
    }
}