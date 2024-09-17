
import java.util.*;
public class Agenda{
    private ArrayList contactos;
     
     
    public Agenda(Contacto p_contacto) {
        this.setContactos(new ArrayList());
        this.agregarContacto(p_contacto);
    
    }
    
    
    public ArrayList getContactos(){
        return this.contactos;
    }
    
    
    public void setContactos(ArrayList p_contactos) {
        this.contactos = p_contactos;
    }
    
    
    public boolean agregarContacto(Contacto p_contacto){
        return this.getContactos().add(p_contacto);
    }
    
    
    public boolean quitarContacto(Contacto p_contacto){
        return this.getContactos().remove(p_contacto);
    }
    
    
    public int cuantosContactos(){
        return this.getContactos().size();
    }
    
    
    public void mostrarAgenda(){
     
        for (Object unContacto : this.getContactos()){
            Contacto contacto = (Contacto) unContacto;
        }
     
    }
}
