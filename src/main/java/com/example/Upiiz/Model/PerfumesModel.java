package com.example.Upiiz.Model;


public class PerfumesModel {
    private int id_perfume;
    private String nombre;
    private String familia_olfativa;
    private String tipo_producto;
    private String fecha_creacion;
    private String perfumista;
    private String descripcion;
    private double precio_venta;
    private double costo_produccion;
    private String estado;

    public PerfumesModel() {
    }
    public PerfumesModel(int id_perfume, String nombre, String familia_olfativa, String tipo_producto, String fecha_creacion, String perfumista, String descripcion, double precio_venta, double costo_produccion, String estado) {
        this.id_perfume = id_perfume;
        this.nombre = nombre;
        this.familia_olfativa = familia_olfativa;
        this.tipo_producto = tipo_producto;
        this.fecha_creacion = fecha_creacion;
        this.perfumista = perfumista;
        this.descripcion = descripcion;
        this.precio_venta = precio_venta;
        this.costo_produccion = costo_produccion;
    }

    public int getId_perfume() {
        return id_perfume;
    }

    public void setId_perfume(int id_perfume) {
        this.id_perfume = id_perfume;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFamilia_olfativa() {
        return familia_olfativa;
    }

    public void setFamilia_olfativa(String familia_olfativa) {
        this.familia_olfativa = familia_olfativa;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getPerfumista() {
        return perfumista;
    }

    public void setPerfumista(String perfumista) {
        this.perfumista = perfumista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public double getCosto_produccion() {
        return costo_produccion;
    }

    public void setCosto_produccion(double costo_produccion) {
        this.costo_produccion = costo_produccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
