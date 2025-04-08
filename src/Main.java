import domain.Alumno;
import domain.Inscripcion;
import domain.Materia;

public class Main {
    public static void main(String[] args) {
        var materia1 = new Materia("materia1", null);
        var materia2 = new Materia("materia2", null);
        var materia3 = new Materia("materia3", new Materia[]{materia1});
        var materia4 = new Materia("materia4", new Materia[]{materia2});
        var materia5 = new Materia("materia5", new Materia[]{materia1, materia2});
        var materia6 = new Materia("materia6", new Materia[]{materia3});


        var ingresante = new Alumno(1234, "nicolas", new Materia[]{materia6});

        var inscripcionNueva = new Inscripcion(ingresante, new Materia[]{materia6});

        if (inscripcionNueva.aprobada()) {
            System.out.println("Inscripcion aprobada");
        } else {
            System.out.println("Inscripcion desaprobada");
        }
    }
}