package com.example.Upiiz.Services;

import com.example.Upiiz.Model.ProveedoresModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedoresService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Buscar todos los proveedores
    public List<ProveedoresModel> getAllProveedores() {
        return jdbcTemplate.query(
                "SELECT * FROM proveedores",
                new BeanPropertyRowMapper<>(ProveedoresModel.class)
        );
    }

    // Ver proveedor por ID
    public ProveedoresModel getProveedorById(Integer id_proveedor) {
        String sql = "SELECT * FROM proveedores WHERE id_proveedor = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(ProveedoresModel.class),
                id_proveedor
        );
    }

    // Agregar nuevo proveedor
    public void agregarProveedor(ProveedoresModel proveedor) {
        jdbcTemplate.update(
                "INSERT INTO proveedores (nombre, tipo_servicio, telefono, direccion, " +
                        "condiciones_pago, calificacion, nombre_contacto, " +
                        "ap_paterno_contacto, ap_materno_contacto) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                proveedor.getNombre(),
                proveedor.getTipo_servicio(),
                proveedor.getTelefono(),
                proveedor.getDireccion(),
                proveedor.getCondiciones_pago(),
                proveedor.getCalificacion(),
                proveedor.getNombre_contacto(),
                proveedor.getAp_paterno_contacto(),
                proveedor.getAp_materno_contacto()
        );
    }

    // Editar proveedor
    public void editarProveedor(ProveedoresModel proveedor) {
        jdbcTemplate.update(
                "UPDATE proveedores SET nombre=?, tipo_servicio=?, telefono=?, direccion=?, " +
                        "condiciones_pago=?, calificacion=?, nombre_contacto=?, " +
                        "ap_paterno_contacto=?, ap_materno_contacto=? WHERE id_proveedor=?",
                proveedor.getNombre(),
                proveedor.getTipo_servicio(),
                proveedor.getTelefono(),
                proveedor.getDireccion(),
                proveedor.getCondiciones_pago(),
                proveedor.getCalificacion(),
                proveedor.getNombre_contacto(),
                proveedor.getAp_paterno_contacto(),
                proveedor.getAp_materno_contacto(),
                proveedor.getId_proveedor()
        );
        System.out.println("Proveedor editado");
    }

    // Eliminar proveedor
    public void eliminarProveedor(Integer id_proveedor) {
        jdbcTemplate.update(
                "DELETE FROM proveedores WHERE id_proveedor = ?",
                id_proveedor
        );
    }
}
