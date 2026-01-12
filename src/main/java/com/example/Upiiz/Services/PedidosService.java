package com.example.Upiiz.Services;

import com.example.Upiiz.Model.PedidosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Buscar todos los pedidos
    public List<PedidosModel> getAllPedidos() {
        return jdbcTemplate.query(
                "SELECT * FROM pedidos",
                new BeanPropertyRowMapper<>(PedidosModel.class)
        );
    }

    // Ver pedido por ID
    public PedidosModel getPedidoById(Integer id_pedido) {
        String sql = "SELECT * FROM pedidos WHERE id_pedido = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(PedidosModel.class),
                id_pedido
        );
    }

    // Agregar nuevo pedido
    public void agregarPedido(PedidosModel pedido) {
        jdbcTemplate.update(
                "INSERT INTO pedidos (fecha_pedido, fecha_entrega, estado, total, id_cliente) " +
                        "VALUES (?, ?, ?, ?, ?)",
                pedido.getFecha_pedido(),
                pedido.getFecha_entrega(),
                pedido.getEstado(),
                pedido.getTotal(),
                pedido.getId_cliente()
        );
    }

    // Editar pedido
    public void editarPedido(PedidosModel pedido) {
        jdbcTemplate.update(
                "UPDATE pedidos SET fecha_pedido=?, fecha_entrega=?, estado=?, total=?, id_cliente=? " +
                        "WHERE id_pedido=?",
                pedido.getFecha_pedido(),
                pedido.getFecha_entrega(),
                pedido.getEstado(),
                pedido.getTotal(),
                pedido.getId_cliente(),
                pedido.getId_pedido()
        );
    }

    // Eliminar pedido
    public void eliminarPedido(Integer id_pedido) {
        jdbcTemplate.update(
                "DELETE FROM pedidos WHERE id_pedido = ?",
                id_pedido
        );
    }
}
