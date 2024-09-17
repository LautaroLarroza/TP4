import java.util.ArrayList;

/**
 * Write a description of class Banco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Banco {
    private String nombre;
    private int nroSucursal;
    private Localidad localidad;
    private ArrayList empleados;
    private ArrayList cuentasBancarias;

    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, Empleado p_empleado) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(new ArrayList());
        this.agregarEmpleado(p_empleado); 
        this.setCuentasBancarias(new ArrayList());
    }

    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList p_empleados) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
        //this.setCuentasBancarias(new ArrayList()); 
    }

    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList p_empleados, ArrayList p_cuentas) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
        this.setCuentasBancarias(p_cuentas);
    }

    // Setters
    public void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    public void setNroSucursal(int p_nroSucursal) {
        this.nroSucursal = p_nroSucursal;
    }

    public void setLocalidad(Localidad p_localidad) {
        this.localidad = p_localidad;
    }

    public void setEmpleados(ArrayList p_empleados) {
        this.empleados = p_empleados;
    }

    public void setCuentasBancarias(ArrayList p_cuentasBancarias) {
        this.cuentasBancarias = p_cuentasBancarias;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public int getNroSucursal() {
        return this.nroSucursal;
    }

    public Localidad getLocalidad() {
        return this.localidad;
    }

    public ArrayList getEmpleados() {
        return this.empleados;
    }

    public ArrayList getCuentasBancarias() {
        return this.cuentasBancarias;
    }

    // Método para agregar un empleado
    public boolean agregarEmpleado(Empleado p_empleado) {
        return this.getEmpleados().add(p_empleado);
    }
    
    // Método para quitar un empleado
    public boolean quitarEmpleado(Empleado p_empleado){
        return this.getEmpleados().remove(p_empleado);
    }
    
    // Método para agregar una cuenta bancaria
    public boolean agregarCuentaBancaria(CuentaBancaria p_cuenta){
        return this.getCuentasBancarias().add(p_cuenta);
    }
    
    // Método para quitar una cuenta bancaria
    public boolean quitarCuentaBancaria(CuentaBancaria p_cuenta){
        return this.getCuentasBancarias().remove(p_cuenta);
    }
    
    private int cuentasSaldoActivo(){
        int cuentasActivas=0;
        for(Object unaCuenta : this.getCuentasBancarias()){
            CuentaBancaria cuenta = (CuentaBancaria) unaCuenta; 
            if(cuenta.getSaldo() > 0){
                cuentasActivas++;
            }
        }
        return cuentasActivas;
    }
    
    public void listarCuentasConSaldoCero() {
        System.out.println("Cuentas sin saldo:");
        System.out.println(String.format("%-20s %-40s", "Cuenta", "Apellido y Nombre"));
        System.out.println("-----------------------------------------------------------");
    
        for (Object unaCuenta : this.getCuentasBancarias()) {
            CuentaBancaria cuenta = (CuentaBancaria) unaCuenta;
            if (cuenta.getSaldo() == 0) {
                System.out.println(String.format("%-20s %-40s",
                    cuenta.getNroCuenta(),
                    cuenta.getPersona().nomYApe()));
            }
        }
    }
    
    
    public void listarSueldos(){
        for(Object unEmpleado : this.getEmpleados()){
            Empleado empleado  = (Empleado) unEmpleado;
            System.out.println(empleado.getCuil() + " " + empleado.apeYNom() +  " ----------- " + empleado.sueldoNeto());
        }
    }
    
    public double sueldosAPagar(){
        double sueldosPagar=0;
        for(Object unEmpleado : this.getEmpleados()){
            Empleado empleado = (Empleado) unEmpleado;
            sueldosPagar += empleado.sueldoNeto();
        }
        return sueldosPagar;
    }
    
    public void mostrar(){
        int contadorCuentas=0;
        int cuentasSaldoCero=0;
        System.out.println("Banco: " + this.getNombre() + "  \tSucursal: " + this.getNroSucursal());
        System.out.println("************************************************************");
        System.out.println("RESUMEN DE CUENTAS BANCARIAS");
        System.out.println("************************************************************");
        for(Object unaCuenta : this.getCuentasBancarias()){
            CuentaBancaria cuenta = (CuentaBancaria) unaCuenta;
            contadorCuentas++;
            if(cuenta.getSaldo() == 0){
                cuentasSaldoCero++;
            }
        }
        System.out.println("Número total de Cuentas Bancarias: " + contadorCuentas);
        System.out.println("Cuentas Activas: " + this.cuentasSaldoActivo());
        System.out.println("Cuentas Saldo Cero: " + cuentasSaldoCero);
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Cuentas sin saldo:");
        System.out.println("--- Cuenta -------------------- Apellido y Nombre ---------------");
        this.listarCuentasConSaldoCero();
        
    }
    
}
