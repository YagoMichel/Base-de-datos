package com.example.Upiiz.Controller;

import com.example.Upiiz.Model.ClientesModel;
import com.example.Upiiz.Model.PedidosModel;
import com.example.Upiiz.Services.ClientesService;
import com.example.Upiiz.Services.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    PedidosService pedidosService;

    @Autowired
    ClientesService clientesService;

    // Listar pedidos
    @GetMapping
    public String pedidos(Model model) {
        List<PedidosModel> pedidos = pedidosService.getAllPedidos();
        Map<Integer, String> clientesMap = clientesService.getallClientes()
                .stream()
                .collect(Collectors.toMap(c -> c.getId_cliente(), c -> c.getNombre()));

        model.addAttribute("pedidos", pedidos);
        model.addAttribute("clientesMap", clientesMap);
        return "pedidos"; // vista: pedidos.html
    }


    // Ver pedido
    @GetMapping("/ver/{id}")
    public String verPedido(@PathVariable Integer id, Model model) {
        PedidosModel pedido = pedidosService.getPedidoById(id);
        model.addAttribute("pedido", pedido);

        // Agregar información del cliente
        ClientesModel cliente = clientesService.getClienteById(pedido.getId_cliente());
        model.addAttribute("cliente", cliente);

        return "pedidos_ver"; // vista: pedidos_ver.html
    }

    // Nuevo pedido
    @GetMapping("/nuevo")
    public String nuevoPedido(Model model) {
        // Lista de clientes para relacionar con el pedido
        model.addAttribute("clientes", clientesService.getallClientes());
        return "pedidos_nuevo"; // vista: pedidos_nuevo.html
    }

    // Guardar pedido
    @PostMapping("/guardar")
    public String guardarPedido(PedidosModel pedido) {
        pedidosService.agregarPedido(pedido);
        return "redirect:/pedidos";
    }

    // Editar pedido
    @GetMapping("/editar/{id}")
    public String editarPedido(@PathVariable Integer id, Model model) {
        PedidosModel pedido = pedidosService.getPedidoById(id);
        model.addAttribute("pedido", pedido);
        model.addAttribute("clientes", clientesService.getallClientes());
        return "pedidos_editar"; // vista: pedidos_editar.html
    }

    // Actualizar pedido
    @PostMapping("/actualizar")
    public String actualizarPedido(PedidosModel pedido) {
        pedidosService.editarPedido(pedido);
        return "redirect:/pedidos";
    }

    // Eliminar pedido
    @PostMapping("/eliminar/{id}")
    public String eliminarPedido(@PathVariable Integer id) {
        pedidosService.eliminarPedido(id);
        return "redirect:/pedidos";
    }
}
