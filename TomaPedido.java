
import java.util.*;
/**
 * Write a description of class TomaPedido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TomaPedido
{
   public static void main(String [] args){

       /*1. simular un pedido de productos para un determinado cliente */
       Calendar fechaIngreso = new GregorianCalendar(2024, Calendar.SEPTEMBER, 02);
       // 1.1- Instanciar un cliente
       Cliente c1 = new Cliente(1234, "Cintas", "Alejandro", 3000.0);
       // 1.2- Instanciar un laboratorio
       Laboratorio l1 = new Laboratorio("Genoma Lab", "Av. Caceres 453", "123-456743", 10, 10);
       // 1.3- Instanciar un producto
       Producto p1 = new Producto(1, "Perfumeria", "jabon asepxia", 1000.0, l1);
       // 1.4- Instanciar un nuevo pedido
       Pedido pedido1 = new Pedido(fechaIngreso, c1, p1);  
       // 1.5- Instanciar un segundo producto
       Producto p2 = new Producto(2, "Medicamentos", "Tukol", 4000.0, l1);
       // 1.6- Agregar el segundo producto al pedido
       pedido1.agregarProducto(p2);
       
       
       /*2. Listar los totales */
       System.out.println(String.format("%-30s\t%-15.2f\t%-15.2f", "*** Total:", pedido1.totalFinanciado(), pedido1.totalAlContado()));
        
       /*3. quitar un producto del pedido*/
       pedido1.eliminarProducto(p2);
       
       /*4. volver a listar los totales */
       System.out.println(String.format("%-30s\t%-15.2f\t%-15.2f", "*** Total:", pedido1.totalFinanciado(), pedido1.totalAlContado()));
       
       /*5. emitir el detalle del pedido */
       pedido1.mostrar();
       
       System.out.println("\n\n\n***Mostrar detalle completo***");
       pedido1.mostrar();
       System.out.println(String.format("%-30s\t%-15.2f\t%-15.2f", "*** Total:", pedido1.totalFinanciado(), pedido1.totalAlContado()));
       
       
   }
}
