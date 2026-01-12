package com.example.Upiiz.Controller;

import com.example.Upiiz.Model.PerfumesModel;
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
@RequestMapping("/perfumes")
public class PerfumesController {

    @Autowired
    PerfumesService perfumesService;

    @GetMapping
    public String perfumes(Model model) {
        List<PerfumesModel> perfumes = perfumesService.getAllPerfumes();
        model.addAttribute("perfumes", perfumes);
        return "perfumes";
    }

    // Ver perfume
    @GetMapping("/ver/{id}")
    public String verPerfume(Model model, @PathVariable("id") Integer id) {
        PerfumesModel perfume = perfumesService.getPerfumeById(id);
        model.addAttribute("perfume", perfume);
        return "perfumes_ver";
    }

    // Añadir nuevo perfume (GET)
    @GetMapping("/nuevo")
    public String nuevoPerfume() {
        return "perfumes_nuevo";
    }

    // Guardar nuevo perfume
    @PostMapping("/guardar")
    public String guardarPerfume(PerfumesModel perfume) {
        perfumesService.agregarPerfume(perfume);
        return "redirect:/perfumes";
    }

    // Editar perfume
    @GetMapping("/editar/{id}")
    public String editarPerfume(Model model, @PathVariable("id") Integer id) {
        PerfumesModel perfume = perfumesService.getPerfumeById(id);
        model.addAttribute("perfume", perfume);
        return "perfumes_editar";
    }

    // Guardar perfume editado
    @PostMapping("/actualizar")
    public String guardarPerfumeEditado(PerfumesModel perfume) {
        perfumesService.editarPerfume(perfume);
        return "redirect:/perfumes";
    }

    // Eliminar perfume
    @PostMapping("/eliminar/{id}")
    public String eliminarPerfume(@PathVariable("id") Integer id) {
        perfumesService.eliminarPerfume(id);
        return "redirect:/perfumes";
    }
}
