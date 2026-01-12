package com.example.Upiiz.Services;

import com.example.Upiiz.Model.ClientesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // Busca todos los clientes
    public List<ClientesModel> getallClientes(){
        return jdbcTemplate.query("SELECT * FROM clientes",
                new BeanPropertyRowMapper<ClientesModel>(ClientesModel.class));
    }
    //Ver cliente por id
    public ClientesModel getClienteById(Integer id_cliente) {
        String sql = "SELECT * FROM clientes WHERE id_cliente = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(ClientesModel.class),
                id_cliente
        );
    }
    //Agregar un nuevo cliente
    public void agregarCliente(ClientesModel cliente) {
        cliente.setFecha_registro(
                new java.sql.Date(System.currentTimeMillis())
        );
        jdbcTemplate.update(
                "INSERT INTO clientes (rfc, nombre, ap_paterno, " +
                        "ap_materno, tipo, correo, telefono, direccion_envio, " +
                        "fecha_registro) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                cliente.getRfc(),
                cliente.getNombre(),
                cliente.getAp_paterno(),
                cliente.getAp_materno(),
                cliente.getTipo(),
                cliente.getCorreo(),
                cliente.getTelefono(),
                cliente.getDireccion_envio(),
                cliente.getFecha_registro()
        );
    }


    //Editar cliente
    public void editarCliente(ClientesModel cliente){
        jdbcTemplate.update("UPDATE clientes SET rfc=?, " +
                        "nombre=?, ap_paterno=?, ap_materno=?, tipo=?, " +
                        "correo=?, telefono=?, direccion_envio=? WHERE id_cliente=?",
                cliente.getRfc(),
                cliente.getNombre(), cliente.getAp_paterno(),
                cliente.getAp_materno(), cliente.getTipo(),
                cliente.getCorreo(), cliente.getTelefono(), cliente.getDireccion_envio(),
                cliente.getId_cliente());
        System.out.println("Cliente editado");
    }
    //Eliminar clientes
    public void eliminarCliente(Integer id_cliente){
        jdbcTemplate.update("DELETE FROM clientes WHERE id_cliente=?", id_cliente);
    }
}
