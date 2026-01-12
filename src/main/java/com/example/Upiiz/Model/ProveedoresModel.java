package com.example.Upiiz.Model;

public class ProveedoresModel {
    private int id_proveedor;
    private String nombre;
    private String tipo_servicio;
    private String telefono;
    private String direccion;
    private String condiciones_pago;
    private int calificacion;
    private String nombre_contacto;
    private String ap_paterno_contacto;
    private String ap_materno_contacto;

    public ProveedoresModel() {
    }
    public ProveedoresModel(int id_proveedor, String nombre, String tipo_servicio, String telefono, String direccion, String condiciones_pago, int calificacion, String nombre_contacto, String ap_paterno_contacto, String ap_materno_contacto) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.tipo_servicio = tipo_servicio;
        this.telefono = telefono;
        this.direccion = direccion;
        this.condiciones_pago = condiciones_pago;
        this.calificacion = calificacion;
        this.nombre_contacto = nombre_contacto;
        this.ap_paterno_contacto = ap_paterno_contacto;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCondiciones_pago() {
        return condiciones_pago;
    }

    public void setCondiciones_pago(String condiciones_pago) {
        this.condiciones_pago = condiciones_pago;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getAp_paterno_contacto() {
        return ap_paterno_contacto;
    }

    public void setAp_paterno_contacto(String ap_paterno_contacto) {
        this.ap_paterno_contacto = ap_paterno_contacto;
    }

    public String getAp_materno_contacto() {
        return ap_materno_contacto;
    }

    public void setAp_materno_contacto(String ap_materno_contacto) {
        this.ap_materno_contacto = ap_materno_contacto;
    }
}
