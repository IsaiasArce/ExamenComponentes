package com.cenfotec.examen.controller;


import com.cenfotec.examen.domain.Jugador;
import com.cenfotec.examen.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class JugadorController {
    @Autowired
    JugadorService jugadorService;

    @RequestMapping("/")
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = "/insertar",  method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute(new Jugador());
        return "insertar";
    }

    @RequestMapping(value = "/insertar",  method = RequestMethod.POST)
    public String insertarAction(Jugador jugador, BindingResult result, Model model) {
        jugador.setImc();
        jugadorService.save(jugador);
        return "index";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("jugadores",jugadorService.getAll());
        return "listar";
    }
    @RequestMapping("/verDetalle/{id}")
    public String recuperarJugadorPara(Model model, @PathVariable long id){
        Optional<Jugador> jugador = jugadorService.get(id);

        if (jugador.isPresent()){
            model.addAttribute("id", jugador.get().getId());
            model.addAttribute("nombre", jugador.get().getNombre());
            model.addAttribute("apellido",jugador.get().getApellido());
            model.addAttribute("fechaNacimiento", jugador.get().getFechaNacimiento());
            model.addAttribute("posicion",jugador.get().getPosicion());
            model.addAttribute("estatura", jugador.get().getEstatura());
            model.addAttribute("peso",jugador.get().getPeso());
            model.addAttribute("categoria",jugador.get().getCategoria());
            model.addAttribute("direccion",jugador.get().getDireccion());
            model.addAttribute("provincia",jugador.get().getProvincia());
            model.addAttribute("canton",jugador.get().getCanton());
            model.addAttribute("distrito",jugador.get().getDistrito());
            model.addAttribute("telefono",jugador.get().getCanton());
            model.addAttribute("email",jugador.get().getDistrito());

            model.addAttribute("imc",jugador.get().getImc());

            return "verDetalle";
        }
        return "notFound";
    }
    @RequestMapping("/actualizar/{id}")
    public String actualizarPage(Model model, @PathVariable long id){
        Optional<Jugador> jugador = jugadorService.get(id);
        Jugador jActualizado= new Jugador();
        jActualizado.setId(jugador.get().getId());

        if (jugador.isPresent()){
            model.addAttribute("nombre",jugador.get().getNombre());
            model.addAttribute("jActualizado",jActualizado);

            return "actualizar";
        }
        return "notFound";
    }
    @RequestMapping(value = "/actualizar/{id}",  method = RequestMethod.POST)
    public String actualizarAction(Jugador jugador,  Model model, @PathVariable long id) {
        jugadorService.update(jugador);
        return "index";
    }


}
