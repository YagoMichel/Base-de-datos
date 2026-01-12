package com.example.Upiiz.Controller;

import com.example.Upiiz.Model.ClientesModel;
import com.example.Upiiz.Services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    ClientesService clientesService;

    @GetMapping
    public String Clientes(Model model) {
        List<ClientesModel> clientes = clientesService.getallClientes();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }
    //Ver cliente
    @GetMapping("/ver/{id}")
    public String verCliente(Model model, @PathVariable("id") Integer id){
        ClientesModel cliente = clientesService.getClienteById(id);
        model.addAttribute("cliente", cliente);
        return "clientes_ver";
    }
    //Añadimos un nuevo cliente get
    @GetMapping("/nuevo")
    public String nuevoCliente() {
        return "clientes_nuevo";
    }
    //Guardamos el nuevo cliente
    @PostMapping("/guardar")
    public String guardarCliente(ClientesModel cliente) {
        clientesService.agregarCliente(cliente);
        return "redirect:/clientes";
    }
    //Editamos un nuevo cliente
    @GetMapping("/editar/{id}")
    public String editarCliente(Model model, @PathVariable("id") Integer id){
        ClientesModel cliente = clientesService.getClienteById(id);
        model.addAttribute("cliente", cliente);
        return "clientes_editar";
    }
    //Guardamos el cliente editado
    @PostMapping("/actualizar")
    public String guardarClienteEditado(ClientesModel cliente){
        clientesService.editarCliente(cliente);
        return "redirect:/clientes";
    }

    //Eliminar cliente
    @PostMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Integer id){
        clientesService.eliminarCliente(id);
        return "redirect:/clientes";
    }


}
