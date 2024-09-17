import java.util.HashMap;

/**
 * Write a description of class Curso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Curso
{
    private String nombre;
    private HashMap<Integer, Alumno> alumnos;
    
    public Curso(String p_nombre)
    {
       this.setNombre(p_nombre);
       this.setAlumnos(new HashMap<>());
    }
    public Curso(String p_nombre, HashMap<Integer, Alumno> p_alumnos){
         this.setNombre(p_nombre);
         this.setAlumnos(p_alumnos);
    }
    
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    private void setAlumnos(HashMap<Integer, Alumno> p_alumnos) {
        this.alumnos = p_alumnos;
    }
    public String getNombre() {
        return this.nombre;
    }
    public HashMap<Integer, Alumno> getAlumnos(){
        return this.alumnos;
    }
    
    public void inscribirAlumno(Alumno p_alumno){
        this.getAlumnos().put(p_alumno.getLu(), p_alumno);
    }
    
    public void quitarAlumno(Alumno p_alumno){
        this.getAlumnos().remove(p_alumno.getLu(), p_alumno);
    }
    
    public int cantidadDeAlumnos() {
        return this.getAlumnos().size();
    }

    public boolean estaInscripto(int p_lu) {
        return this.getAlumnos().containsKey(p_lu);
    }
    
    public boolean estaInscripto(Alumno p_alumno) {
        return this.getAlumnos().containsValue(p_alumno);
    }
    
    public Alumno buscarAlumno(int p_lu) {
        return this.getAlumnos().get(p_lu);
    }
    
    public void imprimirPromedioDelAlumno(int p_lu) {
        Alumno alumno = buscarAlumno(p_lu);
        if (estaInscripto(p_lu)) {
            System.out.println("\n****-- Mostrar promedio del alumno " + alumno.getLu() + "--****");
            System.out.println("Promedio: " + alumno.promedio());
        } else {
            System.out.println("El alumno con LU " + p_lu + " no esta inscrito en el curso.");
        }
    }
    
    public void mostrarInscriptos() {
        System.out.println("\n****-- Alumnos inscriptos en el curso: " + this.getAlumnos().size());
        for (Alumno alumno : alumnos.values()) {
            System.out.println(alumno.getLu() + " " + alumno.getNombre());
        }
    }
}
