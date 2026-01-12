package com.example.Upiiz.Controller;

import com.example.Upiiz.Model.ProveedoresModel;
import com.example.Upiiz.Services.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/proveedores")
public class ProveedoresController {

    @Autowired
    ProveedoresService proveedoresService;

    @GetMapping
    public String proveedores(Model model) {
        List<ProveedoresModel> proveedores = proveedoresService.getAllProveedores();
        model.addAttribute("proveedores", proveedores);
        return "proveedores";
    }

    // Ver proveedor
    @GetMapping("/ver/{id}")
    public String verProveedor(Model model, @PathVariable("id") Integer id) {
        ProveedoresModel proveedor = proveedoresService.getProveedorById(id);
        model.addAttribute("proveedor", proveedor);
        return "proveedores_ver";
    }

    // Añadir nuevo proveedor (GET)
    @GetMapping("/nuevo")
    public String nuevoProveedor() {
        return "proveedores_nuevo";
    }

    // Guardar nuevo proveedor
    @PostMapping("/guardar")
    public String guardarProveedor(ProveedoresModel proveedor) {
        proveedoresService.agregarProveedor(proveedor);
        return "redirect:/proveedores";
    }

    // Editar proveedor
    @GetMapping("/editar/{id}")
    public String editarProveedor(Model model, @PathVariable("id") Integer id) {
        ProveedoresModel proveedor = proveedoresService.getProveedorById(id);
        model.addAttribute("proveedor", proveedor);
        return "proveedores_editar";
    }

    // Guardar proveedor editado
    @PostMapping("/actualizar")
    public String guardarProveedorEditado(ProveedoresModel proveedor) {
        proveedoresService.editarProveedor(proveedor);
        return "redirect:/proveedores";
    }

    // Eliminar proveedor
    @PostMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable("id") Integer id) {
        proveedoresService.eliminarProveedor(id);
        return "redirect:/proveedores";
    }
}

