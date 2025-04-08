```mermaid
classDiagram
    class Alumno {
        +int legajo
        +String nombre
        +Materia[] materiasAprobadas
        +Alumno(int legajo, String nombre, Materia[] materiasAprobadas)
        +Materia[] getMateriasAprobadas()
        +boolean tieneMateriasAprobadas()
    }

    class Inscripcion {
        +Alumno alumno
        +Materia[] nuevaMaterias
        +Inscripcion(Alumno alumno, Materia[] materias)
        +boolean aprobada()
        +boolean materiaAprobada(Materia nuevaMateria)
    }

    class Materia {
        +String nombre
        +Materia[] correlativas
        +Materia(String nombre, Materia[] correlativas)
        +Materia[] getCorrelativas()
        +boolean tieneCorrelativas()
    }

    Alumno "1" -- "0..*" Materia : tiene materias aprobadas
    Inscripcion "1" -- "1" Alumno : pertenece a
    Inscripcion "1" -- "0..*" Materia : inscribe a
    Materia "0..*" -- "0..*" Materia : tiene correlativas
