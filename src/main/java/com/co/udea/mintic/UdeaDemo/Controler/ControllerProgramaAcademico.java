package com.co.udea.mintic.UdeaDemo.Controler;

import com.co.udea.mintic.UdeaDemo.Domain.Persona;
import com.co.udea.mintic.UdeaDemo.Services.ServiceProgramaAcademico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ControllerProgramaAcademico {

    @Autowired
    ServiceProgramaAcademico serviceProgramaAcademico;

    @GetMapping (path = "/udea/mintic/program", produces = "application/json")
    public String callServicePrograma() {

        Persona objPersona = new Persona();
        objPersona.setNombre("Carlos");
        objPersona.setApellido("Romero");
        objPersona.setEdad(24);

        String salida = serviceProgramaAcademico.inscribirAlumno(objPersona);

        return salida;
    }
    @GetMapping(path = "/udea/mintic/doWhile", produces = "application/json")
    public ArrayList doWhileController(){
        ArrayList<String> salida = new ArrayList<String>();
        salida = serviceProgramaAcademico.doWhile(4);
        return salida;
    }

}
