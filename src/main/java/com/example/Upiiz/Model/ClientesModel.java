package com.example.Upiiz.Model;

import java.util.Date;

public class ClientesModel {
    private Integer id_cliente;
    private String rfc;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private String tipo;
    private String correo;
    private String telefono;
    private String direccion_envio;
    private Date fecha_registro;

    public ClientesModel() {
    }
    public ClientesModel(Integer id_cliente, String rfc, String nombre, String ap_paterno, String ap_materno, String tipo, String correo, String telefono, String direccion_envio, Date fecha_registro) {
        this.id_cliente = id_cliente;
        this.rfc = rfc;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.tipo = tipo;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion_envio = direccion_envio;
        this.fecha_registro = fecha_registro;
    }
    public Integer getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }
    public String getRfc() {
        return rfc;
    }
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getAp_paterno() {
        return ap_paterno;
    }
    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }
    public String getAp_materno() {
        return ap_materno;
    }
    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion_envio() {
        return direccion_envio;
    }
    public void setDireccion_envio(String direccion_envio) {
        this.direccion_envio = direccion_envio;
    }
    public Date getFecha_registro() {
        return fecha_registro;
    }
    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

}
