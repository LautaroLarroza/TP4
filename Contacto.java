

public class Contacto{
    
    private String nombre;
    private String mail;

    public Contacto(String p_nombre, String p_mail){
        this.setNombre(p_nombre);
        this.setMail(p_mail);
     }
     
    public void setNombre(String p_nombre){
        this.nombre = p_nombre;
     }
     
    public void setMail(String p_mail){
        this.mail = p_mail;
    }
    
    public String getNombre(){
        return this.nombre;
    }
 
    public String getMail(){
        return this.mail;
    }

    public String mostrarContacto(){
        return this.getNombre() + " - " + this.getMail();
    }
}