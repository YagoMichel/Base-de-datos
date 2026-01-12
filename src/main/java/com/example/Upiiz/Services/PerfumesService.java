package com.example.Upiiz.Services;

import com.example.Upiiz.Model.PerfumesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfumesService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Buscar todos los perfumes
    public List<PerfumesModel> getAllPerfumes() {
        return jdbcTemplate.query(
                "SELECT * FROM perfumes",
                new BeanPropertyRowMapper<>(PerfumesModel.class)
        );
    }

    // Ver perfume por ID
    public PerfumesModel getPerfumeById(Integer id_perfume) {
        String sql = "SELECT * FROM perfumes WHERE id_perfume = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(PerfumesModel.class),
                id_perfume
        );
    }

    // Agregar nuevo perfume
    public void agregarPerfume(PerfumesModel perfume) {
        jdbcTemplate.update(
                "INSERT INTO perfumes (nombre, familia_olfativa, tipo_producto, " +
                        "fecha_creacion, perfumista, descripcion, precio_venta, " +
                        "costo_produccion, estado) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                perfume.getNombre(),
                perfume.getFamilia_olfativa(),
                perfume.getTipo_producto(),
                perfume.getFecha_creacion(),
                perfume.getPerfumista(),
                perfume.getDescripcion(),
                perfume.getPrecio_venta(),
                perfume.getCosto_produccion(),
                perfume.getEstado()
        );
    }


    // Editar perfume
    public void editarPerfume(PerfumesModel perfume) {
        jdbcTemplate.update(
                "UPDATE perfumes SET nombre=?, familia_olfativa=?, tipo_producto=?, " +
                        "fecha_creacion=?, perfumista=?, descripcion=?, precio_venta=?, " +
                        "costo_produccion=?, estado=? WHERE id_perfume=?",
                perfume.getNombre(),
                perfume.getFamilia_olfativa(),
                perfume.getTipo_producto(),
                perfume.getFecha_creacion(),
                perfume.getPerfumista(),
                perfume.getDescripcion(),
                perfume.getPrecio_venta(),
                perfume.getCosto_produccion(),
                perfume.getEstado(),
                perfume.getId_perfume()
        );
        System.out.println("Perfume editado");
    }

    // Eliminar perfume
    public void eliminarPerfume(Integer id_perfume) {
        jdbcTemplate.update(
                "DELETE FROM perfumes WHERE id_perfume = ?",
                id_perfume
        );
    }

}
