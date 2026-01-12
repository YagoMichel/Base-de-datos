package com.example.Upiiz.Services;

import com.example.Upiiz.Model.IngredientesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientesService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Buscar todos los ingredientes
    public List<IngredientesModel> getAllIngredientes() {
        return jdbcTemplate.query(
                "SELECT * FROM ingredientes",
                new BeanPropertyRowMapper<>(IngredientesModel.class)
        );
    }

    // Ver ingrediente por ID
    public IngredientesModel getIngredienteById(Integer id_ingredientes) {
        String sql = "SELECT * FROM ingredientes WHERE id_ingredientes = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(IngredientesModel.class),
                id_ingredientes
        );
    }

    // Agregar nuevo ingrediente
    public void agregarIngrediente(IngredientesModel ingrediente) {
        jdbcTemplate.update(
                "INSERT INTO ingredientes (nombre, tipo, unidad_medida, stock_actual, " +
                        "costo_unitario, nivel_orden, proveedores_id_proveedor) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)",
                ingrediente.getNombre(),
                ingrediente.getTipo(),
                ingrediente.getUnidad_medida(),
                ingrediente.getStock_actual(),
                ingrediente.getCosto_unitario(),
                ingrediente.getNivel_orden(),
                ingrediente.getProveedores_id_proveedor()
        );
    }

    // Editar ingrediente
    public void editarIngrediente(IngredientesModel ingrediente) {
        jdbcTemplate.update(
                "UPDATE ingredientes SET nombre=?, tipo=?, unidad_medida=?, stock_actual=?, " +
                        "costo_unitario=?, nivel_orden=?, proveedores_id_proveedor=? " +
                        "WHERE id_ingredientes=?",
                ingrediente.getNombre(),
                ingrediente.getTipo(),
                ingrediente.getUnidad_medida(),
                ingrediente.getStock_actual(),
                ingrediente.getCosto_unitario(),
                ingrediente.getNivel_orden(),
                ingrediente.getProveedores_id_proveedor(),
                ingrediente.getId_ingredientes()
        );
        System.out.println("Ingrediente editado");
    }

    // Eliminar ingrediente
    public void eliminarIngrediente(Integer id_ingredientes) {
        jdbcTemplate.update(
                "DELETE FROM ingredientes,nombre WHERE id_ingredientes = ?",
                id_ingredientes
        );
    }
}
