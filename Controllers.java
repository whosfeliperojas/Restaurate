package com.example.Restaurante.Controllers;

import com.example.Restaurante.Entitys.Reservacion;
import com.example.Restaurante.Repository.ReservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
@Controller
@RequestMapping("/restaurante")
public class Controllers {

    private final ReservacionRepository reservacionRepository;

    @Autowired
    public Controllers(ReservacionRepository reservacionRepository) {
        this.reservacionRepository = reservacionRepository;
    }
    @GetMapping("/inicio")
    public String index() {
        return "index";
    }

    @GetMapping("/contactanos")
    public String contacto(){
        return "contacto";
    }

    @GetMapping("/eventos")
    public String eventos(){
        return "eventos";
    }

    @GetMapping("/galerias")
    public String galeria(){
        return "galeria";
    }

    @GetMapping("/menus")
    public String menu(){
        return "menus";
    }

    @GetMapping("/pedidos")
    public String pedidos(){
        return "pedidosOnline";
    }

    @GetMapping("/reservas")
    public String reserva(Model model) {
        model.addAttribute("reservacion", new Reservacion());
        return "reservacion";
    }


    @PostMapping("/reservacion")
    public String reservar(Reservacion reservacion) {

        reservacionRepository.save(reservacion);
        return "redirect:/restaurante/inicio";
    }
}
