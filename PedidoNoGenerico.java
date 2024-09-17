import java.util.*;
import java.text.SimpleDateFormat; 

public class PedidoNoGenerico {
    private Calendar fecha;
    private ArrayList productos;  
    private Cliente cliente;
   
    public PedidoNoGenerico(Calendar p_fecha, Cliente p_cliente, Producto p_producto) {
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(new ArrayList());  
        this.agregarProducto(p_producto);
    }
    
    public PedidoNoGenerico(Calendar p_fecha, Cliente p_cliente) {
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(new ArrayList());  
    }
    
    private void setFecha(Calendar p_fecha) {
        this.fecha = p_fecha;
    }

    private void setCliente(Cliente p_cliente) {
        this.cliente = p_cliente;
    }

    private void setProductos(ArrayList p_producto) {  
        this.productos = p_producto;
    }
    
    public Calendar getFecha() {
        return this.fecha;
    }

    public ArrayList getProductos() {  
        return this.productos;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }

    public boolean agregarProducto(Producto p_producto) {
        return this.getProductos().add(p_producto);
    }

    public void mostrar() {
        double acumLista = 0;
        double acumContado = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = sdf.format(this.getFecha().getTime());
        System.out.println("****** Detalle del pedido ****** Fecha: " + fechaFormateada);
        System.out.println("Producto \tPrecio lista \tPrecio Contado");

        for (Object unProducto : this.getProductos()) {
            Producto producto = (Producto) unProducto;  
            System.out.println(producto.getDescripcion() + " \t" + producto.precioLista() + "  \t " + producto.precioContado());
            acumLista += producto.precioLista();
            acumContado += producto.precioContado();
        }

        System.out.println("*** Total: " + "  \t " + acumLista + "  \t " + acumContado);
    }
}
