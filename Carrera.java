import java.util.*;

public class Carrera {
    public static void main(String[] args) {
        int opcion;
        
        //Crea un curso
        Curso curso = new Curso ("Algebra");
        Alumno alum1 = new Alumno(1,"Gomez","Pedro");
        curso.inscribirAlumno(alum1);
        
        Alumno alum2 = new Alumno(2,"Dominguez","Pedro");
        curso.inscribirAlumno(alum2);
        
        Alumno alum3 = new Alumno(3,"Vasquez","Tito");
        curso.inscribirAlumno(alum3);
        
        Alumno alum4 = new Alumno(4,"Vasquez","Maria");
        curso.inscribirAlumno(alum4); 
        
        alum1.setNota1(10.0);
        alum1.setNota2(9.0);
        System.out.println(curso.cantidadDeAlumnos());
        curso.quitarAlumno(alum4);
        System.out.println(curso.cantidadDeAlumnos());
        curso.mostrarInscriptos();
        System.out.println(curso.buscarAlumno(1).nomYApe());
        System.out.println(curso.buscarAlumno(1).promedio());
    }
}
