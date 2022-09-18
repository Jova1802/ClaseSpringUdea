package com.co.udea.mintic.UdeaDemo.Controler;

import com.co.udea.mintic.UdeaDemo.Repository.EntityPersona;
import com.co.udea.mintic.UdeaDemo.Services.ServicePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ControllerFrontEnd {
    @Autowired
    ServicePersona servicePersona;

    @GetMapping(path = "/")
    public String home (){

        return "home.html";

    }
    @GetMapping(path = "/listaPersonas")
    public String pagina2 (Model modelo){

        List<EntityPersona> listPersonas = servicePersona.listarTodoJPA();
        modelo.addAttribute("personas", listPersonas);

        return "listaPersonas.html";
    }

    @GetMapping(path = "/crearPersona")
    public String crearPersona(Model modelo) {
        modelo.addAttribute("Npersona", new EntityPersona());

        return "crearPersona.html";

    }

    @GetMapping(path = "/editarPersona/{id}")
    public String editarPersona(Model modelo, @PathVariable Long id) {

        EntityPersona personaTemp = servicePersona.buscarPersonaId(id);
        modelo.addAttribute("Epersona", personaTemp);


        return "editarPersona.html";

    }
}
