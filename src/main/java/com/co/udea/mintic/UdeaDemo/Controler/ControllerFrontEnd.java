package com.co.udea.mintic.UdeaDemo.Controler;

import com.co.udea.mintic.UdeaDemo.Repository.EntityPersona;
import com.co.udea.mintic.UdeaDemo.Services.ServicePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
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
    public String home (Model model, @AuthenticationPrincipal OidcUser principal){

        return "home.html";

    }



    @GetMapping(path = "/listaPersonas")
    public String pagina2 (Model modelo, @AuthenticationPrincipal OidcUser principal){

        if (principal != null){
            List<EntityPersona> listPersonas = servicePersona.listarTodoJPA();
            modelo.addAttribute("personas", listPersonas);

            return "listaPersonas.html";
        }

        return "home.html";

    }

    @GetMapping(path = "/crearPersona")
    public String crearPersona(Model modelo, @AuthenticationPrincipal OidcUser principal) {

        if (principal != null) {
            modelo.addAttribute("Npersona", new EntityPersona());

            return "crearPersona.html";
        }
        return "home.html";
    }

    @GetMapping(path = "/editarPersona/{id}")
    public String editarPersona(Model modelo, @AuthenticationPrincipal OidcUser principal, @PathVariable Long id) {

        if (principal != null){
            EntityPersona personaTemp = servicePersona.buscarPersonaId(id);
            modelo.addAttribute("Epersona", personaTemp);

            return "editarPersona.html";

        }
        return "home.html";
    }

}
