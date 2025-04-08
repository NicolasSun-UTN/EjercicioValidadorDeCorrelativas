package domain;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MateriaTest {

    @Test
    public void tieneCorrelativas() {
        var want = true;
        var materia1 = new Materia("materia1", null);
        var materia2 = new Materia("materia2", null);
        var materia3 = new Materia("materia3", new Materia[]{materia1, materia2});

        var got = materia3.tieneCorrelativas();

        Assertions.assertEquals(want, got);
    }

    @Test
    public void noTieneCorrelativas() {
        var want = false;
        var materia1 = new Materia("materia1", null);

        var got = materia1.tieneCorrelativas();

        Assertions.assertEquals(want, got);
    }
}