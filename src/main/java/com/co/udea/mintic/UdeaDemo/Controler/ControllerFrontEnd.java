package com.co.udea.mintic.UdeaDemo.Controler;

import com.co.udea.mintic.UdeaDemo.Repository.EntityPersona;
import com.co.udea.mintic.UdeaDemo.Services.ServicePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class ControllerFrontEnd {
    @Autowired
    ServicePersona servicePersona;

    @GetMapping(path = "/")
    public String home (){

        return "index2.html";

    }
    @GetMapping(path = "/pagina2")
    public String pagina2 (Model modelo){

        List<EntityPersona> listPersonas = servicePersona.listarTodoJPA();
        modelo.addAttribute("personas" , listPersonas);

        return "pagina2.html";
    }
}
