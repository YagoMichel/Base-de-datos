package com.example.Upiiz.Model;

public class IngredientesModel {

    private Integer id_ingredientes;
    private String nombre;
    private String tipo;
    private String unidad_medida;
    private Integer stock_actual;
    private Double costo_unitario;
    private Integer nivel_orden;
    private Integer proveedores_id_proveedor;

    public IngredientesModel() {
    }
    public IngredientesModel(Integer id_ingredientes, String nombre, String tipo, String unidad_medida, Integer stock_actual, Double costo_unitario, Integer nivel_orden, Integer proveedores_id_proveedor) {
        this.id_ingredientes = id_ingredientes;
        this.nombre = nombre;
        this.tipo = tipo;
        this.unidad_medida = unidad_medida;
        this.stock_actual = stock_actual;
        this.costo_unitario = costo_unitario;
        this.nivel_orden = nivel_orden;
        this.proveedores_id_proveedor = proveedores_id_proveedor;
    }

    public Integer getId_ingredientes() {
        return id_ingredientes;
    }

    public void setId_ingredientes(Integer id_ingredientes) {
        this.id_ingredientes = id_ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public Integer getStock_actual() {
        return stock_actual;
    }

    public void setStock_actual(Integer stock_actual) {
        this.stock_actual = stock_actual;
    }

    public Double getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(Double costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

    public Integer getNivel_orden() {
        return nivel_orden;
    }

    public void setNivel_orden(Integer nivel_orden) {
        this.nivel_orden = nivel_orden;
    }

    public Integer getProveedores_id_proveedor() {
        return proveedores_id_proveedor;
    }

    public void setProveedores_id_proveedor(Integer proveedores_id_proveedor) {
        this.proveedores_id_proveedor = proveedores_id_proveedor;
    }
}
