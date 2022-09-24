package com.co.udea.mintic.UdeaDemo.Controler;

import com.co.udea.mintic.UdeaDemo.Services.ServicePersona;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerDemoLegacy {

    ServicePersona services;

    public ControllerDemoLegacy(ServicePersona services) {
        this.services = services;
    }

    @RequestMapping(value = "/udea/path2")
    @ResponseBody

    public String mensaje() {
        return "Hola Mundo";
    }
}
