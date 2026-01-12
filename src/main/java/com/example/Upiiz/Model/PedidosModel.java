package com.example.Upiiz.Model;

import java.sql.Date;

public class PedidosModel {

    private Integer id_pedido;
    private Date fecha_pedido;
    private Date fecha_entrega;
    private String estado;
    private Float total;
    private Integer id_cliente;

    public PedidosModel() {
    }
    public PedidosModel(Integer id_pedido, Date fecha_pedido, Date fecha_entrega, String estado, Float total, Integer id_cliente) {
        this.id_pedido = id_pedido;
        this.fecha_pedido = fecha_pedido;
        this.fecha_entrega = fecha_entrega;
        this.estado = estado;
        this.total = total;
        this.id_cliente = id_cliente;
    }

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

}

