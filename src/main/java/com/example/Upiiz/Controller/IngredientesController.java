package com.example.Upiiz.Controller;

import com.example.Upiiz.Model.IngredientesModel;
import com.example.Upiiz.Services.IngredientesService;
import com.example.Upiiz.Services.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredientes")
public class IngredientesController {

    @Autowired
    IngredientesService ingredientesService;

    @Autowired
    ProveedoresService proveedoresService;

    // Listar ingredientes
    @GetMapping
    public String ingredientes(Model model) {
        model.addAttribute("ingredientes", ingredientesService.getAllIngredientes());
        return "ingredientes";
    }

    // Ver ingrediente
    @GetMapping("/ver/{id}")
    public String verIngrediente(@PathVariable Integer id, Model model) {
        model.addAttribute("ingrediente", ingredientesService.getIngredienteById(id));
        model.addAttribute("proveedor", proveedoresService.getProveedoresBasico());
        return "ingredientes_ver";
    }

    // Nuevo ingrediente
    @GetMapping("/nuevo")
    public String nuevoIngrediente(Model model) {
        model.addAttribute("proveedores", proveedoresService.getProveedoresBasico());
        return "ingredientes_nuevo";
    }

    // Guardar ingrediente
    @PostMapping("/guardar")
    public String guardarIngrediente(IngredientesModel ingrediente) {
        ingredientesService.agregarIngrediente(ingrediente);
        return "redirect:/ingredientes";
    }

    // Editar ingrediente
    @GetMapping("/editar/{id}")
    public String editarIngrediente(@PathVariable Integer id, Model model) {
        model.addAttribute("ingrediente", ingredientesService.getIngredienteById(id));
        model.addAttribute("proveedores", proveedoresService.getProveedoresBasico());
        return "ingredientes_editar";
    }

    // Actualizar ingrediente
    @PostMapping("/actualizar")
    public String actualizarIngrediente(IngredientesModel ingrediente) {
        ingredientesService.editarIngrediente(ingrediente);
        return "redirect:/ingredientes";
    }

    // Eliminar ingrediente
    @PostMapping("/eliminar/{id}")
    public String eliminarIngrediente(@PathVariable Integer id) {
        ingredientesService.eliminarIngrediente(id);
        return "redirect:/ingredientes";
    }
}

