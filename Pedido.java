import java.util.*;
import java.text.SimpleDateFormat; 

public class Pedido {
    private Calendar fecha;
    private ArrayList<Producto> productos;
    private Cliente cliente;

    public Pedido(Calendar p_fecha, Cliente p_cliente, Producto p_producto) {
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(new ArrayList<>()); // Inicializar la lista de productos
        this.agregarProducto(p_producto);
    }

    public Pedido(Calendar p_fecha, Cliente p_cliente) {
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(new ArrayList<>());
    }

    private void setFecha(Calendar p_fecha) {
        this.fecha = p_fecha;
    }

    private void setCliente(Cliente p_cliente) {
        this.cliente = p_cliente;
    }

    private void setProductos(ArrayList<Producto> p_producto) {
        this.productos = p_producto;
    }

    public Calendar getFecha() {
        return this.fecha;
    }

    public ArrayList<Producto> getProductos() {
        return this.productos;
    }

    public Cliente getCiente() {
        return this.cliente;
    }

    public boolean agregarProducto(Producto p_producto) {
        return this.getProductos().add(p_producto);
    }
    
    public boolean eliminarProducto(Producto p_producto) {
        return this.getProductos().remove(p_producto);
    }

    public double totalAlContado() {
        double totalContado = 0;
        for (Producto producto : this.getProductos()) {
            totalContado += producto.precioContado();
        }
        return totalContado;
    }

    public double totalFinanciado() {
        double totalLista = 0;
        for (Producto producto : this.getProductos()) {
            totalLista += producto.precioLista();
        }
        return totalLista;
    }

    public void mostrar() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = sdf.format(this.getFecha().getTime());

        System.out.println("****** Detalle del pedido ****** Fecha: " + fechaFormateada);
        System.out.println(String.format("%-30s\t%-15s\t%-15s", "Producto", "Precio lista", "Precio Contado"));
        System.out.println("---------------------------------------------------------------------------------------------------------------------");

        for (Producto unProducto : this.getProductos()) {
            System.out.println(String.format("%-30s\t%-15.2f\t%-15.2f",
                    unProducto.getDescripcion(),
                    unProducto.precioLista(),
                    unProducto.precioContado()));
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        
    }
}
