package com.example.Upiiz.Controller;

import com.example.Upiiz.Model.FormulasModel;
import com.example.Upiiz.Services.FormulasService;
import com.example.Upiiz.Services.PerfumesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/formulas")
public class FormulasController {

    @Autowired
    FormulasService formulasService;

    @Autowired
    PerfumesService perfumesService;

    // Listar fórmulas
    @GetMapping
    public String formulas(Model model) {
        List<FormulasModel> formulas = formulasService.getAllFormulas();
        model.addAttribute("formulas", formulas);
        return "formulas";
    }

    // Ver fórmula
    @GetMapping("/ver/{id}")
    public String verFormula(@PathVariable Integer id, Model model) {
        FormulasModel formula = formulasService.getFormulaById(id);
        model.addAttribute("formula", formula);
        // También agregamos la información del perfume relacionado
        model.addAttribute("perfume", perfumesService.getPerfumeById(formula.getPerfumes_id_perfume()));
        return "formulas_ver";
    }

    // Nuevo fórmula
    @GetMapping("/nuevo")
    public String nuevaFormula(Model model) {
        // Se necesita la lista de perfumes para relacionarlos con la fórmula
        model.addAttribute("perfumes", perfumesService.getAllPerfumes());
        return "formulas_nuevo";
    }

    // Guardar fórmula
    @PostMapping("/guardar")
    public String guardarFormula(FormulasModel formula) {
        formulasService.agregarFormula(formula);
        return "redirect:/formulas";
    }

    // Editar fórmula
    @GetMapping("/editar/{id}")
    public String editarFormula(@PathVariable Integer id, Model model) {
        FormulasModel formula = formulasService.getFormulaById(id);
        model.addAttribute("formula", formula);
        model.addAttribute("perfumes", perfumesService.getAllPerfumes());
        return "formulas_editar";
    }

    // Actualizar fórmula
    @PostMapping("/actualizar")
    public String actualizarFormula(FormulasModel formula) {
        formulasService.editarFormula(formula);
        return "redirect:/formulas";
    }

    // Eliminar fórmula
    @PostMapping("/eliminar/{id}")
    public String eliminarFormula(@PathVariable Integer id) {
        formulasService.eliminarFormula(id);
        return "redirect:/formulas";
    }
}
