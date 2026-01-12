package com.example.Upiiz.Services;

import com.example.Upiiz.Model.FormulasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormulasService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Buscar todas las fórmulas
    public List<FormulasModel> getAllFormulas() {
        return jdbcTemplate.query(
                "SELECT * FROM formulas",
                new BeanPropertyRowMapper<>(FormulasModel.class)
        );
    }

    // Ver fórmula por ID
    public FormulasModel getFormulaById(Integer id_formulas) {
        String sql = "SELECT * FROM formulas WHERE id_formulas = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(FormulasModel.class),
                id_formulas
        );
    }

    // Agregar nueva fórmula
    public void agregarFormula(FormulasModel formula) {
        jdbcTemplate.update(
                "INSERT INTO formulas (version, fecha_registro, observaciones, perfumes_id_perfume) " +
                        "VALUES (?, ?, ?, ?)",
                formula.getVersion(),
                formula.getFecha_registro(),
                formula.getObservaciones(),
                formula.getPerfumes_id_perfume()
        );
    }

    // Editar fórmula
    public void editarFormula(FormulasModel formula) {
        jdbcTemplate.update(
                "UPDATE formulas SET version=?, fecha_registro=?, observaciones=?, perfumes_id_perfume=? " +
                        "WHERE id_formulas=?",
                formula.getVersion(),
                formula.getFecha_registro(),
                formula.getObservaciones(),
                formula.getPerfumes_id_perfume(),
                formula.getId_formulas()
        );

    }

    // Eliminar fórmula
    public void eliminarFormula(Integer id_formulas) {
        jdbcTemplate.update(
                "DELETE FROM formulas WHERE id_formulas = ?",
                id_formulas
        );

    }
}
